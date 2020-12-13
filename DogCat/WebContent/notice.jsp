<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding ="UTF-8" %>


<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<%request.setCharacterEncoding("utf-8"); %>
	
	
	  <title>NOTICE</title>
	  
<style type="text/css">
th,td{text-align: center}
</style>		
</head>

<body>
 <jsp:include page="navbar.jsp" />

<div class="container" align = "center">
<br><h2> NOTICE </h2><br><br>
</div>
 
 <!-- 검색  -->
 <div class="container" align ="center">
 		<form action="notice.cnd">
			<table align="center">
			<tr>
			<td width="100">검색선택</td> 
			<td><select name="query">
				<option value="nTitle" >제목</option>
				<option value="nContent" selected="selected">내용</option>
			</select>&nbsp;&nbsp;&nbsp;                      </td>
			<td width="800"><input type="text" name="content"></td>
			<td>&nbsp;&nbsp;<input type="submit" value="검색"> </td>
			</tr>
			</table>
		</form>
 </div>
  <!-- 검색  -->



<div class="container" align ="center">          
  <table class="table table-striped" id ="postboard" align="center">
    <thead>
      <tr>
      	<th align="center">번호</th>
        <th align="center">제목</th>
        <th>날짜</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
  		 <c:forEach items = "${list }" var = "noticedto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td width="100">${noticedto.nNo}</td>
				<td ><a href ="notice_view.cnd?nNo=${noticedto.nNo}">${noticedto.nTitle}</a></td> 
				<td width="200">${noticedto.nInsertdate}</td>
				<td width="100">${noticedto.nClick }</td>
			</tr>
		</c:forEach>
			<tr>
	     		<td colspan="5" align="center" >
		     		<c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
						<a href="noticePaging.cnd?page=${status.count}">${status.count}</a>
					</c:forEach>
				</td>
			</tr>
    </tbody>
  </table>
  
</div>
 
<div class="container" align ="center">
<%  String nowId=(String)session.getAttribute("mId");
	if(nowId !=null){
		if(nowId.equals("admin")){
 %>
			<button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='anotice_write.jsp'" style="float: right">글작성</button>
<% 	}else{ }}%>
</div>
 
 
<br>
<br>
<jsp:include page="footer.jsp" />
</body>
</html>