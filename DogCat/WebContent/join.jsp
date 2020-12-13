<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width", initial-scale="1" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>    




<script type="text/javascript" src = "join.js" ></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
								<script>
					$(function() {
					  $( "#datepicker1" ).datepicker({
					    dateFormat: 'yy-mm-dd'
					  });
					});
				</script></td>
								
								
								
<title></title>



</head>

<body>
<jsp:include page="navbar.jsp"/>
    <br>


	                <div>
	                <br>
	                    <h3 style="text-align:center;">회원가입</h3>
	                    <br>
	                    
	                 </div>   
                   <!-- ------------------------------------------ --> 
	                <form method = "post" action="joinAction.cnd" id="form"  >
	                   		<%String okId = (String)session.getAttribute("okId"); %>
<div class="container">
	<table> 
		<tr>
			<td width="400"></td>	      
		     <td colspan="2">            
		       <input type ="text" class="form-control" placeholder="아이디" name ="mId" maxlength='20' id=mId value="<%=okId%>" readonly="readonly">
		     </td>
		     <td >
				<a href="http://localhost:8080/DogCat/join_idcheck.jsp"><input type="button" class="btn btn-primary"  style="float: right" value="아이디생성"></a>
		     </td>
		     <td width="400"></td>                 
   		 </tr>                   
		<tr>
			<td width="400"></td>	
			<td colspan="2"><input type ="password" class="form-control" placeholder="비밀번호" name ="mPw" maxlength='20' id=mPw></td>
	    </tr>
	    <tr>
	    	<td width="400"></td>		
    		<td colspan="2"><input type ="password" class="form-control" placeholder="비밀번호확인" name ="mPwchk" maxlength='20' id=mPwchk></td>
		
		</tr>               		
	      <tr>
	    	<td width="400"></td>	             
		    <td colspan="2"><input type ="email" class="form-control" placeholder="이메일" name ="mEmail" maxlength='20' id=mEmail></td>
         </tr>           	
       	<tr>	
	    	<td width="400"></td>	              
	        <td colspan="2"><input type ="text" class="form-control" placeholder="이름" name ="mName" maxlength='20' id=mName></td>
        </tr> 
         <tr>
	    	<td width="400"></td>           
	        <td colspan="2"><input type ="text" class="form-control" placeholder="전화번호(-를 제외한 숫자만 입력해주세요)" name ="mTel" maxlength='20' id=mTel></td>
		</tr>
		 <tr>
	    	<td width="400"></td>              
	        <td colspan="2"><input  type="text" class="form-control"name="postcode" onclick="sample6_execDaumPostcode()" id="sample6_postcode" placeholder="우편번호"></td>
			<td><input type="button"  class="btn btn-primary" align="right" onclick="sample6_execDaumPostcode()" style="float: left" value="우편번호 찾기"></td>
		</tr>
		<tr>
			<td width="400"></td>			                  
			<td colspan="3"><input type="text" class="form-control" onclick="sample6_execDaumPostcode()" name="mAddress1" id="sample6_address" placeholder="주소"></td>
		</tr>
		<tr>
			<td width="400"></td>		
			<td><input type="text" class="form-control"  name="mAddress3" id="sample6_extraAddress" placeholder="참고항목"></td>
			<td  colspan="2"><input type="text" class="form-control"  name="mAddress2" id="sample6_detailAddress" placeholder="상세주소"></td>
        </tr>
         <tr>
		     <td width="400"></td>
			 <td ><input type="text"class="form-control" name="mBirth"  color="" placeholder="생년월일" id="datepicker1">
				 
		 </tr>
         <tr>
	          <td width="400"></td>
	         
	           	<td align="right">
	           		<label class="btn btn-primary active">
                    	<input type="checkbox" name="mGender" autocomplete="off" value="남자">남자
                    </label>
                </td>
                <td>
                    <label class="btn btn-primary">
                   	 	<input type="checkbox" name="mGender" autocomplete="off" value="여자" checked>여자
                   </label>
               </td>
             </tr>
             <tr>
     </table>         
</div>	                    
                  <!-- ------------------------------------------ --> 
 
 
 <div class ="form-group" style=" text-align: center;">
					<h4 class="tit01">이용약관 (필수)</h4>
</div>

<div class="container" align="center" >
<table>
<tr>
	<td width="250"></td>
	<td colspan="2">
	 <iframe src="https://www.qia.go.kr/images/guide/txt01_privacy.bak.gif" title="이용약관(필수)" style="width: 100%" ></iframe>
	</td>
	<td width="250"></td>
</tr>
<tr>			
				<td width="250"></td>
	           	<td align="right">
	           		<label class="btn btn-primary active">
                    	<input type="checkbox" name="mGender" id="U_checkAgreement1" autocomplete="off" value="동의">동의
                    </label>
                    <label class="btn btn-primary">
                   	 	<input type="checkbox" name="mGender" autocomplete="off" value="비동의" checked>비동의
                   </label>
               </td>
               <td width="250"></td>
             </tr>
</table>		
</div>
					
				
	  				
                <!-- ------------------------------------------ -->      
      <div class="container" align="center" >
                                       
                    <input type="submit"  value="회원가입">
       </div>       
                
                </form>
            
            
            
             


  
  
 		

<br>
<br>
<jsp:include page="footer.jsp" />

</body>
</html>