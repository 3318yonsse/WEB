package DTO;

public class listDTO {


	
	
	
	
	
	
	int pNo;
	String pTitle;
	String pContent;
	String pImage;
	String pInsertdate;
	String pDeletedate;
	String pUpdatedate;
	int pClick;
	String pImageReal;
	
	
	
	int wcNo;
	String wcContent;
	String wcInsertdate;
	String wcDeletedate;
	int notice_nNo;
	
	String nTitle;

	int pwcNo;
	String mId1;
	String pwcContent;
	String pwcInsertdate;
	

	




	



	public listDTO(int pNo, String pTitle, String pInsertdate, int pClick) {
		super();
		this.pNo = pNo;
		this.pTitle = pTitle;
		this.pInsertdate = pInsertdate;
		this.pClick = pClick;
	}



	public listDTO(int pwcNo, String mId1, String pwcContent, String pwcInsertdate,int pNo) {
		super();
		this.pNo = pNo;
		this.pwcNo = pwcNo;
		this.mId1 = mId1;
		this.pwcContent = pwcContent;
		this.pwcInsertdate = pwcInsertdate;
	}



	public int getPwcNo() {
		return pwcNo;
	}



	public void setPwcNo(int pwcNo) {
		this.pwcNo = pwcNo;
	}



	public String getmId1() {
		return mId1;
	}



	public void setmId1(String mId1) {
		this.mId1 = mId1;
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



//	public listDTO(String mId1, String pTitle, String pInsertdate, String pwcNo) {
//		super();
//		this.pNo = mId1;
//		this.pTitle = pTitle;
//		this.pInsertdate = pInsertdate;
//		this.pClick = pwcNo;
//	}



	public listDTO(int wcNo, int notice_nNo, String wcContent, String wcInsertdate,String nTitle) {
		super();
		this.wcNo = wcNo;
		this.wcContent = wcContent;
		this.wcInsertdate = wcInsertdate;
		this.notice_nNo = notice_nNo;
		this.nTitle = nTitle;
	}














//	public int getqNo() {
//		return qNo;
//	}
//
//
//
//
//	public void setqNo(int qNo) {
//		this.qNo = qNo;
//	}
//
//
//
//
//	public int getItems_iNo() {
//		return items_iNo;
//	}
//
//
//
//
//	public void setItems_iNo(int items_iNo) {
//		this.items_iNo = items_iNo;
//	}
//
//
//
//
//	public String getqCategory() {
//		return qCategory;
//	}
//
//
//
//
//	public void setqCategory(String qCategory) {
//		this.qCategory = qCategory;
//	}
//
//
//
//
//	public String getqTitle() {
//		return qTitle;
//	}
//
//
//
//
//	public void setqTitle(String qTitle) {
//		this.qTitle = qTitle;
//	}
//
//
//
//
//	public String getqContent() {
//		return qContent;
//	}
//
//
//
//
//	public void setqContent(String qContent) {
//		this.qContent = qContent;
//	}
//
//
//
//
//	public String getqComment() {
//		return qComment;
//	}
//
//
//
//
//	public void setqComment(String qComment) {
//		this.qComment = qComment;
//	}
//
//
//
//
//	public String getqInsertdate() {
//		return qInsertdate;
//	}
//
//
//
//
//	public void setqInsertdate(String qInsertdate) {
//		this.qInsertdate = qInsertdate;
//	}
//
//
//
//
//	public String getqClick() {
//		return qClick;
//	}
//
//
//
//
//	public void setqClick(String qClick) {
//		this.qClick = qClick;
//	}
//
//
//
//
//	public String getMember_mNo() {
//		return member_mNo;
//	}
//
//
//
//
//	public void setMember_mNo(String member_mNo) {
//		this.member_mNo = member_mNo;
//	}



















	public int getpNo() {
		return pNo;
	}




	public String getnTitle() {
		return nTitle;
	}



	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}



	public int getNotice_nNo() {
		return notice_nNo;
	}
















	public void setNotice_nNo(int notice_nNo) {
		this.notice_nNo = notice_nNo;
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




	public int getWcNo() {
		return wcNo;
	}




	public void setWcNo(int wcNo) {
		this.wcNo = wcNo;
	}




	public String getWcContent() {
		return wcContent;
	}




	public void setWcContent(String wcContent) {
		this.wcContent = wcContent;
	}




	public String getWcInsertdate() {
		return wcInsertdate;
	}




	public void setWcInsertdate(String wcInsertdate) {
		this.wcInsertdate = wcInsertdate;
	}




	public String getWcDeletedate() {
		return wcDeletedate;
	}




	public void setWcDeletedate(String wcDeletedate) {
		this.wcDeletedate = wcDeletedate;
	}



	
	
	
	
	
	
	
	
	
	
	
}
