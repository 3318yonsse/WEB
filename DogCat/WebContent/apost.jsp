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
  <title>관리자_게시글목록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
</head>
<body>
<jsp:include page="anavbar.jsp" />


<div class="container" align = "center">
  <h2> 관리자 모드</h2>
          
 <button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='apost_write.jsp'" style="float: right">글작성</button>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>사진</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    
   <c:forEach items = "${list }" var = "dto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto.pNo}</td>
				<td><img src="${pageContext.request.contextPath}/upload/${dto.pImage}"width="100" height="100"></td>
				 <td><a href ="apost_view.cnd?pNo=${dto.pNo}&mId=${dto.mId}">${dto.pTitle}</a></td> 
				<td>${dto.pInsertdate}</td>
				<td>${dto.pClick }</td>
			</tr>
			</c:forEach>
			
			<tr>
     			<td colspan="4" align="center" >
     			<c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="apostPaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach>
			</td>
			</tr>
			
			<tr>
			<td colspan="8"><p><a href="admin.jsp">관리자 페이지로</a></p></td>
			</tr>
    </tbody>
  	</table>
  
	</div>
	
	<div align ="center">
	 		<form action="apost.cnd">
				검색 선택 :
				<select name="query">
					<option value="mid">아이디</option>
					<option value="pTitle" >제목</option>
					<option value="pContent" selected="selected">내용</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="text" name="content" placeholder="입력해 주세요" size="30" />
				<input type="submit" value="검색">
			</form>
	 </div>
	</body>
</html>