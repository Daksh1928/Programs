<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h1><marquee>Registration Successfull!</marquee></h1>
<% String name=(String)session.getAttribute("name"); %>
<h2>Hey <%= name %>, you have registered to this web app</h2>
</body>
</html>