/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.JDBCWrapper;
import com.model.LoginController;
import com.model.LoginController;
import com.model.Member;
import com.model.Member;
import com.model.User;
import com.model.User;
import com.model.XYZWebApplicationDB;
import com.model.XYZWebApplicationDB;

/**
 *
 * @author Fraser
 */
@WebServlet(name = "RegServlet", urlPatterns = {"/Registration"})
public class RegServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        LoginController lc = new LoginController();
        
        String userID, fullName, address;
        Date dob = new Date();

        userID = request.getParameter("user ID");
        fullName = request.getParameter("full name");
        address = request.getParameter("address");
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        try {
            dob = df.parse(request.getParameter("DOB"));
        } catch (ParseException ex) {
            System.out.println("Parse exception");
        }
        Date dor = new Date();

        Member m = new Member(userID, fullName, address, dob, dor, "APPROVED", 0);
        User u = new User(userID, lc.createPassword(), "APPROVED");
        
        //Inserting members with data provided above^^
        new XYZWebApplicationDB().insertMember(m);
        new XYZWebApplicationDB().insertUser(u);
        
        request.setAttribute("username", u.getId());
        request.setAttribute("password", u.getPassword());
        
        RequestDispatcher view = request.getRequestDispatcher("RegistrationSuccess.jsp");
        view.forward(request, response);

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
