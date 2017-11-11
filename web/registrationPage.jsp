<!DOCTYPE html>
<!-- Template by html.am -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>XYZ Registration Page</title>
        <style type="text/css">
            html, #page { padding:0; margin:0;}
            body { margin:0; padding:0; width:100%; color:#959595; font:normal 12px/2.0em Sans-Serif;} 
            h1, h2, h3, h4, h5, h6 {color:darkblue;}
            #page { background:#eee;}
            #header, #footer, #top-nav, #content, #content #contentbar, #content #sidebar { margin:0; padding:0;}

            /* Logo */
            #logo { padding:10px; width:auto; float:left;}
            #logo h1 a, h1 a:hover { color:darkblue; text-decoration:none;}
            #logo h1 span { color:#d3d3f9;}

            /* Header */
            #header { background:#eee; }
            #header-inner { margin:0 auto; padding:10px; width:970px;background:#fff;}

            /* Feature */
            .feature { background:#eee;padding:0;}
            .feature-inner { margin:auto;padding:10px;width:970px;background:blue; }
            .feature-inner h1 {color:#d3d3f9;font-size:32px;}

            /* Menu */
            #top-nav { margin:0 auto; padding:0px 0 0; height:37px; float:right;}
            #top-nav ul { list-style:none; padding:0; height:37px; float:left;}
            #top-nav ul li { margin:0; padding:0 0 0 8px; float:left;}
            #top-nav ul li a { display:block; margin:0; padding:8px 20px; color:blue; text-decoration:none;}
            #top-nav ul li.active a, #top-nav ul li a:hover { color:#d3d3f9;}

            /* Content */
            #content-inner { margin:0 auto; padding:10px; width:970px;background:#fff;}
            #content #contentbar { margin:0; padding:0; float:right; width:760px;}
            #content #contentbar .article { margin:0 0 24px; padding:0 20px 0 15px; }
            #content #sidebar { padding:0; float:left; width:200px;}
            #content #sidebar .widget { margin:0 0 12px; padding:8px 8px 8px 13px;line-height:1.4em;}
            #content #sidebar .widget h3 a { text-decoration:none;}
            #content #sidebar .widget ul { margin:0; padding:0; list-style:none; color:#959595;}
            #content #sidebar .widget ul li { margin:0;}
            #content #sidebar .widget ul li { padding:4px 0; width:185px;}
            #content #sidebar .widget ul li a { color:blue; text-decoration:none; margin-left:-16px; padding:4px 8px 4px 16px;}
            #content #sidebar .widget ul li a:hover { color:#d3d3f9; font-weight:bold; text-decoration:none;}

            /* Footerblurb */
            #footerblurb { background:#eee;color:blue;}
            #footerblurb-inner { margin:0 auto; width:970px; padding:10px;background:#d3d3f9;border-bottom-right-radius:15px;border-bottom-left-radius:15px;}
            #footerblurb .column { margin:0; text-align:justify; float:left;width:250px;padding:0 24px;}

            /* Footer */
            #footer { background:#eee;}
            #footer-inner { margin:auto; text-align:center; padding:12px; width:970px;}
            #footer a {color:blue;text-decoration:none;}

            /* Clear both sides to assist with div alignment  */
            .clr { clear:both; padding:0; margin:0; width:100%; font-size:0px; line-height:0px;}
        </style>


    </head>
    <body>
        <div id="page">
            
            <header id="header">
                <div id="header-inner">	
                    <div id="logo">
                        <h1><a href="#">XYZ<span>LTD</span></a></h1>
                    </div>
                    <div id="top-nav">

                    </div>
                    <div class="clr"></div>
                </div>
            </header>
            
            
            <div class="feature">
                <div class="feature-inner">
                    <h1>XYZ Registration</h1>
                </div>
            </div>


            <div id="content">
                <div id="content-inner">

                    <main id="contentbar">
                        <div class="article">
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
                                            <td>House Number</td>
                                            <td><input type="text" name="houseNumber" placeholder="'1'"></td>
                                        </tr>
                                        <tr>
                                            <td>Street Name</td>
                                            <td><input type="text" name="streetName" placeholder="'Filton Avenue'"></td>
                                        </tr>
                                        <tr>
                                            <td>City</td>
                                            <td><input type="text" name="city" placeholder="'Bristol'"></td>
                                        </tr>
                                        <tr>
                                            <td>County</td>
                                            <td><input type="text" name="county" placeholder="'Avon'"></td>
                                        </tr>
                                        <tr>
                                            <td>Post Code</td>
                                            <td><input type="text" name="postCode" placeholder="'BS1 1AB'"></td>
                                        </tr>
                                        <tr>
                                            <td>DOB</td>
                                            <td><input type="text" name="DOB" placeholder="DD/MM/YY"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="Submit" value="Register" name="button"></td>
                                        </tr> 
                                    </tbody>
                                </table>
                            </form>
                            <p1><%
                                if (null != request.getAttribute("errorMessage")) {
                                    out.println(request.getAttribute("errorMessage"));
                                }
                                %>
                            </p1>
                            <p2>
                                <%
                                    if (null != request.getAttribute("errorMessage2")) {
                                        out.println(request.getAttribute("errorMessage2"));
                                    }
                                %>
                            </p2>
                            <p3>
                                <%
                                    if (null != request.getAttribute("errorMessage3")) {
                                        out.println(request.getAttribute("errorMessage3"));
                                    }
                                %>
                            </p3>


                        </div>
                    </main>


                    <div class="clr"></div>
                </div>
            </div>

            <div id="footerblurb">
                <div id="footerblurb-inner">
                    <div class="clr"></div>
                </div>
            </div>
            <footer id="footer">
                <div id="footer-inner">
                    <p>&copy; Copyright XYZ LTD</p>
                    <div class="clr"></div>
                </div>
            </footer>
        </div>
    </body>
</html>