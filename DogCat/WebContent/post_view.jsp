<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>post_view</title>
</head>
 <jsp:include page="navbar.jsp" />
 
<body>
<div class="container" align = "center">
  	<br><h2>POST</h2>
 	<br><h3> 상세 글 보기 페이지</h3><br>
</div>

<form name ="form" method="post"enctype="multipart/form-data">
<div class="container" align = "center">
	<table class="table table-striped" id ="postboard" >
		<tr>
		<td width="200">게시글 번호</td><td> <input type ="text" name ="pNo" value ="${post_view.pNo }" readonly ="readonly"> <br></td>
		</tr>
		<tr>
		<td width="200">작성자 아이디</td><td> <input type ="text" name ="mId" value ="${post_view.mId }" readonly ="readonly"> <br></td>
		</tr>
		<tr>
		<td width="200">작성날짜</td><td><input type ="text" name ="pInsertdate" value ="${post_view.pInsertdate }" readonly ="readonly"></td>
		</tr>
		<tr>
		<td width="200">제목</td><td><input type ="text" name ="pTitle" value ="${post_view.pTitle }"></td>
		</tr>
		<tr>
		<td width="200">조회수</td><td><input type ="text" name ="pClick" value ="${post_view.pClick }"readonly = "readonly"></td>
		</tr>
		<tr>
		<td width="200">사진</td><td><img src="${pageContext.request.contextPath}/upload/${post_view.pImage}"width="925" height="776"></td><!-- <!-- <input type="file" name="file"></td></tr> --> 
		</tr>
		<tr>
		<td width="200">내용</td><td><textarea name ="pContent" >${post_view.pContent }</textarea></td>
		</tr>
	</table>
</div>

<div class="container" class id ="image" align ="center">
 <%String nowId = (String)session.getAttribute("mId");
 String pmId=(String)session.getAttribute("pmId");		
if(nowId==null){
	
}
if(nowId!=null){
 if(!nowId.equals(pmId)){	 
 }else{%>
<table>
<tr>
	<td><input type="file" name="file" style="float : left"></td>
	<td width="100"><input type="submit" value="수정" onclick="javascript: form.action='post_modi.cnd';" style="float : left"></td>
	<td width="100"><input type="submit" value="삭제" onclick="javascript: form.action='post_del.cnd';" style="float : left"></td>
</tr>
</table>
<%}
 }%>
</div> 
<div class="container" align = "left">
	
	<input type="submit" value = "목록으로" onclick="javascript: form.action='post_list.cnd';" style="float: right">
	
	<br><br><br>
</div>  
</form>
	 
<!-- ----------------------댓글------------------- -->	
 
<form name = "form1" method = "post">	
	<div class="container" align = "left">
		 <table class="table-striped" id ="commentboard" border="1">
		
			<tr>
			<td align="center">날짜</td>
			<td align="center">작성자</td>
			<td align="center" colspan="2">댓글</td>
			</tr>
		   
		   <tbody>
		   <c:forEach items = "${commentlist}" var = "dtos">
		   	<tr>
			<td align="center" width="200">${dtos.pwcInsertdate}</td>
			<td align="center" width="200">${dtos.mId}</td> 
			<td>${dtos.pwcContent}</td> 
			<td>
			<%
			 	String pcmId=(String)session.getAttribute("pcmId");		
				if(nowId==null){
				}
				if(nowId!=null){
			 		if(!nowId.equals(pcmId)){	 
			 		}else{
		 	%>
			<input type="submit" onclick ="javascript: form1.action='comment_del.cnd';" style="float : right" value="삭제">
			<%}
	 			}%>
			</td>		   
		   </tr>
		   </c:forEach>
		   </tbody>
		   
		</table> 
	</div>	
	
	<br>
	<br>
	<input type="hidden" name ="pNo" value ="${post_view.pNo }">
<div class="container" align = "left">
	<table class="table-striped" id ="commentboard">
	<tr>
		<td width= "100" align="center"> 작성자 </td>
		<td width= "200"><input type="text" name ="작성자" size=8 maxlength =8 value = "<%=nowId%> " readonly="readonly"></td>
		<td><input type = "text" name="pwcComment" size=100 maxlength=200></td>
		<td><input type ="submit" value ="댓글입력" onclick="javascript: form1.action='pcomment_write.cnd';"></td>
	</tr>
	</table>

</div>	
	</form>




	
	
	
	
</body>
</html>