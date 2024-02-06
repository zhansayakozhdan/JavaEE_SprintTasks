<%@ page import="db.DBManager" %>
<%@ page import="models.Task" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.02.2024
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>All Tasks</title>
</head>
<body>
<%@include file="navbar.jsp" %>

<br>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
        style="margin-left: 15px;">
    + Add New Task
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">New Task</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="addTask" method="post">
                <div class="modal-body">
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="name">Task Name:</label><br>
                        <input type="text" id="name" name="name" style="width: 100%" placeholder="Наименование...">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="description">Description:</label><br>
                        <textarea id="description" name="description" style="width: 100%"
                                  placeholder="Описание..."></textarea>
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="deadlineDate">Deadline Date:</label><br>
                        <input type="date" id="deadlineDate" name="deadlineDate" style="width: 100%">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add Task</button>
                </div>
            </form>

        </div>
    </div>
</div>
<br>


<br>

<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col" width="30%">NAME</th>
        <th scope="col">DEADLINE</th>
        <th scope="col">STATUS</th>
        <th scope="col" width="10%">DETAILS</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Task> tasks = DBManager.getAllTasks();
        for (Task task : tasks) {
    %>

    <tr>
        <td><%=task.getId()%>
        </td>
        <td><%=task.getName()%>
        </td>
        <td><%=task.getDeadlineDate()%>
        </td>
        <td><%=task.isStatus() ? "Выполнено" : "Невыполнено"%>
        </td>
        <td>
            <a href="/details?id=<%=task.getId()%>" class="btn btn-info">DETAILS</a>
        </td>
    </tr>

    <%
        }
    %>
    </tbody>
</table>


</body>
</html>
