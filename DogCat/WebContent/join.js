window.onload = function() {
				document.getElementById('form').onsubmit = function() {
					
					var mId = document.getElementById('mId');
					
	     	//--------------------------아이디---------------------------//
					//----------------아이디 공백------------------//
					
					if(mId.value == "") {
						alert("아이디를 입력하세요");
						mId.focus();
						return false;
					}
					
					
					//아이디 유효성 검사 (영문소문자, 숫자만 허용)
			        for (i = 0; i < mId.value.length; i++) {
			            ch = mId.value.charAt(i)
			            if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
			                alert("아이디는 대소문자, 숫자만 입력가능합니다.")
			                mId.focus()
			                mId.select()
			                return false;
			           
			        }
					
			        //아이디에 공백 사용하지 않기
			        if (mId.value.indexOf(" ") >= 0) {
			            alert("아이디에 공백을 사용할 수 없습니다.")
			            mId.value.focus()
			            mId.value.select()
			            return false;
			        }
					
					
					var mPw = document.getElementById('mPw');
					
					if(mPw.value == "") {
						alert("비밀번호를 입력하세요");
						mPw.focus();
					return false;
					}
				
					var mPwchk = document.getElementById('mPwchk');
					
					if(mPwchk.value == "") {
						alert("비밀번호 확인을 입력하세요");
						mPwchk.focus();
						return false;
					}
					
					if(mPw.value != mPwchk.value) {
						alert("패스워드가 서로 다릅니다");
						mPwchk.focus();
						return false;
					}
					
					var mEmail = document.getElementById('mEmail');
					
					if(mEmail.value == "") {
						alert("이메일을 입력하세요");
						mEmail.focus();
						return false;
					}
					
					var mName = document.getElementById('mName');
					
					if(mName.value == "") {
						alert("이름을 입력하세요");
						mName.focus();
						return false;
					}
					
					var mTel = document.getElementById('mTel');
					
					if(mTel.value == "") {
						alert("전화번호를 입력하세요");
						mTel.focus();
						return false;
					}
				
					var sample6_address = document.getElementById('sample6_address');
					
					if(sample6_address.value == "") {
						alert("주소를 입력하세요");
						sample6_address.focus();
						return false;
					}
					
					var datepicker1 = document.getElementById('datepicker1');
					
					if(datepicker1.value == "") {
						alert("생일을 입력하세요");
						datepicker1.focus();
						return false;
					}
					
					var U_checkAgreement1 = document.getElementById('U_checkAgreement1');
					if (U_checkAgreement1.checked == false){
						
						alert("약관에 동의하세요")
						return false;
					}
				
				
				
				};
			};

}
