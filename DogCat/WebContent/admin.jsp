<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자메뉴</title>
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
	background-color: black;
	border-radius: 20px;
	
	}
	button a{
	color: white;
	text-decoration: none;
	
	}
	button:hover {
		color: white;
		background-color: grey;
		
	}
	
	</style>
	
	<body>	
	<div id="admin">
	<br>
		<h3 align="center">관리자 메뉴</h3>
		<br>
		<br>
		<br>
		<button><a href="amember.cnd"> 회원 관리 </a></button>
		<button><a href="aorder.cnd"> 주문내역 관리 </a></button>
		<button><a href="aitems.cnd"> 상품 관리 </a></button>
		<button><a href="apost.cnd"> 게시판 관리 </a></button>
		<button><a href="anotice.cnd"> 공지사항 관리 </a></button>
		<button><a href="aqna.cnd"> QnA 관리 </a></button>
		<button><a href="main.cnd"> 메인 으로 </a></button>
		
		</div>
	</body>
</html>