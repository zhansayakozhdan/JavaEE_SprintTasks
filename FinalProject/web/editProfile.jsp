<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.02.2024
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Edit Profile</title>
</head>
<body>
<%@include file="navbar.jsp" %>

<%
    User user = (User) request.getAttribute("user");
    if (user != null) {
%>
<div class="col-6 mx-auto">

    <%
        String success = request.getParameter("success");
        if (success != null) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Profile edited successfully!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>
    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Something went wrong!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>
    <form action="/edit" method="post">
        <input type="hidden" value="<%=user.getEmail()%>" name="user_email">
        <div class="mb-3">
            <label for="exampleInputFullName" class="form-label">Full Name</label>
            <input name="full_name" type="text" class="form-control" id="exampleInputFullName"
                   value="<%=user.getFullName()%>">
        </div>
        <div class="mb-3">
            <label for="inputPassword" class="form-label">Password</label>
            <input name="password" type="password" class="form-control" id="inputPassword"
                   value="<%=user.getPassword()%>">
        </div>
        <button class="btn btn-success">UPDATE MY DATA</button>

    </form>
</div>
<%
    }
%>
</body>
</html>
