<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_QnA상세</title>
</head>
 <jsp:include page="anavbar.jsp" />
 
<body>
<div class="container" align = "center">
  <h2> QnA 글 보기 페이지</h2><br><br>
  </div>
  
  <div class="container" align = "center" >
  <h2> 	질의 응답 </h2>
<form>
<table class="table table-striped" id ="postboard" >
<tr>
<td>게시글 번호 :</td><td> <input type ="text" name ="qNo" value ="${aqna_view.qNo }" readonly ="readonly"> <br></td>
</tr>
<%-- <tr>
<td>상품 번호 :</td><td> <input type ="text" name ="items_iNo" value ="${aqna_view.items_iNo }" readonly ="readonly"> <br></td>
</tr> --%>
<tr>
<td>사진 : </td><td><img src="${pageContext.request.contextPath}/upload/${aqna_view.qImage}"width="100" height="100"></td></tr>
<tr>
<td>작성자 : </td><td><input type ="text" name ="mId" value ="${aqna_view.mId }" readonly="readonly"></td></tr>
<tr>
<td>카테고리 : </td><td><input type ="text" name ="qCategory" value ="${aqna_view.qCategory }" readonly="readonly"></td></tr>
<tr>
<td>제목 : </td><td><input type ="text" name ="qTitle" value ="${aqna_view.qTitle }" readonly="readonly"></td></tr>
<tr>
<td>내용 : </td><td><textarea name ="qContent" readonly="readonly" >${aqna_view.qContent }</textarea></td></tr>
<tr>
<td>게시글 작성날짜 : </td><td><input type ="text" name ="qInsertdate" value ="${aqna_view.qInsertdate }" readonly ="readonly"></td>
<tr>
<td>게시글 답변날짜 : </td><td><input type ="text" name ="qUpdatedate" value ="${aqna_view.qUpdatedate }" readonly ="readonly"></td>
<tr>
<td>게시글 삭제날짜 : </td><td><input type ="text" name ="qDeletedate" value ="${aqna_view.qDeletedate }" readonly ="readonly"></td>
<tr>
<td>조회수 : </td><td><input type ="text" name ="qClick" value ="${aqna_view.qClick }"readonly = "readonly"></td></tr>


<tr>
<td>운영진 답변 : </td><td><textarea name ="qComment" value = "${aqna_view.qComment }">${aqna_view.qComment }</textarea>
<input type="submit" name = "write_button" value="답변하기" onclick ="javascript: form.action ='aqna_modi.cnd';"/ style="float: right"><input type="submit" value="삭제" onclick="javascript: form.action ='aqna_del.cnd';"/ style="float : right">
</td></tr>

</table>
</form>
</div>


</body>
</html>