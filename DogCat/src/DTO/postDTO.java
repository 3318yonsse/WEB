package DTO;

public class postDTO {


	public void setWcInsertdate(String wcInsertdate) {
		this.wcInsertdate = wcInsertdate;
	}
	//field
	int pNo;
	String pTitle;
	String pContent;
	String pImage;
	String pInsertdate;
	String pDeletedate;
	String pUpdatedate;
	int pClick;
	String pImageReal;
	int member_mNo;
	int wcNo;
	String wcContent;
	String wcInsertdate;
	int post_pNo;
	String mId;
	String pwcContent;
	String pwcInsertdate;
	String pwcDeletedate;
	
	
	
	
	
	//contructor
	

	public String getWcInsertdate() {
		return wcInsertdate;
	}

	public String getpwcContent() {
		return pwcContent;
	}




	





	public postDTO(int pNo, String wcContent, String mId) {
		super();
		this.pNo = pNo;
		this.wcContent = wcContent;
		this.mId = mId;
	}





	public postDTO(int pNo, String pImage, String mId,String pInsertdate,String pTitle,int pClick) {
		super();
		this.pNo = pNo;
		this.pImage = pImage;
		this.mId = mId;
		this.pInsertdate = pInsertdate;
		this.pTitle = pTitle;
		this.pClick = pClick;
	}





	public postDTO(int pNo,String mId,String pInsertdate, String pTitle,int pClick) {
		super();
		this.pNo = pNo;
		this.mId = mId;
		this.pInsertdate = pInsertdate;
		this.pTitle = pTitle;
		this.pClick = pClick;
	}





	public postDTO(String mId, String wcContent, String wcInsertdate) {
		super();
		this.mId = mId;
		this.pwcContent = wcContent;
		this.pwcInsertdate = wcInsertdate;
	}





	public String getmId() {
		return mId;
	}





	public void setmId(String mId) {
		this.mId = mId;
	}





	public postDTO(String wcContent, String wcInsertdate) {
		super();
		this.wcContent = wcContent;
		this.wcInsertdate = wcInsertdate;
	}






	public postDTO(String wcContent, int member_mNo) {
		super();
		this.wcContent = wcContent;
		this.member_mNo = member_mNo;
	}










	public void setWcContent(String wcContent) {
		this.wcContent = wcContent;
	}










	public postDTO(int pNo, String pTitle, String pInsertdate, int pClick, int member_mNo) {
		super();
		this.pNo = pNo;
		this.pTitle = pTitle;
		this.pInsertdate = pInsertdate;
		this.pClick = pClick;
		this.member_mNo = member_mNo;
	}

	
	







	public postDTO(int pNo, String pTitle, String pInsertdate, int pClick) {
		super();
		this.pNo = pNo;
		this.pTitle = pTitle;
		this.pInsertdate = pInsertdate;
		this.pClick = pClick;
	}










	public postDTO(int pNo,String mId, String pImage, String pInsertdate, String pTitle, int pClick, String pContent) {
		super();
		this.pNo = pNo;
		this.mId = mId;
		this.pImage = pImage;
		this.pInsertdate = pInsertdate;
		this.pTitle = pTitle;
		this.pClick = pClick;
		this.pContent = pContent;
	}














	public int getPost_pNo() {
		return post_pNo;
	}

	public void setPost_pNo(int post_pNo) {
		this.post_pNo = post_pNo;
	}

	public String getPwcContent() {
		return pwcContent;
	}

	public void setPwcContent(String pwcContent) {
		this.pwcContent = pwcContent;
	}

	public String getPwcInsertdate() {
		return pwcInsertdate;
	}

	public void setPwcInsertdate(String pwcInsertdate) {
		this.pwcInsertdate = pwcInsertdate;
	}

	public String getPwcDeletedate() {
		return pwcDeletedate;
	}

	public void setPwcDeletedate(String pwcDeletedate) {
		this.pwcDeletedate = pwcDeletedate;
	}

	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpInsertdate() {
		return pInsertdate;
	}
	public void setpInsertdate(String pInsertdate) {
		this.pInsertdate = pInsertdate;
	}
	public String getpDeletedate() {
		return pDeletedate;
	}
	public void setpDeletedate(String pDeletedate) {
		this.pDeletedate = pDeletedate;
	}
	public String getpUpdatedate() {
		return pUpdatedate;
	}
	public void setpUpdatedate(String pUpdatedate) {
		this.pUpdatedate = pUpdatedate;
	}
	public int getpClick() {
		return pClick;
	}
	public void setpClick(int pClick) {
		this.pClick = pClick;
	}
	public String getpImageReal() {
		return pImageReal;
	}
	public void setpImageReal(String pImageReal) {
		this.pImageReal = pImageReal;
	}
	public int getMember_mNo() {
		return member_mNo;
	}
	public void setMember_mNo(int member_mNo) {
		this.member_mNo = member_mNo;
	}

	
	
	
	
	
}
