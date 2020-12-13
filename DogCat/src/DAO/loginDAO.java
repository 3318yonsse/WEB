package DAO;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.xml.ws.Response;

import com.mysql.cj.Session;

import DTO.loginDTO;

public class loginDAO { 

	

	
	//field
		 DataSource dataSource; // 
		 private Connection conn;            // DB에 접근하는 객체
		 private PreparedStatement pstmt;    // 
		 private ResultSet rs; 

		
		//constructor
		public loginDAO() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
				conn = dataSource.getConnection();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//method
		public int login(String mId,String mPw) {
			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			String query = "SELECT mPw FROM catNdog.member WHERE mId = ? and mState = '회원'";
			
			//--->
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, mId);
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					if(rs.getString(1).equals(mPw)){
	
	                    return 1;// 로그인 성공
	                    
					}else {
	                    return 0; // 비밀번호 불일치
					}
				}
	            return -1; // ID가 없음
	            
			} catch (Exception e) {
				e.printStackTrace();
				
				return -2;
				
			}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
				}
			}
			
		}

		public loginDTO findIdChk(String findName, String findEmail, ServletResponse response) {
			loginDTO dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			 
			String getId = null;
			try {
				connection = dataSource.getConnection();
				
				String sql= "select mId from catNdog.member " ; 
				String sql2= "where mName = '" +findName+"'and mEmail= '" +findEmail +"' and mState = '회원' ";
				preparedStatement = connection.prepareStatement(sql+sql2);
				resultSet = preparedStatement.executeQuery();

				if(resultSet.next()) {
					getId = resultSet.getString("mId");
					
				
					 dto = new loginDTO(getId);
				}
				else {
					response.setContentType("text/html; charset=UTF-8");
					 
					PrintWriter out = response.getWriter();
					 
					out.println("<script>alert('정보를 확인하세요 !'); location.href='id_find.jsp';</script>");
					 
					out.flush();
				}
			} catch (Exception e) {
				
				System.out.println(e);
			}
			return dto;
		}
		
		public String findPwChk(String findId, String findName, String findEmail, ServletResponse response) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			 
			String getPw = null;
			try {
				connection = dataSource.getConnection();
				
				String sql= "select mPw from catNdog.member " ; 
				String sql2= "where mId = '"+findId +"' and mName = '" +findName+"'and mEmail= '" +findEmail +"' and mState = '회원' ";
				preparedStatement = connection.prepareStatement(sql+sql2);
				resultSet = preparedStatement.executeQuery();

				if(resultSet.next()) {
					getPw = resultSet.getString("mPw");
				
				}
				else {
					response.setContentType("text/html; charset=UTF-8");
					 
					PrintWriter out = response.getWriter();
					 
					out.println("<script>alert('정보를 확인하세요 !'); location.href='pw_find.jsp';</script>");
					 
					out.flush();


				}
				
			} catch (Exception e) {
				
				System.out.println(e);
			}
			return getPw;
		}
		
		
		
		
		
		
		




}//--------------------------------
