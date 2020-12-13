<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
	
	
	  <title>SHOPPING</title>
		
		
</head>

<body>
 <jsp:include page="navbar.jsp" />

<div class="container" align = "center">
 <br><h2> CAT</h2><br><br>
</div> 

  <!-- 검색  --> 
<div class="container" align ="center">
	<form action="shoppingcat.cnd">
		<table align="center">
			<tr>
				<td width="100">검색선택</td> 
				<td><select name="query1">
					<option value="iName" selected="selected">이름</option>
					<option value="iNation">원산지</option>
					<option value="iCategory">카테고리</option>
					<option value="iPrice" >가격</option>
					<option value="iInfo" >상세정보</option>
					<option value="iInsertdate" >등록일자</option>
					<option value="iState" >판매상태</option>
					<option value="iStock" >수량</option>
				</select>&nbsp;&nbsp;&nbsp;</td>
				<td width="750"><input type="text" name="content1" placeholder="입력해 주세요" size="30" /></td>
				<td>&nbsp;&nbsp;<input type="submit" value="검색"></td>
			</tr>
		</table>
	</form>
</div> 
	 <!-- 검색  -->   
<div class="container" align ="center">	        
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>사진</th>
        <th>이름</th>
        <th>원산지</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>수량</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items = "${list }" var = "dto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
		
			<tr>
				<td><img src="${pageContext.request.contextPath}/upload/${dto.iImage}"width="100" height="100"></td>
				 <td><a href ="shopping_view.cnd?iNo=${dto.iNo}">${dto.iName}</a></td> 
				<td>${dto.iNation}</td>
				<td>${dto.iCategory}</td>
				<td>${dto.iPrice}</td>
				<td>${dto.iStock}</td>
				<td>${dto.iClick}</td>
			</tr>
		</c:forEach>
     		<tr>
     			<td colspan="7" align="center" >
     				<c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
						<a href="shoppingcatPaging.cnd?page=${status.count}">${status.count}</a>
					</c:forEach>
				</td>
			</tr>
    </tbody>
  	</table>
  
	</div>
	
	
<br>
<br>
<jsp:include page="footer.jsp" />	 
</body>
</html>