<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		</style>





  <title>QNA</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<%request.setCharacterEncoding("utf-8"); %>
	
</head>
<body>
 <jsp:include page="navbar.jsp" />

<div class="container" align = "center">
  <br><h2> Q&A </h2><br><br>
</div>
  
  
  
  <!--  검색   -->
 <div class="container" align ="center">
 		<form action="qna.cnd">
 		<table align="center">
 		<tr>
		<td width="100">검색 선택</td>
		<td>	<select name="query">
				<option value="qTitle" >제목</option>
				<option value="qContent" selected="selected">내용</option>
			</select>&nbsp;&nbsp;&nbsp;</td>
			<td width="800"><input type="text" name="content" size="30" /></td>
			<td>&nbsp;&nbsp;<input type="submit" value="검색"></td>
			</tr>
			</table>
		</form>
 </div>
  <!--  검색   --> 
 
 <div class="container" align ="center">  
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>이미지</th>
        <th>카테고리</th>
        <th>제목</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
   		<c:forEach items = "${list }" var = "qnadto"> <!--begin="${beginNum }" end="${endNum }">-->  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${qnadto.qNo}</td>
				<td><img src="${pageContext.request.contextPath}/upload/${qnadto.qImage}"width="100" height="100"></td>
				<td>${qnadto.qCategory }</td>
				 <td><a href ="qna_view.cnd?qNo=${qnadto.qNo}">${qnadto.qTitle}</a></td> 
				<td>${qnadto.qInsertdate}</td>
			</tr>
		</c:forEach>
     			<!--<td colspan="4" align="center" ><c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="qnaPaging.cnd?page=${status.count}">${status.count}</a>
	</c:forEach></td>-->
     
    </tbody>
  </table>  
</div>

 <div class="container" align ="center">
 <button type="button"  name = "write_button" onclick ="location ='qna_write.jsp'" style="float: right">글작성</button>

<button type="button"  name = "write_button" onclick ="location ='user_orderlist.cnd'" style="float: right">이전으로</button>
</div>


 
 
 
 
 
 </body>
</html>
