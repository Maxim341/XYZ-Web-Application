<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.Claim"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.JDBCWrapper"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>XYZ List All Claims</title>
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
                            <th scope="col">Member ID</th>
                            <th scope="col">Date</th>
                            <th scope="col">Amount (£)</th>
                            <th scope="col">Rationale</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            JDBCWrapper wrapper = (JDBCWrapper) getServletContext().getAttribute("database");
                            wrapper.createStatement();
                            ArrayList<Claim> c = new XYZWebApplicationDB(wrapper).getAllClaims();
                            for (int i = 0; i != c.size(); ++i) {
                                out.println("<tr> <td> " + c.get(i).getMemid() + "</td> <td>" + c.get(i).getDate() + "</td> <td>" + c.get(i).getAmount() + "</td> <td>" + c.get(i).getRationale() + "</td> <td>" + c.get(i).getStatus() + "</td> </tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <br>       
        <form action="AdminDashboardServlet" method="post">
            <select name="selectedclaim">
                <%
                    for (int j = 0; j < c.size(); j++) {
                        if(c.get(j).getStatus().equals("APPLIED"))
                            out.println("<option value=\"" + c.get(j).getId() + "\">" + c.get(j).getId() + "</option>");
                    }
                %>
            </select>
            <br><br>
            <button type="Submit" value="approveclaim" name="button" class='button'>
                    Approve Member
            </button>
        </form>
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