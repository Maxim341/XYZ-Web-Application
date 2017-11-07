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
        <h1>Welcome: <%
       
     // create connection
            JDBCWrapper wrapper = new JDBCWrapper("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/XYZ Web Application DB", "root", "root");
            wrapper.createStatement();
            wrapper.createResultSet("SELECT * FROM users");

            // iterate through the java resultset
            while (wrapper.getResultSet().next()) {
          if(wrapper.getResultSet().last()){
                out.print(wrapper.getResultSet().getString("id"));
                out.print(" Your unique Password is: ");
                out.print(wrapper.getResultSet().getString("password"));
          }
            }
%> </h1>
                

    </body>
</html>
