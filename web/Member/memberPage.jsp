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
            Check for outstanding balance 
        </button>
    </form>

    <br>
    <br>



    <br>
    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="makePayment" name="button" class='button'>
            Make a payment 
        </button>
    </form>
    <br>
    <br>


    <br>
    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="submitClaim" name="button" class='button'>
            Submit a claim
        </button>
    </form>
    <br>
    <br>


    <br>
    <form action="MemberDashboardServlet" method="post">
        <button type="Submit" Value="listAllClaims" name="button" class='button'>
            <% //request.setAttribute("p", "ListClaims"); 
                session.setAttribute("p", "ListClaims");
            %>
            List all claims
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