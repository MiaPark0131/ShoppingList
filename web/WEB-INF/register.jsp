<%-- 
    Document   : register
    Created on : 13-Oct-2022, 9:07:43 AM
    Author     : meeye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="username" value="${username}">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name">
        </form>
    </body>
</html>
