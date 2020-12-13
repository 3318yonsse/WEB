package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.aPostDTO;
import DTO.postDTO;


public class aPostDAO {
	DataSource dataSource; // 
	
	//constructor
	public aPostDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	
	//list띄우기
	public ArrayList<aPostDTO> list(ServletRequest request) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<aPostDTO> dtos = new ArrayList<aPostDTO>();
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
			String query = "select pNo, mId, pImage, pTitle, pInsertdate, pClick from catNdog.post where pDeletedate IS null and " + queryName + " like '%" + queryContent + "%'";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int pNo = resultSet.getInt("pNo");// 번호 1 번 적어도 됨.
				String pImage = resultSet.getString("pImage");
				String pTitle = resultSet.getString("pTitle");
				String pInsertdate = resultSet.getString("pInsertdate");
				int pClick = resultSet.getInt("pClick");
				String mId = resultSet.getString("mId");
				
				aPostDTO dto = new aPostDTO(pNo, pImage, pTitle, pInsertdate, mId, pClick);
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
	
	
	//게시판 글 보기
	public aPostDTO postview(int strpNo) {
		
		aPostDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
		ResultSet resultSet = null;
		//--->
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from post where pNo =?";// ?안쓰면 해킹 당할 수 있다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, strpNo);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int pNo = resultSet.getInt("pNo");// 번호 1 번 적어도 됨.
				String pImage = resultSet.getString("pImage");
				String pTitle = resultSet.getString("pTitle");
				String pContent = resultSet.getString("pContent");
				int pClick = resultSet.getInt("pClick");
				String pInsertdate = resultSet.getString("pInsertdate");
				
				
				dto = new aPostDTO(pNo, pImage, pTitle, pContent, pClick, pInsertdate);
	
			
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
	
	
	//조회수 
	public void addview(int pNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update post set pClick=pClick+1 where pNo = ?";
			preparedStatement = connection.prepareStatement(query);

			
			preparedStatement.setInt(1, pNo);
			
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
	
	//게시판 글쓰기
	
	public void postWrite(String pTitle, String pContent, String pImage, String pImageReal) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into catNdog.post (pTitle, pContent, pImage, pImageReal, pInsertdate, pClick, member_mNo) values(?,?,?,?,now(),0,1) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pTitle);
			preparedStatement.setString(2, pContent);
			preparedStatement.setString(3, pImage);
			preparedStatement.setString(4, pImageReal);
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

	
	//수정하기
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
			preparedStatement.setString(4, pImage);
			preparedStatement.setString(5, pNo);
			
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
		public void commentdelete(String pwcNo) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "delete from postwritecomment where pwcNo = ? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pwcNo);
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
				String query = "select count(*) from catNdog.post ";
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
		
		public void pcommentWrite(String pNo, String pwcContent) {
			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into postwritecomment (pwcContent, pwcInsertdate, post_pNo ,mId) values(?,now(),?,'admin') ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pwcContent);
				preparedStatement.setString(2, pNo);
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
		public ArrayList<aPostDTO> commentlist(int pNo) { 
			
			//선언자.  --> 무조건 맨 위에/!
			ArrayList<aPostDTO> dtocomment = new ArrayList<aPostDTO>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "select pwcNo, pwcContent, pwcInsertdate, mId from catNdog.postwritecomment where pwcDeletedate IS null and post_pNo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, pNo);
//				preparedStatement.setString(2,mId);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					// 번호 1 번 적어도 됨.
					String pwcNo = resultSet.getString("pwcNo");
					String mId = resultSet.getString("mId");
					String pwcContent = resultSet.getString("pwcContent");
					String pwcInsertdate = resultSet.getString("pwcInsertdate");
					
					aPostDTO dto = new aPostDTO(mId, pwcContent, pwcInsertdate, pwcNo);
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
		
}
