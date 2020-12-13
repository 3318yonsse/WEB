<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Hello The Animall</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	
<body>
<%
    String mId = null; // 로그인이 된 사람들은 로그인정보를 담을 수 있도록한다
    if (session.getAttribute("mId") != null)
    {
        mId = (String)session.getAttribute("mId");
    }
%> 

	<!-- Header -->
			<header id="header">
				<h1><a href = "main.cnd">HELLOTHEANIMALL</a></h1>
				<nav>
					<ul>
						<li><a href="notice.cnd">NOTICE</a></li>
						<li><a href="shopping.cnd">DOG</a></li>
						<li><a href="shoppingcat.cnd">CAT</a></li>
						<li><a href="post_list.cnd">POST</a></li>
						
	 		<%
            // 로그인이 되어있지 않은 경우만 나오게한다
                if(mId == null)
                {
            %>					
						<li><a href="login.cnd">Login</a></li>
						<li><a href="join.cnd">join</a></li>
						
						
			<%
            // 로그인이 되어있는 사람만 볼수 있는 화면
                } else {
            %>			
            
        				<li><a href="mypage.cnd">Mypage</a></li>
						<li><a href="logout.cnd">Logout</a></li>
			<%
                }
            %>			
					</ul>
				</nav>
			</header>
</body>
</html>