<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW찾기 결과</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<form action = "login.cnd">
<div align = "center">
<br><br><br><br><br><h4>PW찾기결과</h4><br><br>
          <table class="table table-striped" id ="postboard" > 
          
     <tr>
      <td width="600"></td>
     <td align=right width="100"> 비밀번호 </td>
     <td align=center><input type ="text" name = "findId" readonly= "readonly" value="<%=request.getAttribute("getPw")%>"> </td>
      <td width="700"></td>
     </tr>
   

</table>
</div>
<div align = "center">
    <input type ="submit" value="로그인창으로 돌아가기" align = "center">
    </div>
</form>
</body>
</html>