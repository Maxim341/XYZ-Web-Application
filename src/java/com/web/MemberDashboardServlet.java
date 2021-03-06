/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import com.model.JDBCWrapper;
import com.model.Member;
import com.model.OutstandingBalance;
import com.model.User;
import com.model.XYZWebApplicationDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fraser
 */
public class MemberDashboardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        XYZWebApplicationDB databaseInterface = new XYZWebApplicationDB((JDBCWrapper) getServletContext().getAttribute("database"));
        User u;
        String page = "/Theme.jsp";
        String button = request.getParameter("button"); // Get value from button

        HttpSession session = request.getSession();      
        session.setAttribute("error", "F");

        switch (button) {
            case "outstandingBalance":
                session.setAttribute("currentpage", "Member/OutstandingBalances.jsp");
                //Need to calculate their outstanding balance
                u = (User) session.getAttribute("user");
                OutstandingBalance ob = databaseInterface.calculateOutstandingBalance(u);
                request.setAttribute("outstandingbalance", ob);
                break;
            case "claims":
                session.setAttribute("currentpage", "Member/memberClaims.jsp");
                break;
            case "changePassword":
                session.setAttribute("currentpage", "Member/ChangePassword.jsp");
                break;
            case "password":
                // Get user input
                String currentPass = request.getParameter("currentP");
                String newPass = request.getParameter("newP");
                // Connect to DB
                JDBCWrapper wrapper = (JDBCWrapper) getServletContext().getAttribute("database");
                wrapper.createStatement();

                if (currentPass.trim().isEmpty() || newPass.trim().isEmpty()) {
                    // Check if user input is empty
                    request.setAttribute("errorMessage", "1 or more field has been left blank");
                    session.setAttribute("currentpage", "Member/ChangePassword.jsp");
                    break;
                } else if (!(wrapper.findRecord("users", "password", currentPass))) {
                    // Check if currentPass is valid
                    request.setAttribute("errorMessage2", "Invalid Current Password");
                    session.setAttribute("currentpage", "Member/ChangePassword.jsp");
                    break;
                } else {
                    // If valid add new pass to DB
                    u = (User) session.getAttribute("user");
                    u.setPassword(request.getParameter("newP"));
                    databaseInterface.changePassword(u);
                    break;
                }
            case "makeclaim":
                try {
                    u = (User) session.getAttribute("user");
                    Member m = databaseInterface.getMember(u.getId());
                    String rationale = request.getParameter("rationale");
                    float claimAmount = Float.parseFloat(request.getParameter("amount"));
                    //Checks if account approved and account is over six months old. (As according to spec)

                    if (u.getStatus().trim().equals("APPROVED")) {
                        databaseInterface.makeClaim(u, rationale, claimAmount);
                    } else {
                        session.setAttribute("error", "T");
                    }
                } catch (NumberFormatException ex) {
                    session.setAttribute("error", "T2");
                }

                break;
            case "payFee":

                // IF statement to check if FEE exists in database within last year goes here
                
                // Pay set Membership fee
                u = (User) session.getAttribute("user");
                float feeAmount = (float) 10.0;
                databaseInterface.makePayment(u, "FEE", feeAmount);

                // Update outstanding balance
                OutstandingBalance ob2 = databaseInterface.calculateOutstandingBalance(u);
                request.setAttribute("outstandingbalance", ob2);
                break;
            case "payAmount":
                // Get parameters
                u = (User) session.getAttribute("user");
                String amount = request.getParameter("amount");
                session.setAttribute("currentpage", "Member/OutstandingBalances.jsp");

                if (amount.trim().isEmpty()) 
                {
                    session.setAttribute("error", "T");
                } 
                else {
                    try {
                        // Pay amount
                        u = (User) session.getAttribute("user");
                        float payAmount = Float.parseFloat(amount);
                        databaseInterface.makePayment(u, "SUBSIDY", payAmount);
                    } catch (NumberFormatException ex) {
                        session.setAttribute("error", "T");
                    }
                }
                OutstandingBalance ob3 = databaseInterface.calculateOutstandingBalance(u);
                request.setAttribute("outstandingbalance", ob3);
                break;
            case "logOut":
                session.removeAttribute("user"); // remove user session
                page = "login.jsp";
                break;
            case "backPage":
                session.setAttribute("currentpage", "Member/memberPage.jsp");
                break;
        }
        request.getRequestDispatcher(page).forward(request, response);
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
