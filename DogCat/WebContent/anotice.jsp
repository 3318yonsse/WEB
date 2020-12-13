<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		p {
		margin-left: right; margin-right: right;
		text-align: right; margin: 0 auto;
	 }
		</style>
  <title>관리자_공지글 목록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
</head>
<body>
<jsp:include page="anavbar.jsp" />


<div class="container" align = "center">
  <h2> 관리자 모드</h2>
          
 <button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='anotice_write.jsp'" style="float: right">글작성</button>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    

   <c:forEach items = "${list }" var = "dto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto.nNo}</td>
				 <td><a href ="anotice_view.cnd?nNo=${dto.nNo}">${dto.nTitle}</a></td> 
				<td>${dto.nInsertdate}</td>
				<td>${dto.nClick }</td>
			</tr>
			</c:forEach>
			
			<tr>
     			<td colspan="4" align="center" ><c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="anoticePaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach></td>
			<tr>
			<td colspan="12"><p><a href="admin.jsp">관리자 페이지로</a></p></td>
			</tr>
    </tbody>
  	</table>
  
	</div>
	    <input type="hidden" name="mId" value="${MID.mId }">
	<div align ="center">
	 		<form action="anotice.cnd">
				검색 선택 :
				<select name="query">
					<option value="nTitle" >제목</option>
					<option value="nContent" selected="selected">내용</option>
					<option value="nInsertdate">날짜</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="text" name="content" placeholder="입력해 주세요" size="30" />
				<input type="submit" value="검색">
			</form>
	 </div>
	 
	</body>
</html>