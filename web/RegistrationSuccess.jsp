<%-- 
    Document   : RegistrationSuccess
    Created on : 07-Nov-2017, 13:07:02
    Author     : maxnethercott
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.model.LoginController"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.JDBCWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration successful.</h1>
        <h1>
            <% out.print("Welcome: " + request.getAttribute("username") + " Your unique Password is: " + request.getAttribute("password")); %> 
        </h1>
        
        <p>
            <% out.print("Any problems, please contact: " + getServletContext().getInitParameter("adminEmail")); %> 
        </p>
                

    </body>
</html>
