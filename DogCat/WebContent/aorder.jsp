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
  <title>관리자_주문목록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
</head>
<body>
<jsp:include page="anavbar.jsp" />


<div class="container" align = "center">
  <h2> 관리자 모드</h2>
          
  <table class="table table-striped" id ="postboard">
    <thead>
      <tr>
        <th>주문번호</th>
        <th>사진</th>
        <th>아이디</th>
        <th>상품명</th>
        <th>보내는분</th>
        <th>보내는분 Telno.</th>
        <th>받는분</th>
        <th>받는분 Telno.</th>
        <th>주소</th>
        <th>결제방식</th>
        <th>주문수량</th>
        <th>남은수량</th>
        <th>상품금액</th>
        <th>총금액</th>
        <th>운송번호</th>
        <th>주문날짜</th>
        <th>주문상태</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items = "${list }" var = "dto" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
				<td>${dto.oNo}</td>
				<td><img src="${pageContext.request.contextPath}/upload/${dto.iImage}"width="100" height="100"></td>
				<td>${dto.mId }</td>
				<td><a href ="aorder_view.cnd?oNo=${dto.oNo}">${dto.iName}</a></td> 
				<td>${dto.oName }</td>
				<td>${dto.oTel }</td>
				<td>${dto.oToName }</td>
				<td>${dto.oToTel }</td>
				<td>${dto.oAddress }</td>
				<td>${dto.oPaymentMethod }</td>
				<td>${dto.oQty }</td>
				<td>${dto.iStock }</td>
				<td>${dto.iPrice }</td>
				<td>${dto.oSum }</td>
				<td>${dto.oDelno }</td>
				<td>${dto.odate}</td>
				<td>${dto.oState}</td>
			</tr>
			</c:forEach>
			
			<tr>
     			<td colspan="17" align="center" >
     			<c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="aorderPaging.cnd?page=${status.count}">${status.count}</a>
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
	 		<form action="aorder.cnd">
				검색 선택 :
				<select name="query">
					<option value="member_mId" selected="selected">아이디</option>
					<option value="iName" >상품명</option>
					<option value="oName" >보내는분</option>
					<option value="oTel" >전화번호</option>
					<option value="odate">주문날짜</option>
					<option value="oState">주문상태</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="text" name="content" placeholder="입력해 주세요" size="30" />
				<input type="submit" value="검색">
			</form>
	 </div>
	</body>
</html>