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
        
        
        
        <div id="table-wrapper">
        <div id="table-scroll">
            <table>
                <thead>
                    <tr>
                        <th scope="col">Username</th>
                        <th scope="col">Claim subsidy and fee charges</th>
                        <th scope="col">Payments made</th>
                        <th scope="col">Outstanding balance</th>
                        <th scope="col">membership status</th>
                        
                    </tr>
                </thead>
                <tbody>


                <h2>
                    <%     
                        
            {
            ArrayList<OutstandingBalance> outstandingBalances = (ArrayList<OutstandingBalance>)request.getAttribute("outstandingbalances");
            
            for(int i = 0; i != outstandingBalances.size(); ++i)
            {
                out.print("<tr> <td><td>  " + outstandingBalances.get(i).getId()  + "<tr> <td><td>  "+ outstandingBalances.get(i).getCharge() + "<tr> <td><td>  " + outstandingBalances.get(i).getPayments()+"<tr> <td><td>  "+ outstandingBalances.get(i).getTotal()+ "<tr> <td><td>  "+
                        outstandingBalances.get(i).isPaidMembership());
 
            }
            }
                    %>
                </h2>



                </tbody>
            </table>
        </div>   
    </div>

        
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