package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.aQnaDTO;

public class aQnaDAO {
	DataSource dataSource; // 
	
	//constructor
	public aQnaDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	
	//list띄우기
	public ArrayList<aQnaDTO> list(ServletRequest request) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<aQnaDTO> dtos = new ArrayList<aQnaDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

		if(queryName == null) {
			queryName = "qContent";
			queryContent = "";
		}
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select qNo,items_iNo, mId, qCategory, qTitle, qInsertdate, qUpdatedate, qDeletedate, qClick, qImage ";
			String query2 = "from catNdog.qna "; 
			String query3 = "where qDeletedate IS null ";
			String query4 =  " and " + queryName + " like '%" + queryContent + "%'";
			
			preparedStatement = connection.prepareStatement(query+query2+query3+query4);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int qNo = resultSet.getInt("qNo");// 번호 1 번 적어도 됨.
				int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
				String mId = resultSet.getString("mId");
				String qCategory = resultSet.getString("qCategory");
				String qTitle = resultSet.getString("qTitle");
				String qInsertdate = resultSet.getString("qInsertdate");
				String qUpdatedate = resultSet.getString("qUpdatedate");
				String qDeletedate = resultSet.getString("qDeletedate");
				int qClick = resultSet.getInt("qClick");
				String qImage = resultSet.getString("qImage");
				
				
				aQnaDTO dto = new aQnaDTO(qNo, items_iNo, qImage, mId, qCategory, qTitle, qInsertdate, qUpdatedate, qDeletedate, qClick);
						
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
	public aQnaDTO QNAview(String strqNo) {
		
		aQnaDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
		ResultSet resultSet = null;
		//--->
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select qNo,items_iNo, qna.mId, qCategory, qTitle, qContent, qInsertdate, qUpdatedate, qDeletedate, qClick, qImage,qComment ";
			String query2 = "from catNdog.qna, catNdog.member "; 
			String query3 = " where qDeletedate IS null and qNo = ?";
			preparedStatement = connection.prepareStatement(query+query2+query3);
			preparedStatement.setInt(1, Integer.parseInt(strqNo));
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int qNo = resultSet.getInt("qNo");// 번호 1 번 적어도 됨.
				int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
				String qImage = resultSet.getString("qImage");
				String mId = resultSet.getString("mId");
				String qCategory = resultSet.getString("qCategory");
				String qTitle = resultSet.getString("qTitle");
				String qContent = resultSet.getString("qContent");
				String qInsertdate = resultSet.getString("qInsertdate");
				String qUpdatedate = resultSet.getString("qUpdatedate");
				String qDeletedate = resultSet.getString("qDeletedate");
				int qClick = resultSet.getInt("qClick");
				String qComment = resultSet.getString("qComment");
				
				
				dto = new aQnaDTO(qNo, items_iNo, qImage, mId, qCategory, qTitle, qContent, qInsertdate, qUpdatedate, qDeletedate, qClick,qComment);
	
			
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
	public void addview(String qNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update qna set qClick = qClick+1 where qNo = ?";
			preparedStatement = connection.prepareStatement(query);

			
			preparedStatement.setInt(1, Integer.parseInt(qNo));
			
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
	
	public void postWrite(String qComment) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into catNdog.qna (qComment) values(?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, qComment);
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
	public void qnamodi(String qComment, String qNo) {

		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update catNdog.qna set qUpdatedate = now(), qComment = ? where qNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, qComment);
			preparedStatement.setString(2, qNo);
			
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
		public void QNADelete(String qNo) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update qna set qDeletedate = now() where qNo =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(qNo));
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
				String query = "select count(*) from catNdog.qna ";
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

	
}
