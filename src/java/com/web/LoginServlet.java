package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.JDBCWrapper;
import com.model.LoginController;

/**
 *
 * @author BMT
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
        LoginController loginService = new LoginController();
        String button = request.getParameter("button");

        switch (button) {
            case "Login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                loginService.readUsers();
                boolean success = authenticate(username, password);
                if (success) {
                    RequestDispatcher view = request.getRequestDispatcher("memberPage.jsp");
                    view.forward(request, response);
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                    view.forward(request, response);
                }   break;
            case "registration":
                RequestDispatcher view = request.getRequestDispatcher("registrationPage.jsp");
                view.forward(request, response);
                break;
            default:
                break;
        }
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

    public boolean authenticate(String id, String password)
    {
        JDBCWrapper wrapper = (JDBCWrapper)getServletContext().getAttribute("database");
        wrapper.createStatement();
        if (wrapper.findRecord("users", "id", id) && wrapper.findRecord("users", "password", password)) {
            return true;
        }
        return false;
    }

}
