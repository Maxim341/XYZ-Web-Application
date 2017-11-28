<%@page import="com.model.OutstandingBalance"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>XYZ Outstanding Orders</title>
        <style type="text/css">

        </style>

    </head>
    <body>

        <%
            ArrayList<OutstandingBalance> outstandingBalances = (ArrayList<OutstandingBalance>)request.getAttribute("outstandingbalances");
            
            for(int i = 0; i != outstandingBalances.size(); ++i)
            {
                out.print("Username: " + outstandingBalances.get(i).getId() + "&emsp;");
                out.print("Claim subsidy charges: " + outstandingBalances.get(i).getCharge() + "&emsp;");
                out.print("Payments made: " + outstandingBalances.get(i).getPayments() + "&emsp;");
                out.print("Outstanding Balance: " + outstandingBalances.get(i).getTotal() + "&emsp;");
                out.print("Has paid Membership: " + outstandingBalances.get(i).isPaidMembership() + "&emsp;");
                out.print("<br>");
            }
            
        %>
        <br>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="backPage" name="button" class='button'>
                Back 
            </button>
        </form>

        <br>
        <br>

    </body>
</html>