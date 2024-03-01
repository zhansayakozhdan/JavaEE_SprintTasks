<%@ page import="model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Comment" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.02.2024
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Post's Details</title>
</head>
<body>
<%@include file="navbar.jsp" %>

<%
    Post post = (Post) request.getAttribute("post");
    if (post != null) {
%>
<div class="col-8 mx-auto">
    <div class="jumbotron">
        <h2 class="display-6"><%=post.getTitle()%>
        </h2>
        <p class="lead"><%=post.getContent()%>
        </p>
        <div class="d-flex">
            <p>Posted at <%=post.getCreatedAt()%>
            </p>
            <p style="margin-left: 50px">Category: <%=post.getCategory().getCategoryName()%>
            </p>
        </div>
    </div>


    <%--     Кнопка только для админа проверка --%>
    <%
        int roleId = (int) request.getAttribute("roleId");
        if (roleId == 1) {
    %>
    <div class="d-grid gap-2 col-6 mx-auto" style="margin-bottom: 15px">
        <a href="/editPost?id=<%=post.getId()%>" class="btn btn-success">Edit Post</a>
    </div>
    <%
        }
    %>

    <hr>
    <form action="/addComment" method="post">
        <div class="form-group mb-3">
            <label for="exampleFormControlTextarea1">COMMENTS</label>
            <textarea name="value" class="form-control" id="exampleFormControlTextarea1" rows="3"
                      placeholder="Ваш комментарий..."></textarea>
            <input name="postId" type="hidden" value="<%=post.getId()%>">
        </div>
        <button type="submit" class="btn btn-primary">+ ADD COMMENT</button>
    </form>

    <%
        List<Comment> comments = (List<Comment>) request.getAttribute("comments");
        for (Comment comment : comments) {
    %>
    <h6><%=comment.getUser().getEmail()%>
    </h6>
    <p><%=comment.getValue()%>
    </p>
    <p>At <%=comment.getPostedAt()%>
    </p>
    <hr>
    <%
        }
    %>
</div>
<%
    }
%>
</body>
</html>
