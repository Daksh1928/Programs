<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Success</title>
    </head>
    <body>
        <h1>Success to register </h1>

        <h1><marquee>Registration Success </marquee></h1>

        <%
            String name = (String)session.getAttribute("name");
            
        %>
        <h2>Congraluations <%= name%></h2>
    </body>
</html>