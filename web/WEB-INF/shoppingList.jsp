<%-- 
    Document   : shoppingList
    Created on : 13-Oct-2022, 9:07:58 AM
    Author     : meeye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        <h2>List</h2>
        <form action="" method="post">
            Add item: <input type="text" name="item"><input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="post">
            <ul>
                <c:forEach items="${items}" var="item" varStatus="index">
                    <li><input type="radio" name="basket" value="${index.count - 1}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
