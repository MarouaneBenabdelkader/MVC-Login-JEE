<%--
  Created by IntelliJ IDEA.
  User: Marouane
  Date: 3/21/2023
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<% response.setHeader("Cache-Control","no-cache ,no-store ,must-revalidate"); %>
<h1>Welcome To Login Page</h1>
<form method="post" action="login">
    <label for="email">
        <b>Email</b>
        <input type="email" name="email" placeholder="Email">
    </label>
    <label for="password">
        <b>Password</b>
        <input type="password" name="password" placeholder="Password">
    </label>
    <button type="submit">login</button>
</form>
</body>
</html>
