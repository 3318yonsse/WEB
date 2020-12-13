<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_주문상세</title>
</head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">

$(function(){	

	$(document).ready(function(){

		$('select[name=oState]').change(function() {
				$('#ostate').val($(this).val());
				$("#ostate").attr("readonly", true);
		});

	});

});





</script>
<body>
    <jsp:include page="anavbar.jsp" />

<div class="container" align = "center">
  <h2> 상세 글 보기 페이지</h2>
  </div>
<form action="aorder_modi.cnd" method="post" >
<table class="table table-striped" id ="postboard" >
<tr>
<td>주문번호 </td><td> <input type ="text" name ="oNo" value ="${aorder_view.oNo }" readonly ="readonly"> <br></td>
</tr>
<tr>
<td>사진  </td><td><img src="${pageContext.request.contextPath}/upload/${aorder_view.iImage }" width="100" height="100"></td></tr>
</tr>
<tr>
<td>아이디  </td><td><input type ="text" name ="mId" value ="${aorder_view.mId }" readonly ="readonly"></td>
</tr>
<tr>
<td>상품명  </td><td><input type ="text" name ="iName" value ="${aorder_view.iName }" readonly ="readonly"></td>
</tr>
<tr>
<td>보내는분  </td><td><input type ="text" name ="oName" value ="${aorder_view.oName }" readonly ="readonly"></td>
</tr>
<tr>
<td>보내는분 Telno.  </td><td><input type ="text" name ="oTel" value ="${aorder_view.oTel }" readonly ="readonly"></td>
</tr>
<tr>
<td>받는분  </td><td><input type ="text" name ="oToName" value ="${aorder_view.oToName }" readonly ="readonly"></td>
</tr>
<tr>
<td>받는분 Telno.  </td><td><input type ="text" name ="oToTel" value ="${aorder_view.oToTel }"readonly ="readonly" ></td>
</tr>
<tr>
<td>주소  </td><td><input type ="text" name ="oAddress" value ="${aorder_view.oAddress }" readonly ="readonly"></td>
</tr>
<tr>
<td>결제방식  </td><td><input type ="text" name ="oPaymentMethod" value ="${aorder_view.oPaymentMethod }" readonly ="readonly"></td>
</tr>
<tr>
<td>주문수량  </td><td><input type ="text" name ="oQty" value ="${aorder_view.oQty }" readonly ="readonly"></td>
</tr>
<tr>
<td>남은수량  </td><td><input type ="text" name ="iStock" value ="${aorder_view.iStock }" readonly ="readonly"></td>
</tr>
<tr>
<td>상품금액  </td><td><input type ="text" name ="oPrice" value ="${aorder_view.iPrice }" readonly ="readonly"> </td>
</tr>
<tr>
<td>총금액  </td><td><input type ="text" name ="oSum" value ="${aorder_view.oSum }" readonly ="readonly"></td>
</tr>
<tr>
<td>운송번호  </td><td><input type ="text" name ="oDelno" value ="${aorder_view.oDelno }" readonly ="readonly"></td>
</tr>
<tr>
<td>주문 날짜  </td><td><input type ="text" name ="odate" value ="${aorder_view.odate }" readonly ="readonly"></td>
</tr>
<tr>
<td>주문 상태  </td><td>

<div>
	<input id="ostate" name ="ostate" type="text" class="box" value="${aorder_view.oState }" >

		<select id="oState" name="oState">
			<option value="" selected="selected">선택</option>
			<option value="결제 완료" >결제 완료</option>
			<option value="배송 준비중">배송 준비중</option>
			<option value="배송 중">배송 중</option>
			<option value="배송완료">배송완료</option>
			<option value="주문취소">주문취소</option>
			<option value="반품처리">반품처리</option>
		</select>
</div>
</td>

</tr>
</table>
<input type="submit" value="수정"style="float : right">
</form>

<form name ="form1">
<input type="submit" value = "목록으로" onclick="javascript: form1.action='aorder.cnd';"/ style="float: right">
	
	<br><br><br>
</form>
	
</body>
</html>