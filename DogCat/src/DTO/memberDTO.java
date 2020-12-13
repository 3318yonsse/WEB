package DTO;

public class memberDTO {
  
	
	int mNo;
	String mId;
	String mPw;
	String mName;
	String mEmail;
	String mAddress;
	String mTel;
	String mBirth;
	String mState;
	
	
	
	



	public memberDTO(String mId, String mPw, String mName, String mEmail, String mAddress, String mTel, String mBirth,String mState) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mAddress = mAddress;
		this.mTel = mTel;
		this.mBirth = mBirth;
		this.mState = mState;
	}



	public int getmNo() {
		return mNo;
	}



	public void setmNo(int mNo) {
		this.mNo = mNo;
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



	public String getmName() {
		return mName;
	}



	public void setmName(String mName) {
		this.mName = mName;
	}



	public String getmEmail() {
		return mEmail;
	}



	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}



	public String getmAddress() {
		return mAddress;
	}



	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}



	public String getmTel() {
		return mTel;
	}



	public void setmTel(String mTel) {
		this.mTel = mTel;
	}



	public String getmBirth() {
		return mBirth;
	}



	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	
	
	
	
}
