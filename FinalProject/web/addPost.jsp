<%@ page import="java.util.List" %>
<%@ page import="model.PostsCategory" %>
<%@ page import="model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.02.2024
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Add Post</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="col-8 mx-auto">
    <%
        String success = request.getParameter("success");
        if (success != null) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Post created successfully!</strong>
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
        <strong>Something went wrong! Try again!</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>
    <form action="/addPost" method="post">
        <div class="mb-3">
            <label for="exampleInputTitle" class="form-label">Title</label>
            <input name="post_title" type="text" class="form-control" id="exampleInputTitle">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input name="post_content" type="text" class="form-control" id="description">
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category</label>
            <select class=" form-control custom-select my-1 mr-sm-2" name="category_id">
                <%
                    List<PostsCategory> categories = (List<PostsCategory>) request.getAttribute("categories");
                    if (categories != null) {
                        for (PostsCategory c : categories) {
                %>
                <option value="<%=c.getId()%>" id="category">
                    <%=c.getCategoryName()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <button class="btn btn-success">+ ADD POST</button>
    </form>
</div>
</body>
</html>
