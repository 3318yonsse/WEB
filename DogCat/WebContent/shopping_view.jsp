<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%request.setCharacterEncoding("utf-8"); %>
<html>
<head>

<title>shopping_view</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script src="//code.jquery.com/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">

$(function(){	

	$(document).ready(function(){

		$('select[name=oQty]').change(function() {
				$('#oqty').val($(this).val());
				$("#oqty").attr("readonly", true);
		});

	});

}); 
</script>

    <jsp:include page="navbar.jsp" />
</head>

<body>

	<div class="container" align = "center">
	  <br><h2> SHOPPING</h2>
	  <br><h3> 상세 글 보기 페이지</h3><br>
  	</div>
  
	<div class="container" align = "center">
<form action="order_insert.cnd" name ="form" method="post">
		<table class="table table-striped" id ="postboard" >

			
			
			<tr>
			<td width="100" rowspan="5">사진</td><td rowspan="5"><img src="${pageContext.request.contextPath}/upload/${shopping_view.iImage }" name="iImage" width="400" height="380">
						
			<td width="100">카테고리</td><td colspan="5"><input type ="text" name ="iCategory" value ="${shopping_view.iCategory }"readonly ="readonly"></td>
			</tr>
			<tr>
				
			<td width="100">상품번호</td><td colspan="5"> <input type ="text" name ="iNo" value ="${shopping_view.iNo }" readonly ="readonly"> <br></td>
			</tr>
			<tr>
			<td width="100">조회수  </td><td colspan="5"><input type ="text" name ="iClick" value ="${shopping_view.iClick }"readonly ="readonly"></td>
			</tr>			
			<tr>	
				<td width="100">상품명</td><td colspan="5"><input type ="text" name ="iName" value ="${shopping_view.iName }"readonly ="readonly"></td>
			</tr>				
			<tr>
				<td width="100">원산지</td><td colspan="5"><input type ="text" name ="iNation" value ="${shopping_view.iNation }"readonly ="readonly"></td>
			</tr>
			<tr>
			
				<td width="100" height="100" rowspan="2" >기타정보</td><td width="400" height="100" rowspan="2"><textarea name ="iInfo"readonly ="readonly" >${shopping_view.iInfo }</textarea></td>
				
				<td width="100" height="50">가격</td><td height="50" colspan="5"><input type ="text" name ="iPrice" value ="${shopping_view.iPrice }"readonly ="readonly"></td>			
			</tr>
			<tr>
			 <td width="100" >남은수량</td><td width="150" colspan="2"><input type="text" value="${shopping_view.iStock }개" readonly ="readonly"></td>
			
			<td width="100" >수량선택</td>
			<td><select id="oQty" name="oQty">
						<option value="0" selected="selected">0</option>
						<option value="1">1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
						<option value="5" >5</option>
						<option value="6" >6</option>
						<option value="7" >7</option>
						<option value="8" >8</option>
						<option value="9" >9</option>
					</select></td>
				<td><input id="oqty" name ="oqty" type="text" class="box" size="3"readonly ="readonly" ></td>
			  
			</tr>
			</table>
<div class="container" align = "right">
		<input type="hidden" value="<%=session.getAttribute("mId")%>">
		<input type="hidden" value="<%=session.getAttribute("iPrice")%>">
		<input type="hidden" name ="iNo"value="${shopping_view.iNo }">
		<input type="submit" name="buy" value="구매하기">
</div>
</form>
</div>			

<div class="container" align = "right">
		<form name="form1">
			<input type="hidden" name="iNo" value="${aitems_view.iNo }">
			<input type="submit" value = "목록으로" onclick="javascript: form1.action='shopping.cnd';"/ style="float: right">
		</form>
</div>
	
<div>			
			
			<h3 align="center">상품상세정보</h3>
			
			<table>
			<tr>
			<td align="center" colspan="4"><img src="${pageContext.request.contextPath}/upload/${shopping_view.iImage2 }" name="iImage2" width="900" height="3000">
			</tr>
			</table>
			
			
		

<!-- <input type="submit" value="구매하기" onclick="javascript: form.action='order.cnd';"/ style="float : right"> -->
	
</div>

<br><br><br>
	<br>
	
	
	
	<br>
    <br>
    <jsp:include page="footer.jsp" />
</body>
</html>