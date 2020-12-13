
			window.onload = function() {
				document.getElementById('newListForm').onsubmit = function() {
					


					var mPw = document.getElementById('mPw');
					var mPwchk = document.getElementById('mPwchk');
					var mEmail = document.getElementById('mEmail');
					var mTel = document.getElementById('mTel');
					var mAddress = document.getElementById('mAddress');
					var mBirth = document.getElementById('mBirth');
					
					 if (mPw.value.length<4 || mPw.value.length>12) {
				        alert("비밀번호를 4~12자까지 입력해주세요.")
				        mPw.focus()
			            mPw.select()
			            return false;
				        }
					
					
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
					
					
					if(mEmail.value == "") {
						alert("이메일을 입력하세요");
						mEmail.focus();
						return false;
					}
					
					
					if(mTel.value == "") {
						alert("전화번호를 입력하세요");
						mTel.focus();
						return false;
					}
				
					if(mAddress.value == "") {
						alert("주소를 입력하세요");
						mAddress.focus();
						return false;
					}
				
					if(mBirth.value == "") {
						alert("생일을 입력하세요");
						mBirth.focus();
						return false;
					}
					
					if(mPw.value != "" ||  mPwchk.value != "" ||  mEmail.value != "" 
						|| mAddress.value != "" ||  mBirth.value != ""||  
						mTel.value != "" ){
						alert("수정이 완료 되었습니다.");
					}
				
				
				}
					
				}
			
/**
 * 
 */