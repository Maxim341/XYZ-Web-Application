<%-- 
    Document   : OutstandingBalances
    Created on : Nov 27, 2017, 1:33:00 PM
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Claim"%>
<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.User"%>
<%@page import="com.model.JDBCWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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


        input[type=text] {
            width: 50%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
        }

    </style>


</head>
<body>



    <div id="table-wrapper">
        <div id="table-scroll">
            <table>
                <thead>
                    <tr>
                        <th scope="col">Rationale</th>
                        <th scope="col">Amount</th>

                    </tr>
                </thead>
                <tbody>


                <h2>
                    <%
                        JDBCWrapper wrapper = (JDBCWrapper) getServletContext().getAttribute("database");
                        //HttpSession session = request.getSession();
                        wrapper.createStatement();
                        ArrayList<Claim> c = (new XYZWebApplicationDB(wrapper).getMemberClaims(((User) session.getAttribute("user")).getId()));
                        for (int i = 0; i != c.size(); ++i) {
                            out.println("<tr> <td>  " + c.get(i).getRationale() + "</td> <td> <td>" + c.get(i).getDate());

                        }
                    %>
                </h2>



                </tbody>
            </table>
        </div>
    </div>

    <button type="Submit" value="payFee" name="button" class='button'>
        Pay Fee
    </button>

    <button type="Submit" value="PayAmount" name="button" class='button'>
        Pay Amount
    </button>


    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="backPage" name="button">
            Back 
        </button>
    </form>


</html>
