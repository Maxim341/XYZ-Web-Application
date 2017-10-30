<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <br>Username: <input type="text" name="username" />
            <br>Password: <input type="password" name="password" />
            <input type="submit" />
        </form>
    </body>
</html>

