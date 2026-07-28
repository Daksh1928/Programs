<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Failure</title>
</head>
<body>
<h1><marquee>Registration failed</marquee></h1>
<% String name=(String)session.getAttribute("name"); %>
<h2>Hey <%= name %>, you failed to  registered to this web app</h2>
</body>
</html>