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



<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="col-8 mx-auto">

<%
    Item item = (Item) request.getAttribute("tovar");
    if(item != null){
%>
<form action="/item-details" method="post">
    <div class="mb-3">
        <label for="exampleInputId" class="form-label">ID:</label>
        <input readonly value="<%= item.getId()%>" name="item_id" type="number" class="form-control" id="exampleInputId">
    </div>
    <div class="mb-3">
        <label for="exampleInputName" class="form-label">NAME:</label>
        <input value="<%= item.getName()%>" name="item_name" type="text" class="form-control" id="exampleInputName">
    </div>
    <div class="mb-3">
        <label for="exampleInputDescription" class="form-label">DESCRIPTION:</label>
        <input value="<%= item.getDescription()%>" name="item_description" type="text" class="form-control" id="exampleInputDescription">
    </div>
    <div class="mb-3">
        <label for="exampleInputPrice" class="form-label">PRICE:</label>
        <input value="<%= item.getPrice()%>" name="item_price" type="number" class="form-control" id="exampleInputPrice">
    </div>
    <button>UPDATE ITEM</button>
</form>
    <form action="/delete_item" method="post">
        <div class="mb-3">
            <input readonly value="<%= item.getId()%>" name="item_id" type="hidden" class="form-control" >
        </div>
        <button>DELETE ITEM</button>
    </form>

    <%
        }
    %>
</div>
</body>
</html>
