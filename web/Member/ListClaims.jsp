<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Claim"%>
<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.User"%>
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
            ArrayList<Claim> c = (new XYZWebApplicationDB(wrapper).getMemberClaims(((User) session.getAttribute("user")).getId()));
            for (int i = 0; i != c.size(); ++i) {
                out.println("RATIONALE: " + c.get(i).getRationale() + " : " + c.get(i).getDate() + "<br /> AMOUNT: " + c.get(i).getAmount() + "<br /> STATUS: " + c.get(i).getStatus() + "<br />");

            }
        %>
    </h2>


</html>