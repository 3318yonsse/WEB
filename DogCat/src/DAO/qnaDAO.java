package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;



import DTO.noticeDTO;
import DTO.qnaDTO;

public class qnaDAO {

	
	//DAO 데이터베이스 관련 작업을 수행--------------------------
	
		////외부에서 생성을 못하도록 Default생성자는 private으로 선언합니다. 
		DataSource dataSource;
		
		
		public qnaDAO() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		//method
		public ArrayList<qnaDTO> list(ServletRequest request, String nowID) { 
			String queryName = request.getParameter("query");
			String queryContent = request.getParameter("content");
			//선언자.  --> 무조건 맨 위에/!
			ArrayList<qnaDTO> dtos = new ArrayList<qnaDTO>();
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
				String query = "select qNo, items_iNo, qCategory, qTitle, qContent, qInsertdate,qClick,qImage from qna ";
				String query2 = "where mId = '" + nowID +"' and qDeletedate IS null ";
				String query3 = " and "+ queryName + " like '%" + queryContent + "%' order by qNo desc ";
				preparedStatement = connection.prepareStatement(query + query2+query3 );
				
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					int qNo = resultSet.getInt("qNo");// 번호 1 번 적어도 됨.
					int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
					String qCategory = resultSet.getString("qCategory");
					String qTitle = resultSet.getString("qTitle");
					String qInsertdate = resultSet.getString("qInsertdate");
					String qClick = resultSet.getString("qClick");
					String qImage = resultSet.getString("qImage");
					
					qnaDTO dto = new qnaDTO(qNo, items_iNo, qCategory, qTitle, qInsertdate,qClick,qImage);
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

		public qnaDTO qnaview(String strqNo) {
			qnaDTO dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
			ResultSet resultSet = null;
			//--->
			
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select * from qna where qNo = ? "; // ?안쓰면 해킹 당할 수 있다.
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(strqNo));
				resultSet = preparedStatement.executeQuery();
				
				if (resultSet.next()) {
					int qNo = resultSet.getInt("qNo");// 번호 1 번 적어도 됨.
					int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
					String qCategory = resultSet.getString("qCategory");
					String qTitle = resultSet.getString("qTitle");
					String qContent = resultSet.getString("qContent");
					String qComment = resultSet.getString("qComment");
					String qInsertdate = resultSet.getString("qInsertdate");
					String qClick = resultSet.getString("qClick");
					String member_mNo = resultSet.getString("member_mNo");
					String qImage = resultSet.getString("qImage");
					
					dto = new qnaDTO(qNo, items_iNo, qCategory, qTitle, qContent, qComment, qInsertdate,qClick,member_mNo,qImage);
		
				
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
		
		
		public void addview(String qNo) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update qna set qClick=qClick+1 where qNo = ?";
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
		
		
		
		public void qnawrite(String qCategory,String qTitle,String qContent,String qImage,String qImageReal, String nowID) {
			
			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into qna (qCategory, qTitle, qContent, mId, qInsertdate, qClick,qImage,qImageReal) values(?,?,?,?,now(),0,?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, qCategory);
				preparedStatement.setString(2, qTitle);
				preparedStatement.setString(3, qContent);
				preparedStatement.setString(4, nowID);
				preparedStatement.setString(5, qImage);
				preparedStatement.setString(6, qImageReal);
				
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

		
		
		
		public void qnaDelete(String qNo) {

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
		//수정하기
		public void qnamodi(String qTitle, String qContent, String qImage, String qImageReal, String qNo) {

			//선언자.  --> 무조건 맨 위에/!
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update qna set qUpdatedate = now(), qTitle = ?, qContent = ?, qImage = ?, qImageReal = ? where qNo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, qTitle);
				preparedStatement.setString(2, qContent);
				preparedStatement.setString(3, qImage);
				preparedStatement.setString(4, qImageReal);
				preparedStatement.setString(5, qNo);
				
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
		
		
		
		//		// 내가 쓴글 버튼 누르면 나오는 리스트
//		public ArrayList<qnaDTO> mylist(String member_mNo) { 
//			
//			//선언자.  --> 무조건 맨 위에/!
//			ArrayList<qnaDTO> dtos = new ArrayList<qnaDTO>();
//			Connection connection = null;
//			PreparedStatement preparedStatement = null;
//			ResultSet resultSet = null;
//			//--->
//			
//			try {
//				connection = dataSource.getConnection();
//				String query = "select qNo, items_iNo, qCategory, qTitle, qContent, qInsertdate from qna where member_mNo = '"+1+"' order by qNo desc ";
//				preparedStatement = connection.prepareStatement(query);
//				
//				resultSet = preparedStatement.executeQuery();
//				
//				while (resultSet.next()) {
//					int qNo = resultSet.getInt("qNo");// 번호 1 번 적어도 됨.
//					int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
//					String qCategory = resultSet.getString("qCategory");
//					String qTitle = resultSet.getString("qTitle");
//					String qContent = resultSet.getString("qContent");
//					String qInsertdate = resultSet.getString("qInsertdate");
//					
//					qnaDTO dto = new qnaDTO(qNo, items_iNo, qCategory, qTitle, qContent, qInsertdate);
//					dtos.add(dto); //1번째 줄 2번째줄 알아서 착착착 들어갈 것이다.
//					
//				}
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
//				try {
//					if(resultSet != null) resultSet.close();
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				} catch (Exception e) {
//					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
//				}
//			}
//			return dtos;
//		}

//		public qnaDTO qnamyview(String strqNo) {
//			qnaDTO dto = null;
//			Connection connection = null;
//			PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
//			ResultSet resultSet = null;
//			//--->
//			
//			
//			try {
//				connection = dataSource.getConnection();
//				
//				String query = "select * from qna where qNo = ? "; // ?안쓰면 해킹 당할 수 있다.
//				preparedStatement = connection.prepareStatement(query);
//				preparedStatement.setInt(1, Integer.parseInt(strqNo));
//				resultSet = preparedStatement.executeQuery();
//				
//				if (resultSet.next()) {
//					int qNo = resultSet.getInt("qNo");// 번호 1 번 적어도 됨.
//					int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
//					String qCategory = resultSet.getString("qCategory");
//					String qTitle = resultSet.getString("qTitle");
//					String qContent = resultSet.getString("qContent");
//					String qComment = resultSet.getString("qComment");
//					String qInsertdate = resultSet.getString("qInsertdate");
//					
//					
//					dto = new qnaDTO(qNo, items_iNo, qCategory, qTitle, qContent, qComment, qInsertdate);
//		
//				
//				}
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
//				try {
//					if(resultSet != null) resultSet.close();
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				} catch (Exception e) {
//					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
//				}
//			}
//			return dto;
//		}
		
		
	}  //------------------------
