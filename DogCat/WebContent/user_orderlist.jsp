<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
	a{ text-decoration: none; }	
		</style>
  <title>POST</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
</head>
<body>
<jsp:include page="navbar.jsp" />


<div class="container" align = "center">
  <h2> 주문내역 </h2>
          
 <button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='qna.cnd'" style="float: right">QnA</button>
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
      
        <th>사진</th>
        <th>이름</th>
        <th>구매일자</th>
        <th>주문번호</th>
        <th>금액</th>
        <th>운송장번호</th>
        <th>주문상태<th>
        
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items = "${list }" var = "dto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				 <td><img src="${pageContext.request.contextPath}/upload/${dto.iImage}"width="100" height="100"></td>
				<td> <a href ="shopping_view.cnd?iNo=${dto.items_iNo}">${dto.iName}</a></td> 
				
				<td>${dto.odate}</td>
				<td>${dto.oNo}</td>
				<td>${dto.oSum}</td>
				<td>${dto.oDelno}</td>
				<td>${dto.oState}</td>
				
			</tr>
			 </c:forEach>
			 
			<tr>
     			<td colspan="7" align="center" >
     			<c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="user_orderlistPaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach>
			</td>
			</tr>
		 	
	
    </tbody>
  	</table>
  
	</div>
			<div class="container" align = "center">
<button type="button" class="btn btn-primary" name = "write_button" onclick ="location ='mypage.jsp'" style="float: right">이전으로</button>
</div>
	
	<!--  <div align ="center">
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
	 </div>-->
<br>
<br>
<jsp:include page="footer.jsp" />	 	 
	</body>
</html>