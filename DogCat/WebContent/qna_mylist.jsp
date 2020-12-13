<!DOCTYPE html>
<html>
<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		</style>





  <title>POST</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<%request.setCharacterEncoding("utf-8"); %>
	
</head>
<body>
 <jsp:include page="navbar.jsp" />

<div class="container" align = "center">
  <h2> 	질의 응답 </h2>
 <button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='qna.cnd'" style="float: right">전체 글</button>
 <button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='qna_write.jsp'" style="float: right">글작성</button>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>상품번호</th>
        <th>카테고리</th>
        <th>제목</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
      <tr>
   <c:forEach items = "${list1 }" var = "dto1">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto1.qNo}</td>
				<td>${dto1.items_iNo }</td>
				<td>${dto1.qCategory }</td>
				 <td><a href ="qna_myview.cnd?qNo=${dto1.qNo}">${dto1.qTitle}</a></td> 
				<td>${dto1.qInsertdate}</td>
			</tr>
			</c:forEach>
			<tr>
     
    </tbody>
  </table>
  
</div>
 
 <div class="container" align = "center">
   <ul class="pagination">
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li class="disabled"><a href="#">4</a></li>
    <li><a href="#">5</a></li>
  </ul>
</div>
</body>
</html>