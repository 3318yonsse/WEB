package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.aNoticeDTO;
import DTO.noticeDTO;

public class aNoticeDAO {
DataSource dataSource; // 
	
	//constructor
	public aNoticeDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	
	//list띄우기
	public ArrayList<aNoticeDTO> list(ServletRequest request) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<aNoticeDTO> dtos = new ArrayList<aNoticeDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

		if(queryName == null) {
			queryName = "nContent";
			queryContent = "";
		}
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from catNdog.notice where nDeletedate IS null "
					+ "and " + queryName + " like '%" + queryContent + "%'";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String nNo = resultSet.getString("nNo");// 번호 1 번 적어도 됨.
				String nTitle = resultSet.getString("nTitle");
				String nContent = resultSet.getString("nContent");
				String nInsertdate = resultSet.getString("nInsertdate");
				int nClick = resultSet.getInt("nClick");
				
				aNoticeDTO dto = new aNoticeDTO(nNo, nTitle, nContent, nInsertdate, nClick);
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
	
	//mId 글 보기
	public aNoticeDTO mIdview() {
		
		aNoticeDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
		ResultSet resultSet = null;
		//--->
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from catNdog.member ";// ?안쓰면 해킹 당할 수 있다.
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String mId = resultSet.getString("mId");// 번호 1 번 적어도 됨.
				
				dto = new aNoticeDTO(mId);
				
				
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
	
	//게시판 글 보기
	public aNoticeDTO noticeview(String strnNo) {
		
		aNoticeDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
		ResultSet resultSet = null;
		//--->
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from catNdog.notice where nNo =?";// ?안쓰면 해킹 당할 수 있다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strnNo));
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String nNo = resultSet.getString("nNo");// 번호 1 번 적어도 됨.
				String nTitle = resultSet.getString("nTitle");
				String nContent = resultSet.getString("nContent");
				String nInsertdate = resultSet.getString("nInsertdate");
				int nClick = resultSet.getInt("nClick");
				
				
				dto = new aNoticeDTO(nNo, nTitle, nContent, nInsertdate, nClick);
	
			
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
	public void addview(String nNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update notice set nClick=nClick+1 where nNo = ?";
			preparedStatement = connection.prepareStatement(query);

			
			preparedStatement.setInt(1, Integer.parseInt(nNo));
			
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
	
	public void noticeWrite(String nTitle, String nContent) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into notice (nTitle, nContent, nInsertdate, nClick) values(?,?,now(),0) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nTitle);
			preparedStatement.setString(2, nContent);
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
	public void Noticemodi(String nTitle, String nContent, String nNo) {

		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update notice set nUpdatedate = now(), nTitle = ?, nContent = ? where nNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nTitle);
			preparedStatement.setString(2, nContent);
			preparedStatement.setInt(3, Integer.parseInt(nNo));
			
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
		public void noticedelete(String nNo) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update notice set nDeletedate = now() where nNo =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(nNo));
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
				String query = "select count(*) from catNdog.notice ";
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
		public void commentWrite(String nNo, String wcContent, String mId) {
			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into writecomment (wcContent, wcInsertdate, notice_nNo ,mId) values(?,now(),?,'관리자') ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, wcContent);
				preparedStatement.setString(2, nNo);
//				preparedStatement.setString(3, mId);
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
		public ArrayList<aNoticeDTO> commentlist(String nNo) { 
			
			//선언자.  --> 무조건 맨 위에/!
			ArrayList<aNoticeDTO> dtocomment = new ArrayList<aNoticeDTO>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "select wcNo, wcContent, wcInsertdate, mId from catNdog.writecomment where notice_nNo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(nNo));
//				preparedStatement.setString(2,mId);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					// 번호 1 번 적어도 됨.
					String mId = resultSet.getString("mId");
					String wcNo = resultSet.getString("wcNo");
					String wcContent = resultSet.getString("wcContent");
					String wcInsertdate = resultSet.getString("wcInsertdate");
					
					aNoticeDTO dto = new aNoticeDTO(wcNo,mId, wcContent, wcInsertdate);
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
