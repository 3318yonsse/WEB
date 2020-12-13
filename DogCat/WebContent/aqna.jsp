<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		</style>





  <title>관리자_QnA목록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<%request.setCharacterEncoding("utf-8"); %>
	
</head>
<body>
 <jsp:include page="anavbar.jsp" />

<div class="container" align = "center">
  <h2> 	질의 응답 </h2>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>게시글 번호</th>
     <!--    <th>상품번호</th> -->
        <th>이미지</th>
        <th>작성자</th>
        <th>카테고리</th>
        <th>제목</th>
        <th>등록날짜</th>
        <th>수정날짜</th>
        <th>삭제날짜</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    
   <c:forEach items = "${list }" var = "dto"  begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto.qNo}</td>
			<%-- 	<td>${dto.items_iNo }</td> --%>
				<td><img src="${pageContext.request.contextPath}/upload/${dto.qImage}"width="100" height="100"></td>
				<td>${dto.mId }</td>
				<td>${dto.qCategory }</td>
				<td><a href ="aqna_view.cnd?qNo=${dto.qNo}">${dto.qTitle}</a></td> 
				<td>${dto.qInsertdate}</td>
				<td>${dto.qUpdatedate}</td>
				<td>${dto.qDeletedate}</td>
				<td>${dto.qClick }</td>
				
			</tr>
			</c:forEach>
     		<tr>
     			<td colspan="4" align="center" ><c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="aqnaPaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach>
			</td>
			</tr>
			<tr>
			<td colspan="12"><p><a href="admin.jsp">관리자 페이지로</a></p></td>
			</tr>
    </tbody>
  </table>
  
</div>



 <!--  검색   -->
 <div align ="center">
 		<form action="aqna.cnd">
			검색 선택 :
			<select name="query">
				<option value="mid">아이디</option>
				<option value="qTitle" >제목</option>
				<option value="qCategory" >카테고리</option>
				<option value="qContent" selected="selected">내용</option>
				<option value="qInsertdate" >등록날짜</option>
				<option value="qUpdatedate" >수정날짜</option>
				<option value="qDeletedate" >삭제날짜</option>
			</select>&nbsp;&nbsp;&nbsp;
			<input type="text" name="content" size="30" placeholder="입력하세요"/>
			<input type="submit" value="검색">
		</form>
 </div>
  <!--  검색   -->
 
 
 
</body>
</html>