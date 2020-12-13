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

import DTO.orderDTO;
import DTO.postDTO;
import sun.rmi.server.Dispatcher;

public class orderDAO {

	DataSource dataSource; // 
	
	//constructor
	public orderDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//oNo, oSum
	public orderDTO orderlist(int Sum) { 
		
		//선언자.  --> 무조건 맨 위에/!
		orderDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->
		
		
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from catNdog.order where oSum = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Sum);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String oNo = resultSet.getString("oNo");
				String oQty = resultSet.getString("oQty");
				int oSum = resultSet.getInt("oSum");
				int iNo = resultSet.getInt("items_iNo");
				
				
				dto = new orderDTO(oNo, oSum,oQty,iNo);
				
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
	//items
	public orderDTO itemlist(int iNo) { 
		
		//선언자.  --> 무조건 맨 위에/!
		orderDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->
		
		
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from catNdog.items where iNo = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, iNo);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String iImage = resultSet.getString("iImage");
				String iName = resultSet.getString("iName");
				String iPrice = resultSet.getString("iPrice");
				String iStock = resultSet.getString("iStock");
				
				
				dto = new orderDTO(iImage, iName, iPrice,iStock);
				
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
	
	
	
	//Name, mTel
	public orderDTO infolist(String mId) { 
		
		//선언자.  --> 무조건 맨 위에/!
		orderDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

	
		
		try {
			connection = dataSource.getConnection();
			String query = "select mName, mTel from catNdog.member m where mId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mId);

			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String mName = resultSet.getString("mName");
				String mTel = resultSet.getString("mTel");
				
				
				dto = new orderDTO(mName, mTel);
				
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
	//총합계금액  1번
	public void orderSum(int iNo, int oQty, int oSum, String mId) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into catNdog.order (items_iNo, oQty ,oSum, member_mId, odate) values(?,?,?,?,now());";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, iNo);
			preparedStatement.setInt(2, oQty);
			preparedStatement.setInt(3, oSum);
			preparedStatement.setString(4, mId);
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

	//주문완료 버튼 (업데이트)
	
	public void ordermodi(String oName, String oTel, String oToName, String oToTel, String postcode, String oAddress
			, String oToContent, String oPaymentMethod, int oNo) {

		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update catNdog.order set oName = ?, oTel = ?, oToName = ?,";
			String query2 = " oToTel = ?, postcode = ?, oAddress = ?, oToContent = ?, oPaymentMethod = ? ,oState = '결제완료'";
			String query3 = " where oNo = ?";
			preparedStatement = connection.prepareStatement(query + query2+query3);
			preparedStatement.setString(1, oName);
			preparedStatement.setString(2, oTel);
			preparedStatement.setString(3, oToName);
			preparedStatement.setString(4, oToTel);
			preparedStatement.setString(5, postcode);
			preparedStatement.setString(6, oAddress);
			preparedStatement.setString(7, oToContent);
			preparedStatement.setString(8, oPaymentMethod);
			preparedStatement.setInt(9, oNo);
			
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
}	//취소버튼
		public void ordercancel(int oNo) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "delete from catNdog.order where oNo =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, oNo);
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

		
		
		
}//-----------
