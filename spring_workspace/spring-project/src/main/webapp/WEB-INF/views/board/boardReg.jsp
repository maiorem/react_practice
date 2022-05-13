<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Board Registration</title>
</head>
<body>
<h1>Board Registration</h1>
<form action="./binsert" method="post">
    <label>title </label><input type = "text" name = "title"/></br></br>
    <label>contents </label><textarea name = "content" rows = "5" cols = "30"></textarea></br></br>
    <label>작성자 </label><input type = "text" name = "userid"/></br>
    <input type = "submit" value = "save">
</form>
</body>
</html>
