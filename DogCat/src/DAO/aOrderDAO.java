package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.aOrderDTO;

public class aOrderDAO {
	DataSource dataSource; // 

	public aOrderDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//list띄우기
		public ArrayList<aOrderDTO> list(ServletRequest request) { 
			String queryName = request.getParameter("query");
			String queryContent = request.getParameter("content");
			//선언자.  --> 무조건 맨 위에/!
			ArrayList<aOrderDTO> dtos = new ArrayList<aOrderDTO>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			//--->

			if(queryName == null) {
				queryName = "member_mId";
				queryContent = "";
			}
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select o.oNo, i.iImage, o.member_mId, i.iName, o.oName, o.oTel, o.oToName, o.oAddress, o.oToTel,";
				String query2 = " o.oPaymentMethod, o.oQty, i.iStock, o.oSum, iPrice, o.oDelno, o.odate, o.oState";
				String query3 =  " from catNdog.items i, catNdog.member m, catNdog.order o ";
				String query4 = "where m.mId = o.member_mId and i.iNo = o.items_iNo";
				String query5 = " and " + queryName + " like '%" + queryContent + "%' order by o.odate desc, o.oState IS NULL";
				
				preparedStatement = connection.prepareStatement(query + query2 + query3 + query4 + query5);
				
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					
					int oNo = resultSet.getInt("oNo");// 번호 1 번 적어도 됨.
					String iImage = resultSet.getString("iImage");
					String mId = resultSet.getString("member_mId");
					String iName = resultSet.getString("iName");
					String oName = resultSet.getString("oName");
					String oTel = resultSet.getString("oTel");
					String oToName = resultSet.getString("oToName");
					String oToTel = resultSet.getString("oToTel");
					String oAddress = resultSet.getString("oAddress");
					String oPaymentMethod = resultSet.getString("oPaymentMethod");
					String oQty = resultSet.getString("oQty");
					String iStock = resultSet.getString("iStock");
					
					int iPrice = resultSet.getInt("iPrice");
					int oSum = resultSet.getInt("oSum");
					int oDelno = resultSet.getInt("oDelno");
					String odate = resultSet.getString("odate");
					String oState = resultSet.getString("oState");
					
					
					aOrderDTO dto = new aOrderDTO(oNo, iImage, mId, iName, oName, oTel, oToName, oToTel, oAddress, oPaymentMethod, oQty, iStock, iPrice, oSum, oDelno, odate, oState);
					dtos.add(dto); 
					
					
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
		
		
		//주문내역 보기
		public aOrderDTO orderview(int stroNo) {
			
			aOrderDTO dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는 것 할려면 있어야 한다.
			ResultSet resultSet = null;
			//--->
			
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select oNo, iImage, mId, iName, oName, oTel, oToName, oAddress, oToTel,";
				String query2 = " oPaymentMethod, oQty, iStock, oSum, iPrice, oDelno, odate, oState";
				String query3 =  " from catNdog.items , catNdog.member, catNdog.order ";
				String query4 = "where mId = member_mId and iNo = items_iNo and oNo = ? order by odate desc,oState IS NULL ";
				
				
				
				preparedStatement = connection.prepareStatement(query + query2 + query3 + query4);
				preparedStatement.setInt(1,stroNo);
				resultSet = preparedStatement.executeQuery();
				
				if (resultSet.next()) {
					int oNo = resultSet.getInt("oNo");// 번호 1 번 적어도 됨.
					String iImage = resultSet.getString("iImage");
					String mId = resultSet.getString("mId");
					String iName = resultSet.getString("iName");
					String oName = resultSet.getString("oName");
					String oTel = resultSet.getString("oTel");
					String oToName = resultSet.getString("oToName");
					String oToTel = resultSet.getString("oToTel");
					String oAddress = resultSet.getString("oAddress");
					String oPaymentMethod = resultSet.getString("oPaymentMethod");
					String oQty = resultSet.getString("oQty");
					String iStock = resultSet.getString("iStock");
					
					int iPrice = resultSet.getInt("iPrice");
					int oSum = resultSet.getInt("oSum");
					int oDelno = resultSet.getInt("oDelno");
					String odate = resultSet.getString("odate");
					String oState = resultSet.getString("oState");
					
					dto = new aOrderDTO(oNo, iImage, mId,iName, oName, oTel, oToName, oToTel, oAddress, oPaymentMethod,
							oQty, iStock, iPrice,oSum, oDelno, odate, oState);
		
				
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
		
		
		
		//수정하기
		public void ordermodi(String oState, int oNo) 
		{

			//선언자.  --> 무조건 맨 위에/!
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update catNdog.order set oState = ? where oNo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, oState);
				preparedStatement.setInt(2, oNo);
				
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
			public void orderdelete(String oNo) {

				//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				//--->
				
				try {
					connection = dataSource.getConnection();
					String query = "update order set oDeletedate = now() oState = '주문취소' where oNo =? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, Integer.parseInt(oNo));
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
					String query = "select count(*) from catNdog.order ";
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
