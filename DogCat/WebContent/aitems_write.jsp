<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_상품등록</title>
</head>
 
<body>
    <jsp:include page="anavbar.jsp" />

<div class="container" align = "center">
  <h2> 상세 글 페이지</h2>
  </div>
<form name ="form" method="post" enctype="multipart/form-data" >
<table class="table table-striped" id ="postboard" >



<tr>
<td>상품명 : </td><td><input type ="text" name ="iName" ></td>
</tr>

<tr>
<td>원산지 : </td><td><input type ="text" name ="iNation"></td>
</tr>

<tr>
<td>카테고리 : </td><td><input type ="text" name ="iCategory"></td>
</tr>

<tr>
<td>가격 : </td><td><input type ="text" name ="iPrice"> 원</td>
</tr>

<tr>
<td>사진 :<input type="file" name="file"></td>
</tr>
<tr>
<td>상세정보 :<input type="file" name="file1"></td>
</tr>
<tr>
<td>기타정보 : </td><td><textarea name ="iInfo" ></textarea></td>
</tr>

<tr>
<td>수량 : </td><td><input type ="text" name ="iStock"></td>
</tr>

<input type="submit" value="등록" onclick="javascript: form.action='aitems_write.cnd';"/ style="float : right">
</table>
</form>

<form name ="form1">
<div class id ="image" align ="center">

<input type="submit" value = "취소" onclick="javascript: form1.action='aitems.cnd';"/ style="float: right">
</div>	
	<br><br><br>
	<br>
</form>
	
	
	
	
</body>
</html>