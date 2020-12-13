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
  <h2> QnA 내 글 보기 페이지</h2><br><br>
  </div>
<table class="table table-striped" id ="postboard" >
<tr>
<td>게시글 번호 :</td><td> <input type ="text" name ="MyqNo" value ="${qna_myview.qNo }" readonly ="readonly"> <br></td>
</tr>
<tr>
<td>상품 번호 :</td><td> <input type ="text" name ="items_iNo" value ="${qna_myview.items_iNo }" readonly ="readonly"> <br></td>
</tr>
<td>게시글 작성날짜 : </td><td><input type ="text" name ="nInsertdate" value ="${qna_myview.qInsertdate }" readonly ="readonly"></td>
<tr>
<td>카테고리 : </td><td><input type ="text" name ="qCategory" value ="${qna_myview.qCategory }"></td></tr>
<tr>
<tr>
<td>제목 : </td><td><input type ="text" name ="qTitle" value ="${qna_myview.qTitle }"></td></tr>
<tr>
<tr>
<td>내용 : </td><td><textarea name ="qContent" >${qna_myview.qContent }</textarea></td></tr>

</tr> 



<td>운영진 답변 : </td><td><textarea name ="qCommnet" readonly="readonly">${qna_myview.qComment }</textarea></td></tr>
</table>
	

</body>
</html>
