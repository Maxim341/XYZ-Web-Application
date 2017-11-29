<%@page import="com.model.OutstandingBalance"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>XYZ Outstanding Orders</title>
        <style type="text/css">
            table {
                max-width:980px;
                table-layout:fixed;
                margin:auto;
                margin-left: -200px;
            }
            th, td {
                padding:5px 10px;
                border:0px solid #000;
            }
            thead, tfoot {
                background:#f9f9f9;
                display:table;
                width:100%;
                width:calc(100% - 18px);
            }
            tbody {
                height:300px;
                overflow:auto;
                overflow-x:hidden;
                display:block;
                width:100%;
            }
            tbody tr {
                display:table;
                width:100%;
                table-layout:fixed;
            }
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
                        <%
                            {
                                ArrayList<OutstandingBalance> outstandingBalances = (ArrayList<OutstandingBalance>) request.getAttribute("outstandingbalances");

                                for (int i = 0; i != outstandingBalances.size(); ++i) {
                                    out.println("<tr> <td> " + outstandingBalances.get(i).getId() + "</td> <td>" + outstandingBalances.get(i).getCharge() + "</td> <td>" + outstandingBalances.get(i).getPayments() + "</td> <td>" + outstandingBalances.get(i).getTotal() + "</td> <td>" + outstandingBalances.get(i).isPaidMembership() + "</td> </tr>");

                                }
                            }
                        %>
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