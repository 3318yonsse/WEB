<!DOCTYPE html>
<html>
<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		</style>





  <title>마이 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<%request.setCharacterEncoding("utf-8"); %>
	
</head>
<style>
	
	#admin{
	width: 400px;
	margin: 0 auto; 
	margin-left: 0 auto;
	}
	button {
	width: 400px;
	margin: auto 0; 
	height: 80px;
	margin-bottom: 20px;
	font-size: 20px;
	background-color: #98c593;
	border-radius: 20px;
	
	}
	button a{
	color: white;
	text-decoration: none;
	
	}
	button:hover {
		color: white;
		background-color: orange;
		
	}
	
	</style>
	<body>
	 <jsp:include page="navbar.jsp" />
	 
	 <div class="container" align = "center">
  	<br><h2>MYPAGE</h2>
 	<br><br>
	</div>
	<div id="admin">
		
		<table table style="margin-left: auto; margin-right: auto;">
		
		</table>
		<button><a href="user_info.cnd"> 회원 정보 수정 </a></button><br><br><br>
		<button><a href="user_list.cnd"> 내가 쓴 Post  </a></button><br><br><br>
		<button><a href="user_comment.cnd"> 내가 쓴 Comment  </a></button><br><br><br>
		<button><a href="user_orderlist.cnd"> 주문 내역 </a></button>
		
	
		
		</div>

<br>	
<br>	
<br>	
<jsp:include page="footer.jsp" />	
	
 </body>
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 