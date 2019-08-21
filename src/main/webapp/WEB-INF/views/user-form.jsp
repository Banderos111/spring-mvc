<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.08.2019
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>User-form</title>
</head>
<body>
<form:form method="POST" action="createUser" modelAttribute="userDto">
    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName"/>
    <form:label path="secondName">Second Name</form:label>
    <form:input path="secondName"/>
    <form:label path="mail">Mail</form:label>
    <form:input path="mail"/>
    <form:label path="password">Password</form:label>
    <form:input path="password"/>
    <input type="submit" value="Submit"/>
</form:form>
<form action="index" method="get">
    <input type="submit" value="Go to login page">
</form>
</body>
</html>