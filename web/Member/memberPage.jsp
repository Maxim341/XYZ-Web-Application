<%@page import="com.model.User"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>


    <h1>
        Welcome:  <%= ((User) session.getAttribute("user")).getId()%>  
    </h1>

    <br>



    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="outstandingBalance" name="button" class='button'>
            Check outstanding balance 
        </button>
    </form>

    <br>
    <br>






    <br>
    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="claims" name="button" class='button'>
            <% //request.setAttribute("p", "ListClaims"); 
                session.setAttribute("p", "claims");
            %>
            Claims
        </button>
    </form>
    <br>
    <br>


    <br>
    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="changePassword" name="button" class='button'>
            Change Password
        </button>
    </form>
    <br>
    <br>




</html>