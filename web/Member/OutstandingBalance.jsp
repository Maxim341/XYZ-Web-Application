<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.User"%>
<%@page import="com.model.JDBCWrapper"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>


    <h2>
        <%
            JDBCWrapper wrapper = (JDBCWrapper) getServletContext().getAttribute("database");
            //HttpSession session = request.getSession();
            wrapper.createStatement();
            ArrayList<Payment> p = (new XYZWebApplicationDB(wrapper).getUserPayments(((User) session.getAttribute("user")).getId()));
            for (int i = 0; i != p.size(); ++i) {
                out.println("PAYMENT TYPE: " + p.get(i).getTypeOfPayment() + ": " + p.get(i).getDate() + " : " + p.get(i).getTime() + "<br /> AMOUNT: " + p.get(i).getAmount() + "<br /> <br />");
            }
        %>
    </h2>

</html>