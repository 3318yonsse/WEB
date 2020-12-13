<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <jsp:include page="navbar.jsp" />
 
<body>
<div class="container" align = "center">
  <h2> QnA 글 보기 페이지</h2><br><br>
  </div>
<form action="qna_write.cnd" method="post" enctype="multipart/form-data">
<table class="table table-striped" id ="postboard" >
<tr>
<td>카테고리 : </td><td><input type ="text" name ="qCategory"></td></tr>

<tr>
<td>제목 : </td><td><input type ="text" name ="qTitle"></td></tr>
<tr>
<tr>
<td>내용 : </td><td><textarea name ="qContent" ></textarea></td></tr>
<tr>
<tr>
<td>파일 첨부</td><td><input type="file" name="file"></td>
</tr>
<tr>
<td align="right" colspan="2"><input type ="submit" name ="insert" value="등록"></td></tr>
</form>


 	<form action = "qna.cnd">
	<input type="submit" value = "목록으로" style="float: right">
	</form>
</table>
	

</body>
</html>