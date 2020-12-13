<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>PW찾기</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<form action = "pw_find.cnd">
<div align = "center">
<br><br><br>
<br>
<br>
          <table  id ="postboard" > 
          
	 <tr><td colspan="3" align="center"><h3>PW찾기</h3></td></tr>
     <tr><td width="600"></td><td align=center><input type ="text" name = "findId" placeholder="아이디"> </td><td width="600"></tr>
     <tr><td width="600"><td align=center><input type ="text" name = "findName" placeholder="이름"> </td><td width="600"></tr>
     <tr><td width="600"><td align=center><input type ="text" name = "findEmail" placeholder="E-Mail"> </td><td width="600"></tr>

</table>
    <input type ="submit" value="찾기" align = "center">
</div>
</form>
</body>
</html>