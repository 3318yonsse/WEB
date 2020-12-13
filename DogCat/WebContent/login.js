window.onload = function() {
	document.getElementById('loginjs').onsubmit = function() {
					
					
	 var result = document.getElementById('result');
        

		if (result ==1){
            
            location.href = 'main.cnd';
            
        }
        else if (result == 0){
            
           alert('비밀번호가 틀립니다.');
           history.back();    
          
        }
        else if (result == -1){
            
            alert('존재하지 않는 아이디입니다.');
            history.back();   
            
        }
        else if (result == -2){
          
          	alert('DB 오류가 발생했습니다.');
            history.back();    
            
        }			
	}
}		