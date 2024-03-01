<%@ page import="model.Post" %>
<%@ page import="model.PostsCategory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.02.2024
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Title</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<%
    Post post = (Post) request.getAttribute("post");
    if (post != null) {
%>

<div class="col-8 mx-auto">

    <%
        String success = request.getParameter("success");
        if (success != null) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Post edited successfully!</strong>
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


    <form action="/editPost" method="post">
        <input type="hidden" name="id" value="<%=post.getId()%>">
        <div class="mb-3">
            <label for="title" class="form-label">Title:</label>
            <input value="<%=post.getTitle()%>" name="post_title" type="text" class="form-control" id="title">
        </div>
        <div class="mb-3">
            <label for="exampleInputDescription" class="form-label">Content:</label>
            <input value="<%=post.getContent()%>" name="post_content" type="text" class="form-control"
                   id="exampleInputDescription">
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category</label>
            <select class=" form-control custom-select my-1 mr-sm-2" name="category_id">
                <%
                    List<PostsCategory> categories = (List<PostsCategory>) request.getAttribute("categories");
                    if (categories != null) {
                        for (PostsCategory c : categories) {
                %>
                <option value="<%=c.getId()%>" id="category" <% if (c.getId() == post.getCategory().getId()) {
                    System.out.print("selected");
                }%> >
                    <%=c.getCategoryName()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>

        <button class="btn btn-success">UPDATE POST</button>
        <button type="button" class="btn btn-danger float-right" data-toggle="modal" data-target="#exampleModal">
            DELETE POST
        </button>
    </form>

</div>

<form action="/deletePost" method="post">
    <input type="hidden" name="id" value="<%=post.getId()%>">
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirm Delete Process</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>
                    <button type="submit" class="btn btn-danger">YES</button>
                </div>
            </div>
        </div>
    </div>
</form>
<%
    }
%>
</body>
</html>
