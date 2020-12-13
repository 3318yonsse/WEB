<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >
<link href='../../css/join_style.css' rel='stylesheet' style='text/css'/> 

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  



<title></title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function() {
  $( "#datepicker1" ).datepicker({
    dateFormat: 'yy-mm-dd'
  });
});
</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>



<script type="text/javascript" src = "user_modi.js" ></script>
</head>



<!-- <script type="text/javascript" >
 window.onload = function(){
	
	document.getElementById('form').onsubmit = function(){	
	var mId = document.getElementById('mId');
	var mPw = document.getElementById('mPw');
	var mPw2 = document.getElementById('mPw2');
	var mName = document.getElementById('mName');
	var tmNo = document.getElementById('mTel');
	var maddess = document.getElementById('maddress');
	var mEmail = document.getElementById('mEmail');
	
	if(mId.length == 0){
		alert("아이디를 입력하세요.");
		mId.focus();
		return false;
	}
	
	if(form.idDuplication.value != "idCheck"){
		alert("아이디 중복체크를 해주세요.");
		return false;
	} 
	
	if(userPw.length == 0){
		alert("비밀번호를 입력하세요");
		userPw.focus();
		return false;
	}
	
	if(userPw2.value == ""){
		alert("비밀번호 확인을 위해 다시 한번 입력해주세요.");
		userPw.focus();
		return false;
	}
	
	if(userName.value == ""){
		alert("이름을 입력하세요");
		userName.focus();
		return false;
	}

	if(telNo.value == ""){
		alert("연락 가능한 번호를 입력하세요");
		telNo.focus();
		return false;
	}
}




</script>
 -->
 
 
 

							<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<body>
<%String nowId = (String)session.getAttribute("mId"); %>
<jsp:include page="navbar.jsp"/>
    <br>

    <div class="container" align = "center" style = width: 500px;> 
    	<div class="row text-center" style="width: 60%">
 
	            <div class ="jumbotron" style=" padding-top:20px;">
	                <form method = "get" action="user_modify.cnd" id="form"  >
	                    <h4 style="text-align:center;">회원정보 수정</h4>
	                    
	                    
                   <!-- ------------------------------------------ --> 
                    <c:forEach items = "${member }" var = "mem">  
	                    <div class ="form-group">
	                        <input type ="text" class="form-control" placeholder="아이디" name ="mId" value=<%=nowId %> maxlength='20' id=mId readonly="readonly">
	                    </div>
	                    <div class ="form-group">
	                        <input type ="email" class="form-control" placeholder="이메일" name ="mEmail" value="${mem.mEmail }" maxlength='20' id=mEmail readonly="readonly">
                    	</div>
	                    <div class ="form-group">
	                        <input type ="text" class="form-control" placeholder="이름" name ="mName" value="${mem.mName }" maxlength='20' id=mName readonly="readonly">
	                    </div>
	                    <div class ="form-group">
	                        <input type ="password" class="form-control" placeholder="비밀번호" name ="mPw" value="${mem.mPw }" maxlength='20' id=mPw>
	                		<input type ="password" class="form-control" placeholder="비밀번호를 다시 입력하세요." name ="mPwchk" maxlength='20' id=mPwchk>
	                    </div>
	                    <div class ="form-group">
	                        <input type ="text" class="form-control" placeholder="전화번호" name ="mTel" value="${mem.mTel }" maxlength='20' id=mTel>
	                    </div>
	                    <div class ="form-group">
	                        <input type ="text" class="form-control" placeholder="주소" name ="mAddress" value="${mem.mAddress }" maxlength='20' id=mAddress>
	                    </div>
	                     
	                     <div class ="form-group" align="left">
	                        <!-- <input type ="text" class="form-control" placeholder="주소" name ="mAddress" maxlength='20' id=mAddress> -->
	                        주소변경
	                        
	                        <input type="text" name="postcode" id="sample6_postcode" placeholder="우편번호" readonly="readonly">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							
								<input type="text" name="mAddress1" id="sample6_address" placeholder="주소" readonly="readonly">
								<input type="text" name="mAddress2" id="sample6_extraAddress" placeholder="비고" readonly="readonly">
								<input type="text" name="mAddress3" id="sample6_detailAddress" placeholder="상세주소">
						  
								
								
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
	                    <div class ="form-group" align="left">
	                        <input type="text" placeholder="생년월일" id="datepicker1" name="mBirth"  value="${mem.mBirth }" readonly="readonly">
	                        
	                    </div>
	                  </c:forEach>
                  
      
                                       
                    <input type="submit" class="btn btn-primary form-control" value="수정">
                	<button type="button" name = "out_button" onclick ="location ='user_out.cnd'" style="float: right">탈퇴하기</button>
                    
                
                </form>
                	
            </div> 
          </div>
      </div>
  
  
 		


<br>
<br>
<jsp:include page="footer.jsp" />	 
</body>
</html>
    