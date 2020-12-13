package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.shoppingDTO;

public class shoppingDAO {
	
	DataSource dataSource; // 

	public shoppingDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	
	//강아지 list띄우기
	public ArrayList<shoppingDTO> list(ServletRequest request) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<shoppingDTO> dtos = new ArrayList<shoppingDTO>();
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
			String query = "select iNo, iImage, iName, iNation, iCategory, iPrice, iClick, iStock ";
			String query2 =  "from catNdog.items where iCategory = '강아지' and iStock > 0 and iState ='판매중' and iDeletedate IS NULL and " + queryName + " like '%" + queryContent + "%'";
			String query3 = " order by iInsertdate";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int iNo = resultSet.getInt("iNo");// 번호 1 번 적어도 됨.
				String iImage = resultSet.getString("iImage");
				String iName = resultSet.getString("iName");
				String iNation = resultSet.getString("iNation");
				String iCategory = resultSet.getString("iCategory");
				int iPrice = resultSet.getInt("iPrice");
				String iClick = resultSet.getString("iClick");
				int iStock = resultSet.getInt("iStock");
				
				shoppingDTO dto = new shoppingDTO(iNo, iImage, iName, iNation, iCategory, iPrice, iClick, iStock);
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
	//강아지 list띄우기
	public ArrayList<shoppingDTO> list2(ServletRequest request) { 
		String queryName = request.getParameter("query1");
		String queryContent = request.getParameter("content1");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<shoppingDTO> dtos = new ArrayList<shoppingDTO>();
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
			String query = "select iNo, iImage, iName, iNation, iCategory, iPrice, iClick, iStock ";
			String query2 =  "from catNdog.items where iCategory = '고양이' and iStock > 0 and iState ='판매중' and iDeletedate IS NULL and " + queryName + " like '%" + queryContent + "%'";
			String query3 = " order by iInsertdate";
			
			preparedStatement = connection.prepareStatement(query + query2 + query3);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int iNo = resultSet.getInt("iNo");// 번호 1 번 적어도 됨.
				String iImage = resultSet.getString("iImage");
				String iName = resultSet.getString("iName");
				String iNation = resultSet.getString("iNation");
				String iCategory = resultSet.getString("iCategory");
				int iPrice = resultSet.getInt("iPrice");
				String iClick = resultSet.getString("iClick");
				int iStock = resultSet.getInt("iStock");
				
				shoppingDTO dto = new shoppingDTO(iNo, iImage, iName, iNation, iCategory, iPrice, iClick, iStock);
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
	public shoppingDTO shoppingview(String striNo) {
		
		shoppingDTO dto = null;
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
				String iName = resultSet.getString("iName");
				String iNation = resultSet.getString("iNation");
				String iCategory = resultSet.getString("iCategory");
				int iPrice = resultSet.getInt("iPrice");
				String iInfo = resultSet.getString("iInfo");
				int iStock = resultSet.getInt("iStock");
				String iClick = resultSet.getString("iClick");
				String iInsertdate = resultSet.getString("iInsertdate");
				String iState = resultSet.getString("iState");
				String iImage2 = resultSet.getString("iImage2");
				
				dto = new shoppingDTO(iNo, iImage, iName, iNation, iCategory, iPrice, iInfo, iStock, iClick , iState,iImage2);
	
			
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
