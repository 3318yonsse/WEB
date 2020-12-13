<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>HelloTheAnimall_Login</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>



 <br>
 <br>
 <br>
 <br>
<br>
<div>
 

                    <h2 style="text-align:center;">LOGIN</h2>
                    </div>
                    <br>
        
                <form action="loginAction.cnd" method = "post">
                
            		<div class="container" align = "center">
            		
					<table>
                       	<tr>
                       	<td width="400"></td>
                       	<td><input type ="text" class="primary" placeholder="아이디" name ="mId"></td>
                       	<td width="400"><input type ="button" class="btn btn-primary" onclick ="location.href='id_find.jsp'" value =ID찾기></td>
                       	</tr>
                       	<tr>
                       	<td width="400"></td>
                        <td><input type ="password" class="primary" placeholder="비밀번호" name ="mPw"></td>
						<td width="400"><input type ="button" class="btn btn-primary" onclick ="location.href='pw_find.jsp'" value =PW찾기> </td>
                       	</tr>
                	</table>
                  
	                    <input type="submit"  value="로그인" size="5">
                       
	                	 
	                	
                	
                	</div>
                	
                </form>
        
        
  
    
    
  

  
    <br>
    <br>
    <br>
    <br>
    <br>
    <jsp:include page="footer.jsp" />
  </body>
</html>