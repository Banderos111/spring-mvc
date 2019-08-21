<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.08.2019
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Ooops</title>
</head>
<body>
<p>${msg}</p>
<form action="index" method="get">
    <input type="submit" value="log in">
</form>
<form action="user-form" method="get">
    <input type="submit" value="sign in">
</form>
</body>
</html>
