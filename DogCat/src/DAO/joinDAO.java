package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class joinDAO {
	
	//field
	DataSource dataSource; // 
	
	
	//constructor
	public joinDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/catNdog");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//method
	public int join(String mId,String mPw,String mEmail,String mName,String postcode, String mAddress,String mTel,String mBirth,String mGender,String mState,String mDate) {
		
		//선언자.  --> 무조건 맨 위에/!  // 입력 수정 삭제 다똑같은 패턴.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into catNdog.member (mId,mPw,mEmail,mName,postcode,mAddress,mTel,mBirth,mGender,mState,mDate) values(?,?,?,?,?,?,?,?,?,'회원',now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mId);
			preparedStatement.setString(2, mPw);
			preparedStatement.setString(3, mEmail);
			preparedStatement.setString(4, mName);
			preparedStatement.setString(5, postcode);
			preparedStatement.setString(6, mAddress);
			preparedStatement.setString(7, mTel);
			preparedStatement.setString(8, mBirth);
			preparedStatement.setString(9, mGender);
			return preparedStatement.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
			
		}finally {   //error가 걸렸든 안걸렸든 일로 마지막에는 온다. 쓰레기가 안쌓이도록. 다 close해서 
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
			}
		}
	}
	
	
		public int idCheck(String mId){
		  int rst = 0;
		  
		  Connection conn = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  try{
		   conn = dataSource.getConnection();
		   String sql = "select * from catNdog.member where mId=?";
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, mId);
		   rs = ps.executeQuery();
		   if(rs.next()){
		    rst = 1;
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally{
			  try {
					if(ps != null) ps.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace(); //화면상에 보이는 에러는 여기서 찍히는 것이다.  
				}
		 }
		  return rst;
		}
	
	
}
