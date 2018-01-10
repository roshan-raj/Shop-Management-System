<%@page language="java" import="java.util.*" contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta name ="viewport" content="width=device-width,inital-scale=1">
<title>Login</title>
</head>
<body>
<%
   Iterator itr;
   String[] name=new String[2];
   name[0]=(String)session.getAttribute("name");
   List data=(List)session.getAttribute("query");
	if(name!=null)
	{
	  %>
	  <h1>Hi welcome <%=name[0]%></h1>
	  <% 
        }
         for(itr=data.iterator();itr.hasNext();)
         {
           %>
           <table border="1" width="303">
          <tr>
          <td width="119"><%=itr.next()%></td>
          <td width="119"><%=itr.next()%></td>
          </tr>
           </table>
          <%
         }
         
    %>
    <a href="tp.jsp">Logout</a>
</body>
</html>