<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>notice_view</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<jsp:include page="navbar.jsp" />
</head>
 
<body>
<%String nowId = (String)session.getAttribute("mId");%>
	<div class="container" align = "center">
		<br><h2> NOTICE </h2>
		<br><h3> 상세 글 보기 페이지</h3><br>
  	</div>
  	
  	
<form name ="form" method="post">

	<div class="container" align = "center">
		<table class="table table-striped" id ="postboard" >
			<tr>
			<td width="200" align = "center">게시글 번호</td>
			<td><input type ="text" name ="nNo" value ="${notice_view.nNo }" readonly ="readonly"></td>
			</tr>
			<tr>
			<td width="200" align = "center">제목</td>
			<td><input type ="text" name ="nTitle" value ="${notice_view.nTitle }"></td>
			</tr>
			<tr>
			<td width="200" align = "center" >내용</td>
			<td ><textarea height="500" name ="nText" >${notice_view.nContent }</textarea></td>
			</tr>
			<tr>
			<td width="200" align = "center">작성날짜</td>
			<td><input type ="text" name ="nInsertdate" value ="${notice_view.nInsertdate }" readonly ="readonly"></td>
			</tr>
			<tr>
			<td width="200" align = "center">조회수</td><td><input type ="text" name ="nClick" value ="${notice_view.nClick }"readonly = "readonly"></td>
			</tr>
		
		</table>
	</div>


	<div class="container" align = "right">
		<input type="submit" value = "목록으로" onclick="javascript: form.action='notice.cnd';">
		<br><br><br>
	</div>	
	
	
	
	
	

</form>	

</body>
</html>