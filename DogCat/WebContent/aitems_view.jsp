<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_상품상세</title>
</head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">

$(function(){	

	$(document).ready(function(){

		$('select[name=iState]').change(function() {
				$('#istate').val($(this).val());
				$("#istate").attr("readonly", true);
		});

	});

});

</script>
<body>
    <jsp:include page="anavbar.jsp" />

<div class="container" align = "center">
  <h2> 상세 글 페이지</h2>
  </div>
<form name ="form" method="post" enctype="multipart/form-data" >
<table class="table table-striped" id ="postboard" >

<tr>
<td>번호 :</td><td> <input type ="text" name ="iNo" value ="${aitems_view.iNo }" readonly ="readonly"> <br></td>
</tr>

<tr>
<td>대표사진 : </td><td><img src="${pageContext.request.contextPath}/upload/${aitems_view.iImage }" width="100" height="100"><input type="file" name="file"></td>
</tr>


<tr>
<td>이름 : </td><td><input type ="text" name ="iName" value ="${aitems_view.iName }"></td>
</tr>

<tr>
<td>원산지 : </td><td><input type ="text" name ="iNation" value ="${aitems_view.iNation }"></td>
</tr>

<tr>
<td>카테고리 : </td><td><input type ="text" name ="iCategory" value ="${aitems_view.iCategory }"></td>
</tr>

<tr>
<td>가격 : </td><td><input type ="text" name ="iPrice" value ="${aitems_view.iPrice }"> 원</td>
</tr>

<tr>
<td>상세정보 : </td><td><img src="${pageContext.request.contextPath}/upload/${aitems_view.iImage2 }" width="100" height="100"><input type="file" name="file1" value=""></td>
</tr>

<tr>
<td>기타정보 : </td><td><textarea name ="iInfo" >${aitems_view.iInfo }</textarea></td>
</tr>


<tr>
<td>수량 : </td><td><input type ="text" name ="iStock" value ="${aitems_view.iStock }"></td>
</tr>

<tr>
<td>조회수 : </td><td><input type ="text" name ="iClick" value ="${aitems_view.iClick }"></td>
</tr>

<tr>
<td>상품 등록일자 : </td><td><input type ="text" name ="iInsertdate" value ="${aitems_view.iInsertdate }" readonly ="readonly"></td>
</tr>

<tr>
<td>판매상태 : </td><td>
	<input id="istate" name ="istate" type="text" class="box" value="${aitems_view.iState }" >

		<select id="iState" name="iState">
			<option value="" selected="selected">선택</option>
			<option value="판매중" >판매중</option>
			<option value="판매중지">판매중지</option>
			<option value="주문중">주문중</option>
		</select>

</td>
</tr>


<input type="submit" value="수정" onclick="javascript: form.action='aitems_modi.cnd';"/ style="float : right">
</table>
</form>
<form name="form1">
<div class id ="image" align ="center">

<input type="hidden" name="iNo" value="${aitems_view.iNo }">

<input type="submit" value="삭제" onclick="javascript: form1.action='aitems_del.cnd';"/ style="float : right">
<input type="submit" value = "목록으로" onclick="javascript: form1.action='aitems.cnd';"/ style="float: right">
</div>
	<br><br><br>
	<br>
</form>
	
	
	
	
</body>
</html>