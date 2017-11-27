<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Claim"%>
<%@page import="com.model.JDBCWrapper"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Annual Report</title>
        <style type="text/css">

        </style>


    </head>
    <body>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	webservice.WS_Service service = new webservice.WS_Service();
	webservice.WS port = service.getWSPort();
	// TODO process result here
	float result = port.reportAnnualPayouts();
	out.println("Annual Payouts = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	webservice.WS_Service service = new webservice.WS_Service();
	webservice.WS port = service.getWSPort();
	// TODO process result here
	float result = port.reportAnnualIncome();
	out.println("Annual Income = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

        
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