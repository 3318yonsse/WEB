<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_게시글상세</title>
</head>
 
<body>
    <jsp:include page="anavbar.jsp" />

<div class="container" align = "center">
  <h2> 상세 글 보기 페이지</h2>
  </div>
<form name ="form" method="post" enctype="multipart/form-data">
<table class="table table-striped" id ="postboard" >
<tr>
<td>게시글 번호 :</td><td> <input type ="text" name ="pNo" value ="${post_view.pNo }" readonly ="readonly"> <br></td>
</tr>
<tr>
<td>게시글 작성날짜 : </td><td><input type ="text" name ="pInsertdate" value ="${post_view.pInsertdate }" readonly ="readonly"></td>
</tr>
<tr>
<td>제목 : </td><td><input type ="text" name ="pTitle" value ="${post_view.pTitle }"></td></tr>
<tr>
<td>조회수 : </td><td><input type ="text" name ="pClick" value ="${post_view.pClick }"readonly = "readonly"></td></tr>
<tr>
<td>내용 : </td><td><textarea name ="pContent" >${post_view.pContent }</textarea></td></tr>
<tr>
<td>사진 : </td><td><img src="${pageContext.request.contextPath}/upload/${post_view.pImage }" width="100" height="100"><input type="file" name="file"></td></tr>

</table>
<div class id ="image" align ="center">
<input type="submit" value="수정" onclick="javascript: form.action='apost_modi.cnd';"/ style="float : right">
</div>
</form>
<!--게시판 수정 -->


<form name ="form1" method="post">

<input type="hidden" name ="pNo" value ="${post_view.pNo }">
<input type="hidden" name ="pInsertdate" value ="${post_view.pInsertdate }">
<input type="hidden" name ="pTitle" value ="${post_view.pTitle }">
<input type="hidden" name ="pClick" value ="${post_view.pClick }">
<input type="hidden" name ="pContent" value ="${post_view.pContent }">

<input type="submit" value="삭제" onclick="javascript: form1.action='apost_del.cnd';"/ style="float : right">
<input type="submit" value = "목록으로" onclick="javascript: form1.action='apost.cnd';"/ style="float: right">
</form>
	<br><br><br>
	
	
<!-- 댓글  -->
<form name = "form2" method = "post">	
	<div class="container" align = "left">
		 <table class="table-striped" id ="commentboard" border="1">
		
			<tr>
			<td align="center">날짜</td>
			<td align="center">작성자</td>
			<td align="center" colspan="2">댓글</td>
			<td align="center" >삭제</td>
			</tr>
		   
		   <tbody>
		   <c:forEach items = "${commentlist}" var = "dtos">
		   	<tr>
			<td align="center" width="200">${dtos.pwcInsertdate}</td>
			<td align="center" width="200">${dtos.mId}</td> 
			<td>${dtos.pwcContent}</td> 
			<td colspan="2">
			<a href="acomment_del.cnd?pwcNo=${dtos.pwcNo}&mId=<%=session.getAttribute("mId")%>&pNo=<%=session.getAttribute("pNo")%>">X</a>
			</td>		   
		   </tr>
		   </c:forEach>
		   </tbody>
		   
		</table> 
	</div>	
	
	<br>
	<br>
	<input type="hidden" name ="pNo" value ="${post_view.pNo }">
	<input type="hidden" name ="pwcNo" value ="${post_view.pwcNo }">
<div class="container" align = "left">
	<table class="table-striped" id ="commentboard">
	<tr>
		<td width= "100" align="center"> 작성자 </td>
		<td width= "200"><input type="text" name ="작성자" size=8 maxlength =8 value = "관리자" readonly="readonly"></td>
		<td><input type = "text" name="pwcComment" size=100 maxlength=200></td>
		<td><input type ="submit" value ="댓글입력" onclick="javascript: form2.action='apcomment_write.cnd';"></td>
	</tr>
	</table>
</div>	
	</form>


	
</body>
</html>