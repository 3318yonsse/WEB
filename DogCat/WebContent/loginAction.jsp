<%@page import="DTO.loginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.loginDAO"%>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8"); %>
 
<jsp:useBean id="member" class="DTO.loginDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="member" property="mId" />
<jsp:setProperty name="member" property="mPw" />
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>



    <%
    String mId = null; 
	
    if(session.getAttribute("mId") != null )
    {
        mId = (String) session.getAttribute("mId");
    }  	
     if(mId != null)
     {	
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('이미 로그인이 되어있습니다.')");
        script.println("location.href = 'main.cnd'");
        script.println("</script>");
     } 

     loginDAO loginDAO= new loginDAO(); 
     int result = loginDAO.login(member.getmId(), member.getmPw());
     if (result == 1){
         session.setAttribute("mId", member.getmId()); 
         PrintWriter script = response.getWriter();
         
         if( (session.getAttribute("mId")).equals("admin")) {
         	script.println("<script>");
             script.println("location.href = 'admin.cnd'");
             script.println("</script>");
         }
         else{
         script.println("<script>");
         script.println("location.href = 'main.cnd'");
         script.println("</script>");
         }
     } 
    else if (result == 0){
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('비밀번호가 틀립니다.')");
        script.println("history.back()");    // 이전 페이지로 사용자를 보냄
        script.println("</script>");
    }
    else if (result == -1){
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('존재하지 않는 아이디입니다.')");
        script.println("history.back()");    // 이전 페이지로 사용자를 보냄
        script.println("</script>");
    }
    else if (result == -2){
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('DB 오류가 발생했습니다.')");
        script.println("history.back()");    // 이전 페이지로 사용자를 보냄
        script.println("</script>");
    }	

    %>
 
</body>
</html>
 