<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration</title>
</head>
<body>
<h1>User Registration</h1>
<form action="./uinsert" method="post">
    <label>userid </label><input type = "text" name = "userid"/></br>
    <label>username </label><input type = "text" name = "username"/></br>
    <label>phone Number </label><input type = "text" name = "phoneNum"/></br>
    <input type = "submit" value = "save">
</form>
</body>
</html>
