<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.02.2024
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div clas="col-6 mx-auto">
    <%
        String result = (String) session.getAttribute("result");
        if(result != null){
        if(result.equals("errorUsername")){
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Username is busy!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        } else if(result.equals("errorPasswords")){
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Passwords are not same!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        } else {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Account created successfully!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
        }
    %>
<form action="/signup" method="post">
    <div class="mb-3">
        <label for="usernameField" class="form-label">Username</label>
        <input name="username" type="text" class="form-control" id="usernameField" placeholder="Your username">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="password" placeholder="Your password">
    </div>
    <div class="mb-3">
        <label for="rePassword" class="form-label">Repeat your password</label>
        <input name="rePassword" type="password" class="form-control" id="rePassword" placeholder="Your password">
    </div>
    <div class="mb-3">
        <label for="firstNameField" class="form-label">First Name</label>
        <input name="firstName" type="text" class="form-control" id="firstNameField" placeholder="Your first name">
    </div>
    <div class="mb-3">
    <label for="lastNameField" class="form-label">Last Name</label>
    <input name="lastName" type="text" class="form-control" id="lastNameField" placeholder="Your last name">
</div>
    <div class="mb-3">
    <label for="birthCountryField" class="form-label">Birth Country</label>
    <input name="birthCountry" type="text" class="form-control" id="birthCountryField">
</div>
    <div class="mb-3">
        <label for="ageField" class="form-label">Age</label>
        <input name="age" type="number" class="form-control" id="ageField">
    </div>
    <button type="submit" class="btn btn-primary">Create Account</button>
</form>
</div>
</body>
</html>
