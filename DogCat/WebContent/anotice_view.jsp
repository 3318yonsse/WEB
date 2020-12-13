<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_공지상세</title>
</head>
 
<body>
    <jsp:include page="anavbar.jsp" />
<%String nowId = (String)session.getAttribute("mId");%>
<div class="container" align = "center">
  <h2> 상세 글 보기 페이지</h2>
  </div>
<form name ="form">
<table class="table table-striped" id ="postboard" >
<tr>
<td>게시글 번호 :</td><td> <input type ="text" name ="nNo" value ="${anotice_view.nNo }" readonly ="readonly"> <br></td>
</tr>
<tr>
<td>게시글 작성날짜 : </td><td><input type ="text" name ="nInsertdate" value ="${anotice_view.nInsertdate }" readonly ="readonly"></td>
</tr>
<tr>
<td>제목 : </td><td><input type ="text" name ="nTitle" value ="${anotice_view.nTitle }"></td></tr>
<tr>
<td>내용 : </td><td><textarea name ="nContent" >${anotice_view.nContent }</textarea></td></tr>
<tr>
<td>조회수 : </td><td><input type ="text" name ="nClick" value ="${anotice_view.nClick }"readonly = "readonly"></td></tr>

</table>
<div class id ="image" align ="center">
<input type="submit" value="삭제" onclick="javascript: form.action='anotice_del.cnd';"/ style="float : right">
<input type="submit" value="수정" onclick="javascript: form.action='anotice_modi.cnd';"/ style="float : right">


	
<input type="submit" value = "목록으로" onclick="javascript: form.action='anotice.cnd';"/ style="float: right">
</div>
	<br><br><br>

</form>

<!-- 댓글  -->

	
	
	
	
</body>
</html>