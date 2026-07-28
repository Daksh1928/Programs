<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP WEB APP</title>
</head>
<body>
<h1>JSP Web App to generate Dynamic Response</h1>
<%@ page import="java.util.Date"

%>
<%!

    int age=18;

%>
<%
    String name=request.getParameter("uname");
    String ucity=request.getParameter("ucity");

    Date date=new Date();
	out.println("Hello "+ name);


%>
<h1><%= date %></h1>
<h2>Hello I know you're from <%= ucity %></h2>
<h2>Hello I know your age is <%= age %></h2>


</body>
</html>