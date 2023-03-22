<%--
  Created by IntelliJ IDEA.
  User: Marouane
  Date: 3/21/2023
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1> Welcome To Register Page</h1>
<form method="post" action="register">
    <label for="email">
        <b>Email</b>
        <input type="email" name="email" placeholder="Email">
    </label>
    <label for="password">
        <b>Password</b>
        <input type="password" name="password" placeholder="Password">
    </label>
    <button type="submit">register</button>
</form>
<%=request.getAttribute("message")==null?"":request.getAttribute("message") %>


</body>
</html>
