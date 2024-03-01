<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.02.2024
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="col-6 mx-auto">
    <%
        String status = request.getParameter("status");
        if (status != null) {
            Boolean authenticated = Boolean.valueOf(request.getParameter("status"));
            if (Boolean.FALSE.equals(authenticated)) {
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Incorrect email or password! Try again.</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
            }
        }
    %>

    <form action="/signin" method="post">
        <div class="mb-3">
            <label for="usernameField" class="form-label">Email</label>
            <input name="email" type="email" class="form-control" id="usernameField" placeholder="Your email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Your password">
        </div>
        <button type="submit" class="btn btn-primary">Sign In</button>
    </form>
</div>

</body>
</html>
