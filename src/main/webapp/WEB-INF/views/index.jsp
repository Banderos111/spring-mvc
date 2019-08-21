<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.08.2019
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="logIn" method="post">
    <table>
        <tr>
            <td>Mail:</td>
            <td>
                <input type="text" name="mail"/>
            </td>
            <td>Password:</td>
            <td>
                <input type="text" name="password"/>
            </td>
            <td>
                <input type="submit" value="log in"/>
            </td>
        </tr>
    </table>
</form>
<form action="user-form" method="get">
    <input type="submit" value="sign in">
</form>
</body>
</html>
