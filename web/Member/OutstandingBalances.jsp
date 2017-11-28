<%-- 
    Document   : OutstandingBalances
    Created on : Nov 27, 2017, 1:33:00 PM
    Author     : User
--%>

<%@page import="com.model.OutstandingBalance"%>
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
                        <th scope="col">Claim subsidy + Fee charges</th>
                        <th scope="col">Payments Made</th>
                        <th scope="col">Outstanding Balance</th>
                        <th scope="col">Membership Paid</th>
                    </tr>
                </thead>
                <tbody>


                <h2>
                    <%
                            out.println("<tr> <td><td>  " + ((OutstandingBalance) request.getAttribute("outstandingbalance")).getCharge() + "</td> <td> <td>" + ((OutstandingBalance) request.getAttribute("outstandingbalance")).getPayments()
                                    + "</td> <td><td> " + ((OutstandingBalance) request.getAttribute("outstandingbalance")).getTotal() + "</td> <td><td> " + ((OutstandingBalance) request.getAttribute("outstandingbalance")).isPaidMembership());
                    %>
                </h2>



                </tbody>
            </table>
        </div>   
    </div>

    <h2>pay amount or pay fee</h2>

    <form action="MemberDashboardServlet" method="post">
           <input type="text" id="amount" placeholder="amount" name="amount">
    <br>
    <button type="Submit" value="payAmount" name="button" class='button'>
        Pay Amount
    </button>
    </form>
    <br>
    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" value="payFee" name="button" class='button'>
            Pay Fee
        </button>
    </form>




    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="backPage" name="button">
            Back 
        </button>
    </form>


</html>
