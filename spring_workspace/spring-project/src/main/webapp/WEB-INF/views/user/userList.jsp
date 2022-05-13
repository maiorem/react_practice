<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot</title>
</head>
<style>
    td, th {
        border:1px solid #ccc;
    }
</style>
<body>
<h1>USERLIST</h1>
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>phoneNum</th>
        <th>-</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="data" items="${list}">
        <tr>
            <td>${data.userid }</td>
            <td>${data.username}</td>
            <td>${data.phoneNum}</td>
            <td><a href = "./udelete/${data.idx}">삭제</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>
<button><a href="./uinsert">회원 등록</a></button>
<button><a href="./bshowAll">게시글 보기</a></button>

</body>
</html>