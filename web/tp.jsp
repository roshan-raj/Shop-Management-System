<%-- 
    Document   : tp
    Created on : Nov 12, 2017, 6:46:52 PM
    Author     : Roshan Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
session.invalidate();
response.sendRedirect("MainPage.html");
%>
    </body>
</html>
