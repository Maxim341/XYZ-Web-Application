<%-- 
    Document   : adminPage
    Created on : 31-Oct-2017, 10:58:05
    Author     : maxnethercott
--%>

<%@page import="com.model.User"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>XYZ Admin Dashboard</title>
        <style type="text/css">

            .button {
                width: 300px;
                border: 1px solid #0a3c59;
                background: #3e779d;
                background: -webkit-gradient(linear, left top, left bottom, from(#65a9d7), to(#3e779d));
                background: -webkit-linear-gradient(top, #65a9d7, #3e779d);
                background: -moz-linear-gradient(top, #65a9d7, #3e779d);
                background: -ms-linear-gradient(top, #65a9d7, #3e779d);
                background: -o-linear-gradient(top, #65a9d7, #3e779d);
                background-image: -ms-linear-gradient(top, #65a9d7 0%, #3e779d 100%);
                padding: 17.5px 35px;
                -webkit-border-radius: 6px;
                -moz-border-radius: 6px;
                border-radius: 6px;
                -webkit-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
                -moz-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
                box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
                text-shadow: #7ea4bd 0 1px 0;
                color: #06426c;
                font-size: 15px;
                font-family: helvetica, serif;
                text-decoration: none;
                vertical-align: middle;
            }
            .button:hover {
                border: 1px solid #0a3c59;
                text-shadow: #1e4158 0 1px 0;
                background: #3e779d;
                background: -webkit-gradient(linear, left top, left bottom, from(#65a9d7), to(#3e779d));
                background: -webkit-linear-gradient(top, #65a9d7, #3e779d);
                background: -moz-linear-gradient(top, #65a9d7, #3e779d);
                background: -ms-linear-gradient(top, #65a9d7, #3e779d);
                background: -o-linear-gradient(top, #65a9d7, #3e779d);
                background-image: -ms-linear-gradient(top, #65a9d7 0%, #3e779d 100%);
                color: #fff;
            }
            .button:active {
                text-shadow: #1e4158 0 1px 0;
                border: 1px solid #0a3c59;
                background: #65a9d7;
                background: -webkit-gradient(linear, left top, left bottom, from(#3e779d), to(#3e779d));
                background: -webkit-linear-gradient(top, #3e779d, #65a9d7);
                background: -moz-linear-gradient(top, #3e779d, #65a9d7);
                background: -ms-linear-gradient(top, #3e779d, #65a9d7);
                background: -o-linear-gradient(top, #3e779d, #65a9d7);
                background-image: -ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%);
                color: #fff;
            }

        </style>

    </head>
    <body>


        <h1>
            Welcome:  <%= ((User) session.getAttribute("user")).getId()%>  
        </h1>

        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="members" name="button" class='button'>
                Members
            </button>
        </form>

        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="listAllOutstanding" name="button" class='button'>
                List all outstanding balances
            </button>
        </form>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="claims" name="button" class='button'>
                Claims
            </button>
        </form>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="listApplications" name="button" class='button'>
                List all provisional applications
            </button>
        </form>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="processClaim" name="button" class='button'>
                Process a claim
            </button>
        </form>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="processApplication" name="button" class='button'>
                Process membership application
            </button>
        </form>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="suspendResumeMember" name="button" class='button'>
                Suspend or resume membership
            </button>
        </form>
        <br>

        <form action="AdminDashboardServlet" method="post">
            <button type="Submit" Value="annualReport" name="button" class='button'>
                Report annual turnover
            </button>
        </form>
        <br>

        <div class="clr"></div>
    </div>
</div>

</body>
</html>