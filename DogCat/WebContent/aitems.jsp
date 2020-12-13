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
  <title>관리자_상품목록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
</head>
<body>
<jsp:include page="anavbar.jsp" />


<div class="container" align = "center">
  <h2> 상품리스트 관리자 모드</h2>
          
 <button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='aitems_write.jsp'" style="float: right">상품등록</button>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>번호</th>
        <th>사진</th>
        <th>이름</th>
        <th>원산지</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>수량</th>
        <th>조회수</th>
        <th>상품등록일자</th>
        <th>판매상태</th>
      </tr>
    </thead>
    <tbody>
    
   <c:forEach items = "${list }" var = "dto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto.iNo}</td>
				<td><img src="${pageContext.request.contextPath}/upload/${dto.iImage}"width="100" height="100"></td>
				 <td><a href ="aitems_view.cnd?iNo=${dto.iNo}">${dto.iName}</a></td> 
				<td>${dto.iNation}</td>
				<td>${dto.iCategory}</td>
				<td>${dto.iPrice}</td>
				<td>${dto.iStock}</td>
				<td>${dto.iClick}</td>
				<td>${dto.iInsertdate}</td>
				<td>${dto.iState}</td>
			</tr>
			</c:forEach>
			
			<tr>
     			<td colspan="10" align="center" ><c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="aitemsPaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach>
			</td>
			</tr>
			<tr>
			<td colspan="12"><p><a href="admin.jsp">관리자 페이지로</a></p></td>
			</tr>
    </tbody>
  	</table>
  
	</div>
	
	<div align ="center">
	 		<form action="aitems.cnd">
				검색 선택 :
				<select name="query">
					<option value="iName" selected="selected">이름</option>
					<option value="iNation">원산지</option>
					<option value="iCategory">카테고리</option>
					<option value="iPrice" >가격</option>
					<option value="iInfo" >상세정보</option>
					<option value="iInsertdate" >등록일자</option>
					<option value="iState" >판매상태</option>
					<option value="iStock" >수량</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="text" name="content" placeholder="입력해 주세요" size="30" />
				<input type="submit" value="검색">
			</form>
	 </div>
	 
	</body>
</html>