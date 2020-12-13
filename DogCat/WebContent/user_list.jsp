<!DOCTYPE html>
<html>
<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		</style>





  <title>MYLIST</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<%request.setCharacterEncoding("utf-8"); %>
	
</head>
<body>
 <jsp:include page="navbar.jsp" />

<!-- post -->
<div class="container" align = "center">
<form action="user_list.cnd">
  <h2> 	Post </h2>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
        <th>삭제</th>
    
      </tr>
    </thead>
    <tbody>
      <tr>
   <c:forEach items = "${postlist }" var = "dto1" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto1.pNo}</td>
				 <td><a href ="post_view.cnd?pNo=${dto1.pNo}">${dto1.pTitle}</a></td> 
				<td>${dto1.pInsertdate}</td>
				<td>${dto1.pClick }</td>
				<td><a href="user_list_del.cnd?pNo=${dto1.pNo }">X</a></td>
			</tr>
			</c:forEach>
			
			<tr>
     			<td colspan="4" align="center" >
     			<c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="user_listPaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach>
			</td>
			</tr>
    </tbody>
  </table>
  
</div>
<div class="container" align ="center">
<table>
<tr>
		<td width="100">검색선택</td> 
			<td><select name="query">
				<option value="pTitle" >제목</option>
				<option value="pContent" selected="selected">내용</option>
			</select>&nbsp;&nbsp;&nbsp;</td>
			<td width="800"><input type="text" name="content" size="30" /></td>
			<td>&nbsp;&nbsp;<input type="submit" value="검색"></td>
			</tr>
			</table>
	
 </div><br><br><br><br>	
<div class="container" align = "center">
<button type="button" name = "write_button" onclick ="location ='mypage.jsp'" style="float: right">이전으로</button>
</div>





<%-- <!-- qna  -->
<div class="container" align = "center">
 		<form action="user_list.cnd">
  <h2> 	comment </h2>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>제목</th>
       
       
        <th>내용</th>
        <th>날짜</th>
        <th>삭제</th>
       
      
    
      </tr>
    </thead>
    <tbody>
      <tr>
   <c:forEach items = "${commentlist }" var = "dto">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto.nTitle}</td>
				
				
				<td>${dto.wcContent }</td>
				 <td><a href ="qna_view.cnd?qNo=${dto.qNo}">${dto.qTitle}</a></td> 
				<td>${dto.wcInsertdate}</td>
				<td><a href="comment_del.cnd?wcNo=${dto.wcNo }">X</a></td>
				
			
				
			</tr>
			</c:forEach>
			<tr>
     
    </tbody>
  </table>
  

 <div class="container" align ="center">
 	<table>
 	<tr>
			<td width="100">검색 선택</td>
			<td><select name="query1">
				<option value="qTitle" >제목</option>
				<option value="qContent" selected="selected">내용</option>
			</select>&nbsp;&nbsp;&nbsp;</td>
			<td width="800"><input type="text" name="content1" size="30" /></td>
			<td><input type="submit" value="검색"></td>
			</tr>
		
		</table>
 </div>
  
  <div class="container" align = "center">
<button type="button" name = "write_button" onclick ="location ='mypage.jsp'" style="float: right">이전으로</button>
</div> --%>
  <br>
<br>
<jsp:include page="footer.jsp" />	 
</body>
</html>