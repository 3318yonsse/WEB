<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >

  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<link rel="stylesheet" href="css/custom.css"> <!-- 참조  -->
<title>Hello the Animall</title>
</head>
<style>

    ul {	background-color: #e89f3c; 
    		list-style-type: none; 
    		margin: 50; 
    		padding:50; 
    		overflow: hidden;  			}

	 li a {  display: block; 
    		background-color: e89f3c; 	
    		color: #797979; 
    		padding: 8px; 
    		text-decoration: none;
           	text-align: center; 
           	font-weight: bold;         }
   		 

   	body {padding-top:50px;}
			  
		.navbar-fixed-top { background-color: #e89f3c; }




	



</style>
<body>
<header>

<%
String mId = null; // 로그인이 된 사람들은 로그인정보를 담을 수 있도록한다
if (session.getAttribute("mId") != null)
{
    mId = (String)session.getAttribute("mId");		        

}

%> 
  <nav class ="container-fluid navbar-fixed-top">
        <div class="navbar-header"> <!-- 홈페이지의 로고 -->
            <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expand="false">
                
                <span class ="icon-bar"></span> <!-- 줄였을때 옆에 짝대기 -->
                <span class ="icon-bar"></span>
                <span class ="icon-bar"></span>
            </button>
            <a class ="navbar-brand" href="main.cnd"style="font-weight: bold;  ;">HelloTHEAnimall</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="notice.cnd" style="align-self:  center;">NOTICE</a></li>
                <li><a href="shopping.cnd">SHOPPING</a></li>
                <li><a href="post_list.cnd">POST</a></li>
               <!--  <li><a href="qna.cnd">QnA</a></li> -->
            </ul>
           	<%
            // 접속하기는 로그인이 되어있지 않은 경우만 나오게한다
                if(mId == null)
                {
            %>
                    <ul class="nav navbar-nav navbar-right">
                    <li class = "dropdown">
                        <li><a href="login.cnd">로그인</a></li>
                        <li><a href="join.cnd">회원가입</a></li>                    
                    </ul>
             
            <%
            
            
           
             // 로그인이 되어있는 사람만 볼수 있는 화면
                
                } 
                else if(mId == "admin"){
                	response.sendRedirect("admin.cnd");
                }
                else {
             %>
            		<ul class="nav navbar-nav navbar-right">              
                        <li><a href="main.cnd">장바구니</a></li>
                        <li><a href="mypage.cnd">마이페이지</a></li>
                        <li><a href="logout.cnd">로그아웃</a></li>
           			 </ul>
            <%
                }
            %>
        </div>
    </nav>
</header>


</body>
</html>