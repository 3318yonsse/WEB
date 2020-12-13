package DTO;

import java.sql.Timestamp;

public class aMemberDTO {

	
	//field
	String mNo; 
	String mId;
	String mPw;
	String mName;
	String mEmail;
	String mAddress;
	String mTel;
	String mBirth;
	String mGender;
	String mState;
	String result1;
	String result2;
	Timestamp mDate;
	
	
	//constructor
	public aMemberDTO(String mNo, String mId, String mPw, String mName, String mEmail, String mAddress, String mTel,
			String mBirth, String mGender, String mState, Timestamp mDate) {
		super();
		this.mNo = mNo;
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mAddress = mAddress;
		this.mTel = mTel;
		this.mBirth = mBirth;
		this.mGender = mGender;
		this.mState = mState;
		this.mDate = mDate;
	}


	public aMemberDTO(String result1, String result2) {
		super();
		this.result1 = result1;
		this.result2 = result2;
	}


	public String getResult1() {
		return result1;
	}


	public void setResult1(String result1) {
		this.result1 = result1;
	}


	public String getResult2() {
		return result2;
	}


	public void setResult2(String result2) {
		this.result2 = result2;
	}


	public String getmNo() {
		return mNo;
	}


	public void setmNo(String mNo) {
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


	public String getmGender() {
		return mGender;
	}


	public void setmGender(String mGender) {
		this.mGender = mGender;
	}


	public String getmState() {
		return mState;
	}


	public void setmState(String mState) {
		this.mState = mState;
	}


	public Timestamp getmDate() {
		return mDate;
	}


	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}
	
	

}
