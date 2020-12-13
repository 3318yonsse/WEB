<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>ID찾기</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<form action = "id_find.cnd">

<div class="container" align = "center">
   <br><br><br><br><h3>ID찾기</h3><br><br>  
</div>

<div>
        <table class="table table-striped" id ="postboard" > 
		     <tr><td width="600"></td><td><input type ="text" name = "findName" placeholder="이름"> </td><td width="600"></td></tr>
		     <tr><td width="600"></td><td><input type ="text" name = "findEmail"placeholder="E-Mail"> </td><td width="600"></td></tr>
		</table>
</div>

<div align = "center">
    <input type ="submit" value="찾기" align = "center">
</div>
</form>
</body>
</html>