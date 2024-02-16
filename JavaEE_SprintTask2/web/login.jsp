<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.02.2024
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<h3 style="text-align: center; margin-top: 25px; margin-bottom: 10px">Login Page</h3>
<div style="display: flex; justify-content: center">
<form action="/login" method="post" style="width: 900px; margin-top: 20px">
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <%= request.getAttribute("errorMessage") %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } %>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Email address</label>
        <input name="user_email" type="email" class="form-control" id="exampleFormControlInput1" placeholder="Your email">
    </div>
    <label for="inputPassword5" class="form-label">Password</label>
    <input name="user_password" type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">

    <br>
    <button type="submit" class="btn btn-success">Login</button>

</form>
</div>
</body>
</html>
