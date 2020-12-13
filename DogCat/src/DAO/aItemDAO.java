package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.aItemDTO;

public class aItemDAO {
	DataSource dataSource; // 
	
	//constructor
	public aItemDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	
	//list띄우기
	public ArrayList<aItemDTO> list(ServletRequest request) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<aItemDTO> dtos = new ArrayList<aItemDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

		if(queryName == null) {
			queryName = "iName";
			queryContent = "";
		}
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select iNo, iImage, iName, iNation, iCategory, iPrice, iInfo, iStock, iClick, iInsertdate, iState ";
			String query2 =  "from catNdog.items where iDeletedate IS NULL and " + queryName + " like '%" + queryContent + "%'";
			String query3 = " order by iStock desc";
			preparedStatement = connection.prepareStatement(query + query2 + query3);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int iNo = resultSet.getInt("iNo");// 번호 1 번 적어도 됨.
				String iImage = resultSet.getString("iImage");
				String iName = resultSet.getString("iName");
				String iNation = resultSet.getString("iNation");
				String iCategory = resultSet.getString("iCategory");
				int iPrice = resultSet.getInt("iPrice");
				String iInfo = resultSet.getString("iInfo");
				int iStock = resultSet.getInt("iStock");
				String iClick = resultSet.getString("iClick");
				String iInsertdate = resultSet.getString("iInsertdate");
				String iState = resultSet.getString("iState");
				
				aItemDTO dto = new aItemDTO(iNo, iImage, iName, iNation, iCategory, iPrice, iInfo, iStock, iClick, iInsertdate, iState);
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
	public aItemDTO itemview(String striNo) {
		
		aItemDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
		ResultSet resultSet = null;
		//--->
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from items where iNo =?";// ?안쓰면 해킹 당할 수 있다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(striNo));
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int iNo = resultSet.getInt("iNo");// 번호 1 번 적어도 됨.
				String iImage = resultSet.getString("iImage");
				String iImage2 = resultSet.getString("iImage2");
				String iName = resultSet.getString("iName");
				String iNation = resultSet.getString("iNation");
				String iCategory = resultSet.getString("iCategory");
				int iPrice = resultSet.getInt("iPrice");
				String iInfo = resultSet.getString("iInfo");
				int iStock = resultSet.getInt("iStock");
				String iClick = resultSet.getString("iClick");
				String iInsertdate = resultSet.getString("iInsertdate");
				String iState = resultSet.getString("iState");
				
				dto = new aItemDTO(iNo, iImage, iName, iNation, iCategory, iPrice, iImage2,iInfo, iStock, iClick ,iInsertdate, iState);
	
			
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
	public void addview(String iNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update items set iClick = iClick + 1 where iNo = ?";
			preparedStatement = connection.prepareStatement(query);

			
			preparedStatement.setInt(1, Integer.parseInt(iNo));
			
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
	
	public void iWrite(String iName, String iNation, String iCategory, int iPrice, String iInfo, String iImage, String iImageReal, String iImage2, String iImageReal2,int iStock) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into catNdog.items (iName, iNation, iCategory, iPrice, iImage, iImageReal, iImage2, iImageReal2, iInfo,";
			String query2 = " iStock, iClick, iInsertdate, iState) values(?,?,?,?,?,?,?,?,?,?,0,now(),'판매중') ";
			preparedStatement = connection.prepareStatement(query+query2);
			preparedStatement.setString(1, iName);
			preparedStatement.setString(2, iNation);
			preparedStatement.setString(3, iCategory);
			preparedStatement.setInt(4, iPrice);
			preparedStatement.setString(5, iImage);
			preparedStatement.setString(6, iImageReal);
			preparedStatement.setString(7, iImage2);
			preparedStatement.setString(8, iImageReal2);
			preparedStatement.setString(9, iInfo);
			preparedStatement.setInt(10, iStock);
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
	public void itemmodi(int iNo, String iImage, String iImageReal, String iImage2, String iImageReal2,String iName,  String iNation, String iCategory, int iPrice, String iInfo, int iStock, String iState) {

		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update items set iUpdatedate = now(), iImage = ?, iImageReal = ?, iName = ?, iNation = ? ,iCategory = ?,";
			String query2 = " iPrice = ?, iInfo = ?, iStock = ?, iState = ?, iImage2 = ?, iImageReal2 = ? where iNo = ? ";
			preparedStatement = connection.prepareStatement(query+query2);
			preparedStatement.setString(1, iImage);
			preparedStatement.setString(2, iImageReal);
			preparedStatement.setString(3, iName);
			preparedStatement.setString(4, iNation);
			preparedStatement.setString(5, iCategory);
			preparedStatement.setInt(6, iPrice);
			preparedStatement.setString(7, iInfo);
			preparedStatement.setInt(8, iStock);
			preparedStatement.setString(9, iState);
			preparedStatement.setString(10, iImage2);
			preparedStatement.setString(11, iImageReal2);
			preparedStatement.setInt(12, iNo);
			
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
	//주문 완료시 수량 변경
	public void chagestock(int iStock, int iNo) {
		
		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update items set iStock = ? where iNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, iStock);
			preparedStatement.setInt(2, iNo);
			
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
	//삭제하기
		public void itemdelete(String iNo) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update items set iDeletedate = now() where iNo =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(iNo));
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
				String query = "select count(*) from items ";
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
