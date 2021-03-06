<%@page import="java.util.ArrayList"%>
<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.Member"%>
<%@page import="com.model.JDBCWrapper"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Applications</title>
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
                            <th scope="col">Full Names</th>
                            <th scope="col">Balance</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            JDBCWrapper wrapper = (JDBCWrapper) getServletContext().getAttribute("database");
                            wrapper.createStatement();
                            ArrayList<Member> m = new XYZWebApplicationDB(wrapper).getProvisionalMembers();
                            for (int i = 0; i != m.size(); ++i) {
                                out.println("<tr> <td>" + m.get(i).getUsername() + "</td> <td>" + m.get(i).getFullName() + "</td> <td>" + m.get(i).getBalance() + "</td> <td>" + m.get(i).getStatus() + "</td> </tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>

        <h2>Approve membership application:</h2>
        <h4>Please select a member from the list to approve their application.</h4>

        <form action="AdminDashboardServlet" method="post">
            <select name="memberSelected">
                <%
                    for (int j = 0; j < m.size(); j++) {
                        if (m.get(j).getStatus().equals("APPLIED")) {
                            out.println("<option value=\"" + m.get(j).getUsername() + "\">" + m.get(j).getUsername() + "</option>");
                        }
                    }
                %>
            </select>
            <br><br>
            <button type="Submit" value="approvemember" name="button" class='button'>
                Approve Member
            </button>
        </form>            


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