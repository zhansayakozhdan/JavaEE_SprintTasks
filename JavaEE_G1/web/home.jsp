<%@ page import="models.Developer" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Item" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.02.2024
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table cellpadding="10px">--%>
<%--    <thead style="background-color: darkgray">--%>
<%--    <th>NAME</th>--%>
<%--    <th>SURNAME</th>--%>
<%--    <th>DEPARTMENT</th>--%>
<%--    <th>SALARY</th>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <%--%>
<%--        List<Developer> developers = (List<Developer>) request.getAttribute("razraby");--%>
<%--        for (Developer developer : developers) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%=developer.getName()%></td>--%>
<%--        <td><%=developer.getSurname()%></td>--%>
<%--        <td><%=developer.getDepartment()%></td>--%>
<%--        <td><%=developer.getSalary()%></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>


<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="col-8 mx-auto">
    <form action="add-item" method="post">
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">NAME:</label>
            <input name="item_name" type="text" class="form-control" id="exampleInputName">
        </div>
        <div class="mb-3">
            <label for="exampleInputDescription" class="form-label">DESCRIPTION:</label>
            <input name="item_description" type="text" class="form-control" id="exampleInputDescription">
        </div>
        <div class="mb-3">
            <label for="exampleInputPrice" class="form-label">PRICE:</label>
            <input name="item_price" type="number" class="form-control" id="exampleInputPrice">
        </div>
        <button type="submit" class="btn btn-primary">ADD ITEM</button>
    </form>

    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>DETAILS</th>
        </thead>
        <tbody>
        <%
            List<Item> items = (List<Item>) request.getAttribute("tovary");
            for(Item item : items){
        %>
        <tr>
            <td><%=item.getId()%></td>
            <td><%=item.getName()%></td>
            <td><%=item.getDescription()%></td>
            <td><a class="btn btn-dark" href="/item-details?item_id=<%=item.getId()%>">DETAILS</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
