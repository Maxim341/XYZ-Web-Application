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
        
        <h2 style=""

    <%-- start web service invocation --%>
    <%
    try {
	webservice.WS_Service service = new webservice.WS_Service();
	webservice.WS port = service.getWSPort();
	// TODO process result here
	float payout = port.reportAnnualPayouts();
	float income = port.reportAnnualIncome();
        float net = income - payout;
        
	out.println("<h2>Annual Payouts: £" + payout + "</h2>");
	out.println("<h2>Annual Income: £" + income + "</h2>");
	
        if(net > 0.0f){
            out.println("<h2 style=\"color: green;\">Net: £" + net + "</h2>");
        } else {
            out.println("<h2 style=\"color: red;\">Net: £" + net + "</h2>");
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>

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