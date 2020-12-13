package DTO;

public class loginDTO {
	
	private String mId;
	private String mPw;
	String getId;
	
	
	public loginDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public loginDTO(String mId, String mPw, String mEmail, String mName, String mAddress, String mTel, String mBirth,
			String mGender, String mState, String mDate) {
		super();
		this.mId = mId;
		this.mPw = mPw;
	}
	
	public loginDTO(String mId) {
		super();
		this.mId = mId;
	}
	
	
	
	

	public String getGetId() {
		return getId;
	}


	public void setGetId(String getId) {
		this.getId = getId;
	}


	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	
	

}
