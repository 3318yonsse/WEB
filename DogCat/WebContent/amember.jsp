<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<style type="text/css">
	a{ text-decoration: none; }
	p {
		margin-left: right; margin-right: right;
		text-align: right; margin: 0 auto;
	 }
		    	
		</style>
  <title>관리자_회원관리</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	
</head>

	<body>
	    <jsp:include page="anavbar.jsp" />
	    
		<div class="container" align = "center">
	
		<h2 align="center">회원관리</h2><br>
		
		<br><br><br>
		
		<table class="table table-striped" id ="postboard">
		   <thead>
		
		<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>회원상태</th>
				<th>회원가입날짜</th>
		</tr>
	 </thead>	
     <tbody>
 
 		<c:forEach items = "${mList}" var = "aMemberDTO" begin="${beginNum }" end="${endNum }">  <!-- items 쌓여있는곳 var -> for(int i 이부 -->
			<tr>
			
				<td align="center">${aMemberDTO.mNo}</td>
				<td align="center">${aMemberDTO.mId}</td>
				<td align="center">${aMemberDTO.mPw}</td>
				<td align="center">${aMemberDTO.mName}</td>
				<td align="center">${aMemberDTO.mEmail}</td>
				<td align="center">${aMemberDTO.mAddress}</td>
				<td align="center">${aMemberDTO.mTel}</td>
				<td align="center">${aMemberDTO.mBirth}</td>
				<td align="center">${aMemberDTO.mGender}</td>
				<td align="center"><a href ="amember_del.cnd?mNo=${aMemberDTO.mNo}">${aMemberDTO.mState}</a></td>
				<td align="center">${aMemberDTO.mDate}</td>
			</tr>
			</c:forEach>
			
			<tr>
     			<td colspan="11" align="center" ><c:forEach  begin="1" end="${totalPage}" varStatus="status"> 	
				<a href="amemberPaging.cnd?page=${status.count}">${status.count}</a>
			</c:forEach></td>
	
			<tr>
			<td colspan="12"><p><a href="admin.jsp">관리자 페이지로</a></p></td>
			</tr>
	    </tbody>
		</table>
		<br><br><br>
		
	   </div>
		
		<div align ="center">
		<!-- 검색 SelectBox -->
		<form action="amember.cnd" method="post">
		검색 선택 :
			<select name="query" >
			<option value="mId" selected="selected" > 아이디 </option>
			<option value="mName" >이름 </option>
			<option value="mEmail" >이메일 </option>
			<option value="mAddress" >주소 </option>
			<option value="mTel" >전화번호 </option>
			<option value="mBirth">생년월일 </option>
			<option value="mDate">가입날짜 </option>
		</select>
		<input type="text" placeholder="입력해 주세요." name="content" size="30" />
		<input type="submit"value="검색">
		</form>
		 </div>
		 
	</body>
</html>