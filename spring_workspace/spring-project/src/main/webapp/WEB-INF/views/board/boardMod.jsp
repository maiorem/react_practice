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
<form action="./" method="post">
    <label>title </label><input type = "text" name = "title" value = "${data.title}"/></br></br>
    <label>contents </label><textarea name = "content" rows = "5" cols = "30"> ${data.content} </textarea></br></br>
    <label>작성자 </label><input type = "text" name = "userid" value = "${data.user.userid}"/></br>
    <input type = "hidden" name = "idx" value = "${data.idx}">
    <input type = "submit" value = "save">
</form>
    <button class = "btn"><a href="/board/bshowAll">목록</a></button>
</body>
</html>
