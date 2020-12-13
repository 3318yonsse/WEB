<%@page import="DAO.joinDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="DTO.joinDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="member" property="mId" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center"> 
<br>
<br>
<br>
<br>
<br>

<script type="text/javascript">
window.onload = function() {
				document.getElementById('form').onsubmit = function() {
					
					var chkId = document.getElementById('chkId');
					
					if(chkId.value == "") {
						alert("조회하실 아이디를 입력하세요");
						chkId.focus();
						return false;
					} 
				}
	}
					</script>	     	
	
			
			
			<form action="join_idcheckbtn.cnd" id="form" method="post">
			<input type="text" name="chkId" id="chkId">
			
			
			<input type="submit"value ="중복확인">
			</form>
			
			
			
</div>			  
</body>
</html>