<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.02.2024
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp"%>

<%User user = (User) request.getAttribute("user");%>

<input type="hidden" name="user_email" value="<%= user.getEmail() %>">
<h1 style="text-align: center; margin-top: 30px; margin-bottom: 20px">Hello, <%=user.getFullName()%>!</h1>
<div style="display: flex; justify-content: center">
<form style="width: 900px">
    <div class="form-group">
        <label for="name">Email:</label><br>
        <input type="text" id="name" name="name" class="form-control" value="<%= user.getEmail() %>"><br>
    </div>

    <div class="form-group">
        <label for="description">Full Name:</label><br>
        <textarea id="description" name="description"
                  class="form-control"><%= user.getFullName() %></textarea><br>
    </div>

</form>
</div>

</body>
</html>
