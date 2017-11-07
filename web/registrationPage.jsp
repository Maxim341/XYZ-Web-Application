<%-- 
    Document   : registrationPage
    Created on : 31-Oct-2017, 11:00:42
    Author     : BMT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%--     <style>
             /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
             @import url(https://fonts.googleapis.com/css?family=Exo:100,200,400);
       @import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
        margin: 0;
        padding: 0;
        background: #fff;

        color: #fff;
        font-family: Arial;
        font-size: 12px;
}



.body{
        position: absolute;
        top: -20px;
        left: -20px;
        right: -40px;
        bottom: -40px;
        width: auto;
        height: auto;
        
}

.grad{
        position: absolute;
        top: -20px;
        left: -20px;
        right: -40px;
        bottom: -40px;
        width: auto;
        height: auto;
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
        z-index: 1;
        opacity: 0.7;
}

.header{
        position: absolute;
        top: calc(50% - 35px);
        left: calc(50% - 255px);
        z-index: 2;
}

.header div{
        float: left;
        color: #fff;
        font-family: 'Exo', sans-serif;
        font-size: 35px;
        font-weight: 200;
}

.header div span{
        color: #5379fa !important;
}

.login{
        position: absolute;
        top: calc(50% - 75px);
        left: calc(50% - 50px);
        height: 150px;
        width: 350px;
        padding: 10px;
        z-index: 2;
}

.login input[type=text]{
        width: 250px;
        height: 30px;
        background: transparent;
        border: 1px solid rgba(255,255,255,0.6);
        border-radius: 2px;
        color: #fff;
        font-family: 'Exo', sans-serif;
        font-size: 16px;
        font-weight: 400;
        padding: 4px;
}

.login input[type=password]{
        width: 250px;
        height: 30px;
        background: transparent;
        border: 1px solid rgba(255,255,255,0.6);
        border-radius: 2px;
        color: #fff;
        font-family: 'Exo', sans-serif;
        font-size: 16px;
        font-weight: 400;
        padding: 4px;
        margin-top: 10px;
}

.login input[type=button]{
        width: 260px;
        height: 35px;
        background: #fff;
        border: 1px solid #fff;
        cursor: pointer;
        border-radius: 2px;
        color: #a18d6c;
        font-family: 'Exo', sans-serif;
        font-size: 16px;
        font-weight: 400;
        padding: 6px;
        margin-top: 10px;
}

.login input[type=button]:hover{
        opacity: 0.8;
}

.login input[type=button]:active{
        opacity: 0.6;
}

.login input[type=text]:focus{
        outline: none;
        border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
        outline: none;
        border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=button]:focus{
        outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}



    </style>
        --%>   


    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">

            <h1>XYZ Registration</h1>


        </div>

        <br>
        <div class="login">
            <form action="Registration" method="post">
                <input type="text" placeholder="User ID" name="user ID"><br>
                <input type="text" placeholder="Full Name" name="full name"><br>
                <input type="text" placeholder="address" name="address"><br>
                <input type="text" placeholder="DOB" name="DOB"><br>
                <input type="Submit" value="Register">
            </form>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


    </body>
</html>
