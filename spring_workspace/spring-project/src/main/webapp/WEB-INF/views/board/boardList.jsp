<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD</title>
</head>
<style>
    td, th {
        border:1px solid #ccc;
    }
</style>
<body>
<h1>Board List</h1>
<table border="1">
    <thead>
    <tr>
        <th>idx</th>
        <th>title</th>
        <th>date</th>
        <th>userid</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="data" items="${boardList}">
        <tr>
            <td>${data.idx }</td>
            <td><a href = "./bshowOne/${data.idx}">${data.title}</a></td>
            <td>${data.uploadDate}</td>
            <td>${data.user.userid}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>
<button><a href="./binsert">게시글 등록</a></button>
<button><a href="./ushowAll">UserList</a></button>
</body>
</html>