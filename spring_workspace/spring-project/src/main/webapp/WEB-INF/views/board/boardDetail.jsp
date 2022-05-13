<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD</title>
</head>
<style>
    body{margin-top:5%;}
    a{ color: white; text-decoration: none;}
    td, th {
        border:1px solid #ccc;
    }
    .middle{
        width:80%;
        margin:0 auto;

    }
    .top{
        border-bottom:1.5px solid #369;
        margin:0 auto;
        font-size:25px;
        width:50%;
        margin-bottom:2%;
    }
    .mid{
        color:gray;
        margin-top:5%;
        margin:0 auto;
        width: 50%;
        padding-bottom: 5%;
        padding-left:64%;
    }
    .contents{
        font-size:20px;
        width:50%;
        margin: 0 auto;
        padding-bottom:5%;
    }
    .btnclass{
        margin:0 auto;
        width:40%;
    }
    .btn{
        width: 60px;
        height: 25px;
        -moz-box-shadow: 0px 10px 14px -7px #369;
        -webkit-box-shadow: 0px 10px 14px -7px #369;
        box-shadow: 0px 10px 14px -7px #369;
        background-color: #369;
        -moz-border-radius: 4px;
        -webkit-border-radius: 4px;
        border-radius: 3px;
        border: 1px solid #369;
        display: inline-block;
        cursor: pointer;
        color: #ffffff;
        font-family: Arial;
        font-size: 15px;
        font-weight: bold;
        text-decoration: none;
        text-align: center;
        text-shadow: 0px 1px 0px #369;
        padding-top: 1px;
    }

</style>
<body>
<div class = "middle">
    <div class = "top">
        ${boardList.title}
    </div>
    <div class = "mid">
        날짜 | ${boardList.uploadDate}<br>
        작성자 | ${boardList.user.userid}
    </div>
    <div class = "contents">
        ${boardList.content}
    </div>

</div>

<br><br>
<div class = "btnclass">
    <button class = "btn"><a href="/board/bupdate/${boardList.idx}">수정</a></button>
    <button class = "btn"><a href="/board/bshowAll">목록</a></button>
    <button class = "btn"><a href="/board/bdelete/${boardList.idx}">삭제</a></button>
</div>

</body>
</html>