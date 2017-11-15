/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Harri Renney
 */
public class AdminDashboardServlet extends HttpServlet {

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
            case "listAllMembers":
                RequestDispatcher view = request.getRequestDispatcher("adminListAllMembers.jsp");
                view.forward(request, response);
                break;
            case "listAllOutstanding":
                RequestDispatcher view2 = request.getRequestDispatcher("adminListAllOutstanding.jsp");
                view2.forward(request, response);
                break;
            case "listAllClaims":
                RequestDispatcher view3 = request.getRequestDispatcher("adminListAllClaims.jsp");
                view3.forward(request, response);
                break;
            case "listApplications":
                RequestDispatcher view4 = request.getRequestDispatcher("adminListApplications.jsp");
                view4.forward(request, response);
                break;
            case "processClaim":
                RequestDispatcher view5 = request.getRequestDispatcher("adminProcessClaim.jsp");
                view5.forward(request, response);
                break;
            case "processApplication":
                RequestDispatcher view6 = request.getRequestDispatcher("adminProcessApplication.jsp");
                view6.forward(request, response);
                break;
            case "suspendResumeMember":
                RequestDispatcher view7 = request.getRequestDispatcher("adminSuspendResumeMember.jsp");
                view7.forward(request, response);
                break;
            case "annualReport":
                RequestDispatcher view8 = request.getRequestDispatcher("adminAnnualReport.jsp");
                view8.forward(request, response);
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

}
