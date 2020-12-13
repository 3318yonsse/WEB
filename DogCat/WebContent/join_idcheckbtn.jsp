<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<script type="text/javascript">

			function sendCheckValue(){
				   location.href = "http://localhost:8080/DogCat/join.cnd";
	                self.close();
	                
	        }    
	   </script>





	 	


<div align="center"> 


				
				
				<%=request.getParameter("chkId")%>
				
				<%String chkId = request.getParameter("chkId");
				session.setAttribute("okId", chkId);
				%>
				
				
				 <% int result=(int)session.getAttribute("rs");
				  	if(result==1) { 
					out.println("는 이미 존재하는 ID입니다."); %>
			 	<br><br> 
				<input type="button" onclick="history.back()" value="다른 아이디 찾기"> 
					
				<%	}else 
				
					{
					out.println("는 사용 가능한 ID입니다."); 
					%>  
				
			 	<br><br> 
			 	<div>
		 
			 	<input type="submit"  onclick="sendCheckValue()" id="inputId" value="이 아이디 사용하기"> 
			
				</div>
				
			 	<input type="button" onclick="history.back()" value="다른 아이디 조회하기"> 
				<%}  %>


</div>
</body>
</html>