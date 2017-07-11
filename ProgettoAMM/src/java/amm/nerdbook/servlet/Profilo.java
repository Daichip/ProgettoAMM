/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;

import amm.nerdbook.classi.Gruppi;
import amm.nerdbook.classi.GruppiFactory;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.Utenti;
import amm.nerdbook.classi.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Davide Fara
 */
public class Profilo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession sessione = request.getSession();
        
        //Per visualizzare gli utenti nella navbar
        ArrayList<Utenti> userList = UtentiFactory.getInstance().getListaUtenti();
        ArrayList<Gruppi> groupList = GruppiFactory.getInstance().getListaGruppi();
        request.setAttribute("listaUtenti", userList);
        request.setAttribute("listaGruppi", groupList);
        //request.setAttribute("deleteProfile", false);
        sessione.setAttribute("update", false);
        
        if(sessione.getAttribute("loggedIn") != null)
        {
            //request.setAttribute("validData", true);
            int userID;
            Integer loggedUserID = (Integer)sessione.getAttribute("loggedUserID");
            userID = loggedUserID;
            
            Utenti utente = UtentiFactory.getInstance().getUtenteById(userID);
            
            String tmp = request.getParameter("deleteProfile");
            
            if(tmp != null)
            {
                //PostFactory.getInstance().cancellaPostUtente(utente);
                UtentiFactory.getInstance().cancellaUtente(utente);
                sessione.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
            if(request.getParameter("update") != null)
            {
                request.setAttribute("userNome", request.getParameter("userNome"));
                request.setAttribute("userCognome", request.getParameter("userCognome"));
                request.setAttribute("userURLPic", request.getParameter("userURLPic"));
                request.setAttribute("username", request.getParameter("username"));
                request.setAttribute("userDataNascita", request.getParameter("userDataNascita"));
                request.setAttribute("userFraseDescrizione", request.getParameter("userFraseDescrizione"));
                request.setAttribute("userPass", request.getParameter("userPass"));
                request.setAttribute("userConfermaPass", request.getParameter("userConfermaPass"));
                
                sessione.setAttribute("update", true);
            }
            else
                request.setAttribute("utente", utente);

            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }
        else
        {
            //request.setAttribute("profileError", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }

        request.getRequestDispatcher("profilo.jsp").forward(request, response);
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
