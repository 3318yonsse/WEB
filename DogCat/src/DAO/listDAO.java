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
import DTO.listDTO;
import DTO.postDTO;
import DTO.qnaDTO;

public class listDAO {

	
	//DAO 데이터베이스 관련 작업을 수행--------------------------
	
			////외부에서 생성을 못하도록 Default생성자는 private으로 선언합니다. 
			DataSource dataSource;
			
			
			public listDAO() {
				try {
					Context context = new InitialContext();
					dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");

				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
			
			//method
			public ArrayList<listDTO> commentlist(String mId) { 
				
				//선언자.  --> 무조건 맨 위에/!
				ArrayList<listDTO> dtocomment = new ArrayList<listDTO>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				//--->
				
				try {
					connection = dataSource.getConnection();
					String query = "select p.pNo, w.pwcNo, w.pwcContent, w.pwcInsertdate, w.mId";
					String query2 = " from catndog.post as p, catndog.postwritecomment as w where post_pNo = pNo and w.mId = ? " ;
					preparedStatement = connection.prepareStatement(query + query2);
				
					preparedStatement.setString(1,mId);
					resultSet = preparedStatement.executeQuery();
					
					while (resultSet.next()) {
						// 번호 1 번 적어도 됨.
						int pNo = resultSet.getInt("pNo");
						int pwcNo = resultSet.getInt("pwcNo");
						String mId1 = resultSet.getString("mId");
						String pwcContent = resultSet.getString("pwcContent");
						String pwcInsertdate = resultSet.getString("pwcInsertdate");
						
						listDTO dto = new listDTO(pwcNo, mId1, pwcContent, pwcInsertdate,pNo);
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
			

			//method
			public ArrayList<listDTO> postlist(ServletRequest request,String nowID) { 
				String queryName = request.getParameter("query");
				String queryContent = request.getParameter("content");
				//선언자.  --> 무조건 맨 위에/!
				ArrayList<listDTO> dtos1 = new ArrayList<listDTO>();
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
					String query = "select pNo, pTitle, pInsertdate, pClick from post";
					String query2 = " where pDeletedate IS NULL and mId = '"+nowID+"' and " + queryName + " like '%" + queryContent + "%'";
					preparedStatement = connection.prepareStatement(query+query2);
					
					resultSet = preparedStatement.executeQuery();
					
					while (resultSet.next()) {
						int pNo = resultSet.getInt("pNo");// 번호 1 번 적어도 됨.
						String pTitle = resultSet.getString("pTitle");
						String pInsertdate = resultSet.getString("pInsertdate");
						int pClick = resultSet.getInt("pClick");
//						int member_mNo = resultSet.getInt("member_mNo");
						
						listDTO dto = new listDTO(pNo, pTitle, pInsertdate, pClick);
						dtos1.add(dto); //1번째 줄 2번째줄 알아서 착착착 들어갈 것이다.
						
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
				return dtos1;
			}
			
			
			public void commetnDel(String pwcNo) {

				//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				//--->
				
				try {
					connection = dataSource.getConnection();
					String query = "delete from postwritecomment where pwcNo =? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, Integer.parseInt(pwcNo));
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
			
				public void postDel(String pNo) {
					
					//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					//--->
					
					try {
						connection = dataSource.getConnection();
						String query = "delete from post where pNo =? ";
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
			
				public void postlistDel(String wcNo) {
					
					//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					//--->
					
					try {
						connection = dataSource.getConnection();
						String query = "delete from post where pNo =? ";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setInt(1, Integer.parseInt(wcNo));
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
				

				public int postlistViewRowCount(String mId) {
					int rowCount=0;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						String query = "select count(*) from post where pDeletedate IS NULL and mId = '"+ mId +"'";
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
				
				

				public int commentlistViewRowCount(String mId) {
					int rowCount=0;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					
					try {
						connection = dataSource.getConnection();
						String query = "select count(*) from postwritecomment where pwcDeletedate IS NULL and mId = '"+mId+"'";
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

