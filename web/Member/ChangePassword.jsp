<%@page import="com.model.XYZWebApplicationDB"%>
<%@page import="com.model.JDBCWrapper"%>
<%@page import="com.model.User"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <style>

        /* Popup container */
        .popup {
            position: relative;
            display: inline-block;
            cursor: pointer;
        }

        /* The actual popup (appears on top) */
        .popup .popuptext {
            visibility: hidden;
            width: 160px;
            background-color: #555;
            color: #fff;
            text-align: center;
            border-radius: 6px;
            padding: 8px 0;
            position: absolute;
            z-index: 1;
            bottom: 125%;
            left: 50%;
            margin-left: -80px;
        }

        /* Popup arrow */
        .popup .popuptext::after {
            content: "";
            position: absolute;
            top: 100%;
            left: 50%;
            margin-left: -5px;
            border-width: 5px;
            border-style: solid;
            border-color: #555 transparent transparent transparent;
        }

        /* Toggle this class when clicking on the popup container (hide and show the popup) */
        .popup .show {
            visibility: visible;
            -webkit-animation: fadeIn 1s;
            animation: fadeIn 1s
        }

        /* Add animation (fade in the popup) */
        @-webkit-keyframes fadeIn {
            from {opacity: 0;} 
            to {opacity: 1;}
        }

        @keyframes fadeIn {
            from {opacity: 0;}
            to {opacity:1 ;}
        }



        input[type=text] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
        }




    </style>

    <script>
// When the user clicks on <div>, open the popup
        function myFunction() {
            var popup = document.getElementById("myPopup");
            popup.classList.toggle("show");
        }
    </script>






    <h1>Please enter your details: </h1>

    <form>
        <label for="OPass">Current Password</label>
        <input type="text" id="OPass" name="currentP">
        <label for="lname">New Password</label>
        <input type="text" id="NPass" name="newP">
    </form>




    <button>
    <div class="popup" value ="ChangePass" name="button" onclick="myFunction()">Submit
    </button>
       
    
    <% /*
   
     String username = request.getParameter("username");
     
     User u = (new XYZWebApplicationDB((JDBCWrapper) getServletContext().getAttribute("database"))).getUser(username);
                    session.setAttribute("user", u);
     
                    u.setPassword("newP");
                    
                    JDBCWrapper wrapper = null;
                    XYZWebApplicationDB pass = new XYZWebApplicationDB(wrapper);
                    
                    pass.changePassword(u);
    

*/
    
    %>





</html>
