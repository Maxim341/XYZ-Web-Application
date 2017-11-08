<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
    <center>
        <form action="Registration" method="post">
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">XYZ Registration form</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User name</td>
                        <td><input type="text" name="user ID" placeholder="User ID"></td>
                    </tr>
                    <tr>
                        <td>Full name</td>
                        <td><input type="text" name="full name" placeholder="Full Name"></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" placeholder="address"></td>
                    </tr>
                    <tr>
                        <td>DOB</td>
                        <td><input type="text" name="DOB" placeholder="DD/MM/YY"></td>
                    </tr>
                    <tr>
                        <td><input type="Submit" value=“Register” name="button"></td>
                    </tr> 
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>