<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Claim"%>
<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.User"%>
<%@page import="com.model.JDBCWrapper"%>
<!DOCTYPE html>
<!-- Template by html.am -->
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

    <h1>
        Showing all claims
    </h1>

    <div id="table-wrapper">
        <div id="table-scroll">
            <table>
                <thead>
                    <tr>
                        <th scope="col">Rationale</th>
                        <th scope="col">Date</th>
                        <th scope="col">Amount (�)</th>
                        <th scope="col">Status</th>
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
                            out.println("<tr> <td>  " + c.get(i).getRationale() + "</td> <td> <td>" + c.get(i).getDate() + "</td> <td> <td>" + c.get(i).getAmount() + "</td> <td> <td> " + c.get(i).getStatus());

                        }
                    %>
                </h2>
                </tbody>
            </table>
        </div>
    </div>




    <h1>
        Make a claim

    </h1>


    <form action="MemberDashboardServlet" method="post">
        <input type="text" placeholder="rationale" name="rationale">
        <br>
        <input type="text" placeholder="amount" name="amount">
        <br>
        <button type="Submit" value="makeclaim" name="button" class='button' onclick="myFunction()" onclick="test()">
            Submit Claim
        </button>
    </form> 



    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="backPage" name="button">
            Back 
        </button>
    </form>


    <script>
        myFunction();
        function myFunction() {
            if('<%=session.getAttribute("error")%>' === "T")
            {
                alert("Your account is not approved to make further claims.");
            }
        }
    </script>
    
    <script>
        test();
        function test() {
            if('<%=session.getAttribute("error")%>' === "T2")
            {
                alert("Incorrect or empty input");
            }
        }
    </script>
    
    
</body>

</html>