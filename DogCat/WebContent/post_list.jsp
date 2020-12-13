<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

  <title>POST</title>
	
	
</head>
<body>
 <jsp:include page="navbar.jsp" />


<div class="container" align = "center">
  <br><h2> POST </h2><br><br>
</div>
<div class="container" align ="center">
 		<form action="post_list.cnd">
			<table>
				<tr>
				<td width="100">검색선택</td>
				<td><select name="query">
					<option value="mid">아이디</option>
					<option value="pTitle" >제목</option>
					<option value="pContent" selected="selected">내용</option>
					</select>&nbsp;&nbsp;&nbsp;</td>
				<td width="800"><input type="text" name="content" size="30" /></td>
				<td>&nbsp;&nbsp;<input type="submit" value="검색"></td>
			</table>
		</form>
</div> 
        
<div class="container" align ="center">  
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>사진</th>
        <th>제목</th>
        <th>조회수</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
    
   	<c:forEach items = "${list }" var = "postdto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${postdto.pNo}</td>
				<td>${postdto.mId}</td>
				<td><img src="${pageContext.request.contextPath}/upload/${postdto.pImage}"width="100" height="100"></td>
			 	<td><a href ="post_view.cnd?pNo=${postdto.pNo}&mId=${postdto.mId}">${postdto.pTitle}</a></td> 
				<td>${postdto.pClick }</td>
				<td>${postdto.pInsertdate}</td>
			</tr>
			</c:forEach>
			<tr>
     	<td colspan="6" align="center" ><c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="postPaging.cnd?page=${status.count}">${status.count}</a>
	</c:forEach></td>
    </tbody>
  </table>
  
</div>

<div class="container" align ="center">
<%  String nowId=(String)session.getAttribute("mId");
	if(nowId !=null){
		
 %>
			<button type="button"  name = "write_button" onclick ="location ='post_write.jsp'" style="float: right">글작성</button>
<% 	}else{ }%> 
</div>
 
<br>
<br>
<jsp:include page="footer.jsp" />
</body>
</html>