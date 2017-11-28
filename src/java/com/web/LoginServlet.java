package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.JDBCWrapper;
import com.model.User;
import com.model.XYZWebApplicationDB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BMT
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
        String button = request.getParameter("button");

        switch (button) {
            case "Login":
                // Get user input
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                boolean success = authenticate(username, password);
                if (success) {
                    HttpSession session = request.getSession();
                    User u = (new XYZWebApplicationDB((JDBCWrapper) getServletContext().getAttribute("database"))).getUser(username);
                    session.setAttribute("user", u);
                    
                    // Modified below section of code to direct the user to the admin or member page, depending on the status of their
                    // account.
                    RequestDispatcher view;
                    
                    if (u.getStatus().contains("ADMIN")){
                        // If admin goto admin dashboard
                        view = request.getRequestDispatcher("AdminDashboardServlet");
                        session.setAttribute("currentpage", "Admin/adminPage.jsp");                 
                    } else {
                        // if member goto member dashboard
                        view = request.getRequestDispatcher("MemberDashboardServlet");
                        session.setAttribute("currentpage", "Member/memberPage.jsp");
                    }
                    
                    view.forward(request, response);
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                    view.forward(request, response);
                }
                break;
            case "registration":
                RequestDispatcher view = request.getRequestDispatcher("registrationPage.jsp");
                view.forward(request, response);
                break;
            default:
                break;
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

    /*
    Name: authenticate
    Parameters: id, password : String
    Returns: boolean
    Comments: Takes in id and password and checks if valid
    */
    public boolean authenticate(String id, String password) {
        JDBCWrapper wrapper = (JDBCWrapper) getServletContext().getAttribute("database");
        wrapper.createStatement();
        if (wrapper.findRecord("users", "id", id) && wrapper.findRecord("users", "password", password)) {
            return true;
        }
        return false;
    }

}
