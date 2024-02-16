<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.02.2024
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Items</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<h1 style="text-align: center; margin-top: 25px; margin-bottom: 10px">Welcome to MY SHOP</h1>
<h4 style="text-align: center; margin-bottom: 25px">Electronic devices with high quality and service</h4>

<div class="d-flex justify-content-center">
<div style="display: flex; flex-wrap: wrap; justify-content: space-between; width: 900px;">
<%
    List<Item> items = (List<Item>) request.getAttribute("tovary");
    for(Item item : items){
%>
<div class="card text-center" style="width: 18rem; margin-bottom: 16px">
    <div class="card-header">
        <%=item.getName()%>
    </div>
    <div class="card-body">
        <h5 class="card-title"><%=item.getPrice()%></h5>
        <p class="card-text"><%=item.getDescription()%></p>
        <a href="#" class="btn btn-success" style="width: 100%">Buy Now</a>
    </div>
</div>
<%
    }
%>
</div>
</div>

</body>
</html>
