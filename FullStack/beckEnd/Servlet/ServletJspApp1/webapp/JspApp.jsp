<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>JSP web App</title>
  </head>
  <body>
    <h1>JSP Web App to generate Dynamic responses</h1>
    <%@
    page import="java.util.Date, java.text.SimpleDateFormat" 
    
    %>

    <%!
    int age = 10;
    String city = "New York";
    %>

    <% String name = request.getParameter("name"); String ucity =
    request.getParameter("city"); out.println("<h2>Welcome " + name + " from " + ucity + "</h2>"); 
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    out.println("<p>Current Date: " + dateFormat.format(currentDate) + "</p>");
    %>

    <%= "Age: " + age + "<br/>" %>
    <%= "City: " + city + "<br/>" %>
    <h2><%= dateFormat.format(currentDate) %></h2>
  </body>
</html>
