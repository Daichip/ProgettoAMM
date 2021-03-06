/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;

import amm.nerdbook.classi.Gruppi;
import amm.nerdbook.classi.GruppiFactory;
import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.Utenti;
import amm.nerdbook.classi.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Davide Fara
 */
@WebServlet(name = "Bacheca", urlPatterns = {"/Bacheca"})
public class Bacheca extends HttpServlet {

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

        HttpSession sessione = request.getSession(false);
        
        //Per visualizzare gli utenti nella navbar
        ArrayList<Utenti> userList = UtentiFactory.getInstance().getListaUtenti();
        request.setAttribute("listaUtenti", userList);
        ArrayList<Gruppi> groupList = GruppiFactory.getInstance().getListaGruppi();
        request.setAttribute("listaGruppi", groupList);
                
        
        if (sessione != null && sessione.getAttribute("loggedIn") != null && sessione.getAttribute("loggedIn").equals(true))
        {
            String user = request.getParameter("user");
            int userID;
            
            if (user != null)
            {
                userID = Integer.parseInt(user);
            }
            else
            {
                Integer loggedUserID = (Integer)sessione.getAttribute("loggedUserID");
                userID = loggedUserID;
            }
            
            Utenti utente = UtentiFactory.getInstance().getUtenteById(userID);
            if (utente != null)
            {
                request.setAttribute("utente", utente);
                
                List<Post> posts = PostFactory.getInstance().getPostByAuthor(utente);
                request.setAttribute("posts", posts);
                
                /**************************************/
                Integer loggedUserID = (Integer)sessione.getAttribute("loggedUserID");
                Boolean testAmico = UtentiFactory.getInstance().verificaAmicizia(loggedUserID, userID);
                request.setAttribute("testAmico", testAmico);
                request.setAttribute("nomeAmico", utente.getNome());
                
                if(request.getParameter("chiediAmicizia") != null)
                {
                    UtentiFactory.getInstance().StringiAmicizia(loggedUserID, userID);
                    request.removeAttribute("ChiediAmicizia");
                }
                /**************************************/
                
                
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else // se l'utente non è loggato
        {
            request.getRequestDispatcher("Login").forward(request, response); // in questo modo, se non ho nessun utente loggato e vado in bacheca, mi rimanda al login
        }   

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