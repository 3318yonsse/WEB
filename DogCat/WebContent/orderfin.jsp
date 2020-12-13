<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<title></title>
<script type="text/javascript" src = "join.js" ></script>
</head>
<body>
<jsp:include page="navbar.jsp" />
<br><br><br>
<div align ="center">
<h1>주문완료되었습니다 !</h1><br><br>

<table>
<tr><td> <h2>주문번호 : </h2> </td> <td> <h2>${oNo.oNo}</h2> </td></tr>




</table>



<input type="submit" name ="home" value ="홈으로가기">
</div>
</body>
</html>






