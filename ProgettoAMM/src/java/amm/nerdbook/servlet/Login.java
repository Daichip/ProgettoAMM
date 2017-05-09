/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;

import amm.nerdbook.classi.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Davide Fara
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
    HttpSession session = request.getSession(); // i dati di login vengono salvati in sessione
    // Passando come parametro false se la sessione non è mai stata creata, allora non viene creata. 
    // Scritta in questo modo, se è già creata, rende quella precedentemente creata
    
    // Quando l'utente preme logout invalida la sessione   
    if (request.getParameter("logout") != null)
    {
        session.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;
    }          
    
    if(session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) // significa che esiste un attributo di sessione "loggedIn" che dice che l'utente è loggato
    {
            request.getRequestDispatcher("Bacheca").forward(request, response); // se è loggato lo redirigo alla bacheca
            return; // chiudo la servlet
    }
    else // se non è loggato
    {
        String username = request.getParameter("userId");
        String password = request.getParameter("userPswd");
        // Questi dati sono ottenuti dal LoginForm (che ha metodo post, nel loro caso) e sono quelli del campo "name"

        if(username != null && password != null) // i due parametri non sono vuoti ed esistono
        {
            int loggedUserID = UtentiFactory.getInstance().getIdByUserAndPassword(username, password);
            
            //Se l'utente non ha registrato alcuni campi, viene rimandato al form per l'inserimento dei dati (Profilo)
            if(UtentiFactory.getInstance().getUtenteById(loggedUserID).getNome() == null || 
               UtentiFactory.getInstance().getUtenteById(loggedUserID).getCognome() == null || 
               //UtentiFactory.getInstance().getUtenteById(loggedUserID).getPassword() == null || 
               UtentiFactory.getInstance().getUtenteById(loggedUserID).getConfermaPassword() == null ||
               UtentiFactory.getInstance().getUtenteById(loggedUserID).getDataNascita() == null ||
               UtentiFactory.getInstance().getUtenteById(loggedUserID).getFrasePresentazione() == null ||  
               UtentiFactory.getInstance().getUtenteById(loggedUserID).getUrlFotoProfilo() == null ||
               //UtentiFactory.getInstance().getUtenteById(loggedUserID).getUsername() == null || 
               UtentiFactory.getInstance().getUtenteById(loggedUserID).getId() < 0)
            {
                request.getRequestDispatcher("Profilo").forward(request, response);
            }
                
            
            
            if(loggedUserID != -1)
            {
                session.setAttribute("loggedIn", true);
                session.setAttribute("loggedUserID", loggedUserID);
                // Così memorizzo in sessione le variabili che mi servono per loggare l'utente

                request.getRequestDispatcher("Bacheca").forward(request, response); // ora che è loggato lo redirigo alla bacheca
                return; // chiudo la servlet
            }
            else
            {
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    // Se i dati inseriti dall'utente sono invalidi, creo un attributo invalido di richiesta (NON di sessione) e lo rimando al form di login.
                    // Nel form viene controllato il valore di questa variabile, e in questo caso si stampa il messaggio d'errore

                    return;
            }
        
        }
    }

    request.getRequestDispatcher("login.jsp").forward(request, response); // se l'utente prova a loggare direttamente dall'URL senza passare per il login ce lo rimando

}


        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}