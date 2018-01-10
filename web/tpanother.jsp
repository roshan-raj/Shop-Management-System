<%-- 
    Document   : tpanother
    Created on : Nov 12, 2017, 7:08:39 PM
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
        <%String name = (String) session.getAttribute("name");%>
        <h1><%=name%></h1>
    </body>
</html>
