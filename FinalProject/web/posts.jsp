<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.02.2024
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="col-8 mx-auto">
    <%--     Кнопка только для админа проверка --%>
    <%
        int roleId = (int) request.getAttribute("roleId");
        if(roleId == 1){
    %>
        <div class="d-grid gap-2 col-6 mx-auto" style="margin-bottom: 15px">
            <a class="btn btn-success" aria-current="page" href="/addPost">+ Add Post</a>
        </div>
    <%
        }
    %>


    <%
        List<Post> posts = (List<Post>) request.getAttribute("novosti");
        for (Post post : posts) {
    %>
    <div class="d-flex position-relative">
        <div>
            <h5 class="mt-0"><%=post.getTitle()%>
            </h5>
            <p><%=post.getContent()%>
            </p>
            <a class="btn btn-primary" href="/postDetails?id=<%=post.getId()%>" role="button">Learn more</a>

        </div>

    </div>
        <hr>
    <%
        }
    %>
</div>
</body>
</html>
