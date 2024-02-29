<%@ page import="model.Blog" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.02.2024
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blogs</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="col-8 mx-auto">
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        + ADD BLOG
    </button>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/blogs" method="post">
                        <div class="mb-3">
                            <label for="exampleInputTitle" class="form-label">Title</label>
                            <input name="blog_title" type="text" class="form-control" id="exampleInputTitle" >
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <input name="blog_description" type="text" class="form-control" id="description" >
                        </div>


                        <button class="btn btn-success">+ ADD BLOG</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>TITLE</th>
        <th>AUTHOR</th>
        <th>CREATED AT</th>
        </thead>
        <tbody>
        <%
            List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
            for (Blog blog : blogs){
        %>
        <tr>
            <td><%=blog.getId()%></td>
            <td><%=blog.getTitle()%></td>
            <td><%=blog.getAuthor().getFirstName() + " " + blog.getAuthor().getLastName()%></td>
            <td><%=blog.getCreatedAt()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
