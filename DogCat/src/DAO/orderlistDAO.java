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
import DTO.orderlistDTO;

public class orderlistDAO {
DataSource dataSource; // 
	
	//constructor
	public orderlistDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	
	//list띄우기
	public ArrayList<orderlistDTO> list(ServletRequest request, String nowID) { 
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<orderlistDTO> dtos = new ArrayList<orderlistDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

		if(queryName == null) {
			queryName = "oNo";
			queryContent = "";
		}
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select distinct(oNo) ,iImage, iName, odate, items_iNo, oSum, oDelno ,oState ";
			String query2 =  "from catNdog.items, catNdog.order, catNdog.member where iNo = items_iNo and member_mId ='"+ nowID +"' and " + queryName + " like '%" + queryContent + "%' ";
			preparedStatement = connection.prepareStatement(query + query2);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int items_iNo = resultSet.getInt("items_iNo");// 번호 1 번 적어도 됨.
				String iImage = resultSet.getString("iImage");
				String iName = resultSet.getString("iName");
				System.out.println(iName);
				String odate = resultSet.getString("odate");
				int oNo = resultSet.getInt("oNo");// 번호 1 번 적어도 됨.
				int oSum = resultSet.getInt("oSum");
				int oDelno = resultSet.getInt("oDelno");
				String oState = resultSet.getString("oState");
			
				
				orderlistDTO dto = new orderlistDTO(items_iNo,iImage,iName, odate, oNo, oSum,oDelno,oState);
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
	
	public int orderlistViewRowCount(String mId) {
		int rowCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from catNdog.order where member_mId = '"+ mId +"'";
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
