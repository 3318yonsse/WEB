package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;


import DTO.aMemberDTO;

public class aMemberDAO {

	//field
	DataSource dataSource; // 

	
	
	//constructor
	public aMemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//method
	
	//field

		public ArrayList<aMemberDTO> list(ServletRequest request) { 
			
			String queryName = request.getParameter("query");
			String queryContent = request.getParameter("content");
			//선언자.  --> 무조건 맨 위에/!
			ArrayList<aMemberDTO> dtos = new ArrayList<aMemberDTO>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			//--->

			if(queryName == null) {
				queryName = "mId";
				queryContent = "";
			}
			
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select mNo, mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mGender, mState, mDate from catNdog.member ";
				String query1 ="where "+ queryName + " like '%" + queryContent + "%'";
				
				preparedStatement = connection.prepareStatement(query + query1);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					
					String mNo = resultSet.getString("mNo");// 번호 1 번 적어도 됨.
					String mId = resultSet.getString("mId");
					String mPw = resultSet.getString("mPw");
					String mName = resultSet.getString("mName");
					String mEmail = resultSet.getString("mEmail");
					String mAddress = resultSet.getString("mAddress");
					String mTel = resultSet.getString("mTel");
					String mBirth = resultSet.getString("mBirth");
					String mGender = resultSet.getString("mGender");
					String mState = resultSet.getString("mState");
					Timestamp mDate = resultSet.getTimestamp("mDate");
					
					aMemberDTO dto = new aMemberDTO(mNo, mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mGender, mState, mDate);
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
		
		//회원 탈퇴.
		public void delete(String mNo) {
			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					//--->
					
					try {
						
						connection = dataSource.getConnection();
						
						String query = "update catNdog.member set mState = '탈퇴' where mNo = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setInt(1, Integer.parseInt(mNo));
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
		
		//
		public ArrayList<aMemberDTO> memberSearch(String result1, String result2){ // 문의 검색 
			
			ArrayList<aMemberDTO> dtos = new ArrayList<aMemberDTO>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select mNo, mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mGender, mState, mDate from catNdog.member where userno >1  ";
				String query2 = " and "+ result1 + " like '%"+ result2 +"%'"; 
				
				System.out.println(query+query2);
				preparedStatement = connection.prepareStatement(query+query2);
				resultSet = preparedStatement.executeQuery();
				
				
				while (resultSet.next()) {
					String mNo = resultSet.getString("mNo");// 번호 1 번 적어도 됨.
					String mId = resultSet.getString("mId");
					String mPw = resultSet.getString("mPw");
					String mName = resultSet.getString("mName");
					String mEmail = resultSet.getString("mEmail");
					String mAddress = resultSet.getString("mAddress");
					String mTel = resultSet.getString("mTel");
					String mBirth = resultSet.getString("mBirth");
					String mGender = resultSet.getString("mGender");
					String mState = resultSet.getString("mState");
					Timestamp mDate = resultSet.getTimestamp("mDate");
					
					aMemberDTO dto = new aMemberDTO(mNo, mId, mPw, mName, mEmail, mAddress, mTel, mBirth, mGender, mState, mDate);
					dtos.add(dto);
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
			
			return dtos;	
		}
		
		public int noticeViewRowCount() {
			int rowCount=0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select count(*) from catNdog.member ";
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
