package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;


import DTO.postDTO;
import sun.rmi.server.Dispatcher;

public class postDAO {

	DataSource dataSource; // 
	
	//constructor
	public postDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	public ArrayList<postDTO> list(ServletRequest request) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<postDTO> dtos = new ArrayList<postDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

		if(queryName == null) {
			queryName = "pContent";
			queryContent = "";
		}
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select pNo, pImage, mId, pInsertdate, pTitle, pClick from post where pDeletedate IS null and " + queryName + " like '%" + queryContent + "%' order by pNo desc" ;
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int pNo = resultSet.getInt("pNo");// 번호 1 번 적어도 됨.
				String pImage = resultSet.getString("pImage");
				String mId = resultSet.getString("mId");
				String pInsertdate = resultSet.getString("pInsertdate");
				String pTitle = resultSet.getString("pTitle");
				int pClick = resultSet.getInt("pClick");
//				int member_mNo = resultSet.getInt("member_mNo");
				
				postDTO dto = new postDTO(pNo, pImage, mId, pInsertdate, pTitle, pClick);
				dtos.add(dto); //1번째 줄 2번째줄 알아서 착착착 들어갈 것이다.
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
			}
		}
		return dtos;
	}
	
	public postDTO postview(String strpNo) {
		postDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
		ResultSet resultSet = null;
		//--->
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from post where pNo =?";// ?안쓰면 해킹 당할 수 있다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strpNo));
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int pNo = resultSet.getInt("pNo");// 번호 1 번 적어도 됨.
				String mId= resultSet.getString("mId");
				String pImage = resultSet.getString("pImage");
				String pInsertdate = resultSet.getString("pInsertdate");
				String pTitle = resultSet.getString("pTitle");
				int pClick = resultSet.getInt("pClick");
				String pContent = resultSet.getString("pContent");
				
				
				dto = new postDTO(pNo, mId, pImage, pInsertdate, pTitle, pClick, pContent);
	
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
			}
		}
		return dto;
	}
	
	
	public void addview(String pNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update post set pClick=pClick+1 where pNo = ?";
			preparedStatement = connection.prepareStatement(query);

			
			preparedStatement.setInt(1, Integer.parseInt(pNo));
			
			preparedStatement.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
			}
		}
		
	}
	
	public void postWrite(String pTitle, String pContent, String pImage,String pImageReal,String nowId /* String member_mNo*/) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into post (pTitle, pContent, pImage, pImageReal, pInsertdate, pClick, mId) values(?,?,?,?,now(),0,?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pTitle);
			preparedStatement.setString(2, pContent);
			preparedStatement.setString(3, pImage);
			preparedStatement.setString(4, pImageReal);
			preparedStatement.setString(5, nowId);
			preparedStatement.executeUpdate();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
			}
		}
}

	
public void postmodi(String pTitle, String pContent, String pImage, String pImageReal, String pNo) {

		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update post set pUpdatedate = now(), pTitle = ?, pContent = ?, pImage = ?, pImageReal = ? where pNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pTitle);
			preparedStatement.setString(2, pContent);
			preparedStatement.setString(3, pImage);
			preparedStatement.setString(4, pImageReal);
			preparedStatement.setInt(5, Integer.parseInt(pNo));
			
			preparedStatement.executeUpdate();
		
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();//화면상에 보이는 에러는 여기서 찍히는 것이다.  
			}
		}
}	
		public void postdelete(String pNo) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update post set pDeletedate = now() where pNo =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(pNo));
				preparedStatement.executeUpdate();
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
				}
			}
	}

		
	
		
		public int noticeViewRowCount() {
			int rowCount=0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select count(*) from notice ";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				
				while (resultSet.next()) {
					rowCount=resultSet.getInt(1);
		
					
				}
			}catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return rowCount;
		}
		
		
		
		public void pcommentWrite(String pNo, String pwcContent, String mId) {
			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into postwritecomment (pwcContent, pwcInsertdate, post_pNo ,mId) values(?,now(),?,?) ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pwcContent);
				preparedStatement.setString(2, pNo);
				preparedStatement.setString(3, mId);
				preparedStatement.executeUpdate();
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
				}
			}
		}
		public ArrayList<postDTO> commentlist(String pNo) { 
			
			//선언자.  --> 무조건 맨 위에/!
			ArrayList<postDTO> dtocomment = new ArrayList<postDTO>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "select pwcContent, pwcInsertdate, mId from catNdog.postwritecomment where pwcDeletedate IS null and post_pNo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(pNo));
//				preparedStatement.setString(2,mId);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					// 번호 1 번 적어도 됨.
					String mId = resultSet.getString("mId");
					String wcContent = resultSet.getString("pwcContent");
					String wcInsertdate = resultSet.getString("pwcInsertdate");
					
					postDTO dto = new postDTO(mId, wcContent, wcInsertdate);
					dtocomment.add(dto); //1번째 줄 2번째줄 알아서 착착착 들어갈 것이다.
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
				}
			}
			return dtocomment;
		}
		
		
}//-----------
