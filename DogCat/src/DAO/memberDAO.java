package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import DTO.memberDTO;
import DTO.postDTO;

public class memberDAO {

	
	DataSource dataSource; // 
	
	//constructor
	public memberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//method
	public ArrayList<memberDTO> list(String nowID) { 
		
		//선언자.  --> 무조건 맨 위에/!
		ArrayList<memberDTO> dtos = new ArrayList<memberDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//--->

		
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from catndog.member where mId = '"+nowID+"'"  ;
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String mId = resultSet.getString("mId");
				String mPw = resultSet.getString("mPw");
				String mName = resultSet.getString("mName");
				String mEmail = resultSet.getString("mEmail");
				String mAddress = resultSet.getString("mAddress");
				String mTel = resultSet.getString("mTel");
				String mBirth = resultSet.getString("mBirth");
				String mState = resultSet.getString("mState");
				
				
				
				memberDTO dto = new memberDTO(mId, mPw, mName,mEmail,mAddress,mTel,mBirth,mState);
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
	
	public void usermodi(String mPw, String mEmail, String mTel, String mAddress, String mBirth,String nowID) {

		//선언자.  --> 무조건 맨 위에/!
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "update catndog.member set mPw = ? , mEmail = ?, mTel = ?,  mAddress = ? , mBirth = ? where mId = '"+nowID+"'";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mPw);
			preparedStatement.setString(2, mEmail);
			preparedStatement.setString(3, mTel);
			preparedStatement.setString(4, mAddress);
			preparedStatement.setString(5, mBirth);
			
			
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
		public void memberOut(String nowId) {

			//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//--->
			
			try {
				connection = dataSource.getConnection();
				String query = "update catNdog.member set mState = '탈퇴' where mId = '"+nowId+"'";
				preparedStatement = connection.prepareStatement(query);
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


		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} //-------------------------------
