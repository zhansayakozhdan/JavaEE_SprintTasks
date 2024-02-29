<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.02.2024
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>My Profile</title>
</head>
<body>
<%@include file="navbar.jsp" %>


<% User user = (User) session.getAttribute("currentUser");
    if (user != null) {
%>
<div class="col-6 mx-auto">
    <form>
        <input type="hidden" value="<%=user.getId()%>" name="id">
        <div class="mb-3">
            <label for="emailField" class="form-label">Your Email:</label>
            <input name="user_email" type="text" class="form-control" id="emailField" value="<%=user.getEmail()%>"
                   readonly>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Your Password</label>
            <input name="user_password" type="password" class="form-control" id="password"
                   value="<%=user.getPassword()%>" readonly>
        </div>
        <div class="mb-3">
            <label for="full_name" class="form-label">Your Full Name:</label>
            <input name="user_fullName" type="text" class="form-control" id="full_name" value="<%=user.getFullName()%>"
                   readonly>
        </div>


        <div class="d-grid gap-2 col-6 mx-auto" style="margin-bottom: 15px">
            <a href="/edit" class="btn btn-primary">
                Edit Profile
            </a>
        </div>



    </form>
</div>
<%
} else {

%>
<p>User not logged in</p>
<%
    }
%>
</body>
</html>
