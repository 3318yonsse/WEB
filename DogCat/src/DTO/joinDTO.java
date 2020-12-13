package DTO;

public class joinDTO {
	private String mId;
	private String mPw;
	private String mEmail;
	private String mName;
	private String postcode;
	private String mAddress;
	private String mTel;
	private String mBirth;
	private String mGender;
	private String mState;
	private String mDate;
	
	
	
	public joinDTO() {
		// TODO Auto-generated constructor stub
	}

	
	


	public joinDTO(String mId) {
		super();
		this.mId = mId;
	}





	public joinDTO(String mId, String mPw, String mEmail, String mName, String postcode, String mAddress, String mTel,
			String mBirth, String mGender, String mState, String mDate) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mEmail = mEmail;
		this.mName = mName;
		this.postcode = postcode;
		this.mAddress = mAddress;
		this.mTel = mTel;
		this.mBirth = mBirth;
		this.mGender = mGender;
		this.mState = mState;
		this.mDate = mDate;
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



	public String getmEmail() {
		return mEmail;
	}



	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}



	public String getmName() {
		return mName;
	}



	public void setmName(String mName) {
		this.mName = mName;
	}



	public String getPostcode() {
		return postcode;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
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



	public String getmDate() {
		return mDate;
	}



	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	
	
	
	
	
	
}
