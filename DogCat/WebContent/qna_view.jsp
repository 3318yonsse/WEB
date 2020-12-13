<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <jsp:include page="navbar.jsp" />
 <form enctype="multipart/form-data">
<body>
<div class="container" align = "center">
  <h2> QnA 글 보기 페이지</h2><br><br>
  </div>
<table class="table table-striped" id ="postboard" >
<tr>
<td width="400"></td>
<td>게시글 번호 :</td><td> <input type ="text" name ="qNo" value ="${qna_view.qNo }" readonly ="readonly"> <br></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>상품 번호 :</td><td> <input type ="text" name ="items_iNo" value ="${qna_view.items_iNo }" readonly ="readonly"> <br></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>사진 : </td><td><img src="${pageContext.request.contextPath}/upload/${qna_view.qImage}"width="100" height="100"></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>게시글 작성날짜 : </td><td><input type ="text" name ="nInsertdate" value ="${qna_view.qInsertdate }" readonly ="readonly"></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>카테고리 : </td><td><input type ="text" name ="qCategory" value ="${qna_view.qCategory }" readonly="readonly"></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>제목 : </td><td><input type ="text" name ="qTitle" value ="${qna_view.qTitle }"></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>내용 : </td><td><textarea name ="qContent" >${qna_view.qContent }</textarea></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>조회수 : </td><td><input type ="text" name ="qClick" value ="${qna_view.qClick }"readonly = "readonly"></td>
<td width="400"></td>
</tr>
<tr>
<td width="400"></td>
<td>운영진 답변 : </td><td><textarea name ="qCommnet" readonly="readonly">${qna_view.qComment }</textarea></td>
<td width="400"></td>
</tr>
</table>



<table>
<tr>
 <td><input type="submit" value="삭제" onclick="javascript: form.action ='qna_del.cnd';"/ style="float : right"></td>
</tr> 


<!-- <tr>
 <td><input type="submit" value="수정" onclick="javascript: form.action ='qna_modi.cnd';"/ style="float : right"></td>
</tr>  -->
</table>
</form>



</body>
</html>