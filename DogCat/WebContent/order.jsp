<%@page import="java.util.ArrayList"%>
<%@page import="DTO.orderDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<title></title>
<script type="text/javascript" src = "join.js" ></script>
</head>
<body>
<%String nowId = (String)session.getAttribute("mId"); %>
<jsp:include page="navbar.jsp" />
    
   
<div class="container"> 
<br>
<br>
        <h3 style="text-align:center;">주문화면</h3>
        <h4> 1. 주문상품 확인</h4> <br>
        </div>
<div class="container">    	
     	<table class="table table-striped" id ="postboard"> 
      
       <thead>
      
        <tr> 
        
        <th>주문번호</th>
        <th>상품</th>
        <th>상품이름</th>
        <th>상품가격</th> 
        <th>배송비</th> 
        <th>수량</th> 
        <th>주문금액(합계)</th> 
        
        </tr>
        
		</thead>
        <tbody>
        <tr> 
        <td>${Orderlist.oNo} </td>
        <td><img src="${pageContext.request.contextPath}/upload/${itemlist.iImage}"width="100" height="100"></td>
        <td>${itemlist.iName} </td>
        <td>${itemlist.iPrice} </td>
        <td>2500</td>
        <td>${Orderlist.oQty}</td>

        <td>${Orderlist.oSum}</td>
        
        </tr>
     </tbody>
     
     
     </table>  <br><br><br><br>
     
</div> 
<div class="container"> 
        <h4> 2. 배송정보 확인</h4><br>
</div>       

<div class="container">  
        	<form action="order_fin.cnd">
          <table class="table table-striped" id ="postboard">
          
     <tr>
     <th> 주문자 </th>
     <td><input type="text" name="oName" value="${NOWID.mName}"></td></tr>
     <tr>
     <th> 주문자 연락처 </th>
     <td><input type ="text" name ="oTel" value="${NOWID.mTel}"></td></tr>
     <tr>
     <th> 받으시는 분 </th>
     <td><input type ="text" name ="oToName"></td></tr>
     <tr>
     <th> 받으시는분 연락처 </th>
     <td><input type ="text" name ="oToTel"></td></tr>
     <tr>
     <th> 주소 </th>
     <td>
    <div class ="form-group">
     			 <div align="left">
	                        	<input  type="text" class="form-control"name="postcode" onclick="sample6_execDaumPostcode()" id="sample6_postcode" placeholder="우편번호">
								<input type="button"  class="btn btn-primary" align="right" onclick="sample6_execDaumPostcode()" style="float: left" value="우편번호 찾기"><br>
							</div>	
		                  
								<input type="text" class="form-control" onclick="sample6_execDaumPostcode()" name="oAddress1" id="sample6_address" placeholder="주소">
								<input type="text" class="form-control"  name="oAddress3" id="sample6_extraAddress" placeholder="참고항목">
								<input type="text" class="form-control"  name="oAddress2" id="sample6_detailAddress" placeholder="상세주소">
								
								
								<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
								<script>
								    function sample6_execDaumPostcode() {
								        new daum.Postcode({
								            oncomplete: function(data) {
								                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
								
								                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
								                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								                var addr = ''; // 주소 변수
								                var extraAddr = ''; // 참고항목 변수
								
								                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
								                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								                    addr = data.roadAddress;
								                } else { // 사용자가 지번 주소를 선택했을 경우(J)
								                    addr = data.jibunAddress;
								                }
								
								                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
								                if(data.userSelectedType === 'R'){
								                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
								                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
								                        extraAddr += data.bname;
								                    }
								                    // 건물명이 있고, 공동주택일 경우 추가한다.
								                    if(data.buildingName !== '' && data.apartment === 'Y'){
								                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
								                    }
								                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								                    if(extraAddr !== ''){
								                        extraAddr = ' (' + extraAddr + ')';
								                    }
								                    // 조합된 참고항목을 해당 필드에 넣는다.
								                    document.getElementById("sample6_extraAddress").value = extraAddr;
								                
								                } else {
								                    document.getElementById("sample6_extraAddress").value = '';
								                }
								
								                // 우편번호와 주소 정보를 해당 필드에 넣는다.
								                document.getElementById('sample6_postcode').value = data.zonecode;
								                document.getElementById("sample6_address").value = addr;
								                // 커서를 상세주소 필드로 이동한다.
								                document.getElementById("sample6_detailAddress").focus();
								            }
								        }).open();
								    }
								</script>
     	                    </div>
     <!-- -------------------------- -->
     
     
     </td></tr>
     <tr>
     <th> 배송메세지 </th>
     <td>
		<textarea col="50" row="50" name =oToContent style="resize: none;"></textarea>
     </td>
     </tr>
     
     
     <tr>
     <th > 결제수단 </th>
     <td>
   	 			<select name="oPaymentMethod">
					<option value="신용카드" selected="selected">신용카드</option>
					<option value="무통장입금" >무통장입금</option>
					<option value="휴대폰결제" >휴대폰결제</option>
				</select>
   	 </td>
   	 </tr>
    
     </table>
     <div class="container" align="right">
     <input type="hidden" name="iNo" value="${Orderlist.iNo}">
     <input type="hidden" name="oQty" value="${Orderlist.oQty}">
     <input type="hidden" name="iPrice" value="${itemlist.iPrice}">
     <input type="hidden" name="iStock" value="${itemlist.iStock}">
     <input type="hidden" name="oNo" value="${Orderlist.oNo}">
     
     <input type ="submit" name ="oState" value ="주문완료">
     </div>
       </form>
       <div class="container" align="right">
       <form action="order_cancel.cnd?oNo=${Orderlist.oNo}">
     <input type ="submit" name ="order" value ="주문취소" style="float : right">
 		</form> 
 		</div>
 	</div>
 	
 	
 <br>
<br>
<jsp:include page="footer.jsp" />		
 </body>
    
 </html>