<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID찾기 결과</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container" align = "center">
	<br><br><br><br><br><h4>ID찾기결과</h4><br><br>
	
	<div class="container">
      <table class="table table-striped" id ="postboard" > 
		     <tr>
			     <td width="600"></td>
			     <td width="100">아이디</td>
			     <td align=center><input type ="text" name = "findId" readonly= "readonly" value="${findIdChk.mId }"> </td>
			     <td width="700"></td>
		     </tr>
		</table>
	</div>
	<div align = "center">
    	<a href="http://localhost:8080/DogCat/login.cnd"><input type ="button" value="로그인창으로 돌아가기" align = "center"></a>
    </div>
</div>

</body>
</html>