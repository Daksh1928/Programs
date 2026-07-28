<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>Fail to register </h1>

        <h1><marquee>Registration faild try again </marquee></h1>
        <%
            String name = (String)session.getAttribute("name");
            
        %>
        <h2>Congraluations <%= name%></h2>
    </body>
</html>