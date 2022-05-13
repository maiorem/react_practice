<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form name="myform" id="myform">
		아이디 : <input type="text" name="userid" id="userid" ><br/>
		패스워드 : <input type="text" name="password" id="password" ><br/>
		<button id="btnCall" type="button">로그인</button>
	</form>
	
</body>
</html>
<script>

$(()=>{
	$("#btnCall").click( ()=>{
		
		$.ajax({
			  url: "/login_proc",
			  data:{"userid":$("#userid").val(), password:$("#password").val()},
			  method:"POST",
			  dataType:"json"
		}).done(function(data) {
		  alert(data.result);
		}).fail(function(jqXHR, textStatus){
			console.log(jqXHR + textStatus);
		});
	});
})
</script>
