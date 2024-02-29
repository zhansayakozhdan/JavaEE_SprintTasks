<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.02.2024
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom: 20px;">
    <div class="container-fluid col-8 mx-auto">
        <a class="navbar-brand" href="/posts">NEWS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/posts">Home</a>
                </li>
                <% if (session.getAttribute("currentUser") == null) { %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/signup">Sign Up</a>
                </li>
                <% } %>
                <% if (session.getAttribute("currentUser") == null) { %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/signin">Sign In</a>
                </li>
                <% } else if (session.getAttribute("currentUser") != null){ %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/userProfile">My Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/logout">Logout</a>
                </li>

                <% } %>

            </ul>
        </div>

    </div>
</nav>
</html>
