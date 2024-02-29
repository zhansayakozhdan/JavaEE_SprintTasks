<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.02.2024
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="col-6 mx-auto">

    <%
        String success = request.getParameter("success");
        if(success!=null){
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Account created successfully!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>
    <%
        String error = request.getParameter("error");
        if(error!=null){
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Email is busy! or You entered different passwords! Try again!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>


    <form action="/signup" method="post">
        <div class="mb-3">
            <label for="emailField" class="form-label">Email</label>
            <input name="email" type="email" class="form-control" id="emailField" placeholder="Your email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Your password">
        </div>
        <div class="mb-3">
            <label for="rePassword" class="form-label">Repeat your password</label>
            <input name="rePassword" type="password" class="form-control" id="rePassword" placeholder="Repeat your password">
        </div>
        <div class="mb-3">
            <label for="fullNameField" class="form-label">Full Name</label>
            <input name="full_name" type="text" class="form-control" id="fullNameField" placeholder="Your full name">
        </div>
        <input name="role_id" type="hidden" >

        <button type="submit" class="btn btn-primary">Create Account</button>
    </form>

</div>

</body>
</html>
