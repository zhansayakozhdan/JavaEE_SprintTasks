<%@ page import="models.Task" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.02.2024
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Details</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<br><br>
<%
    Task task = (Task) request.getAttribute("taskDetails");
%>

<div style="display: flex; justify-content: center;">
    <div style="width: 600px; ">
        <form action="updateTask" method="post">
            <input type="hidden" name="id" value="<%= task.getId() %>">
            <div class="form-group">
                <label for="name">Name:</label><br>
                <input type="text" id="name" name="name" class="form-control" value="<%= task.getName() %>"><br>
            </div>

            <div class="form-group">
                <label for="description">Description:</label><br>
                <textarea id="description" name="description"
                          class="form-control"><%= task.getDescription() %></textarea><br>
            </div>

            <div class="form-group">
                <label for="deadlineDate">Deadline Date:</label><br>
                <input type="date" id="deadlineDate" name="deadlineDate" class="form-control"
                       value="<%= task.getDeadlineDate() %>"><br>
            </div>

            <div class="form-group">
                <label for="status">Status:</label><br>
                <select id="status" name="status" class="form-control">
                    <% if (task.isStatus()) { %>
                    <option value="true" selected>Выполнено</option>
                    <option value="false">Невыполнено</option>
                    <% } else { %>
                    <option value="true">Выполнено</option>
                    <option value="false" selected>Невыполнено</option>
                    <% } %>
                    <%--            <option value="true" <%= task.isStatus() ? "" : "selected" %>>Выполнено</option>--%>
                    <%--            <option value="false" <%= task.isStatus() ? "" : "selected" %>>Невыполнено</option>--%>
                </select><br>
            </div>
            <button type="submit" class="btn btn-success">Save Changes</button>
        </form>

        <form action="deleteTask" method="post">
            <input type="hidden" name="id" value="<%= task.getId() %>">
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>
</div>

</body>
</html>
