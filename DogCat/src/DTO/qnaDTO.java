package DTO;

public class qnaDTO {
	

	
	int qNo;
	int items_iNo;
	String qCategory;
	String qTitle;
	String qContent;
	String qComment;
	String qInsertdate;
	String qClick;
	String member_mNo = "1";
	String mId;
	String qImage="";
	String qImageReal="";
	
	
	
	
	
	











	

	public qnaDTO(int qNo, int items_iNo, String qCategory, String qTitle, String qInsertdate, String qClick,
			String qImage) {
		super();
		this.qNo = qNo;
		this.items_iNo = items_iNo;
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qInsertdate = qInsertdate;
		this.qClick = qClick;
		this.qImage = qImage;
		
	}












	public qnaDTO(String qCategory, String qTitle, String qContent, String qInsertdate, String qClick, String mId) {
		super();
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qInsertdate = qInsertdate;
		this.qClick = qClick;
		this.mId = mId;
	}









	









	public qnaDTO(int qNo, int items_iNo, String qCategory, String qTitle, String qContent, String qComment,
			String qInsertdate, String qClick, String member_mNo,String qImage) {
		super();
		this.qNo = qNo;
		this.items_iNo = items_iNo;
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qComment = qComment;
		this.qInsertdate = qInsertdate;
		this.qClick = qClick;
		this.member_mNo = member_mNo;
		this.qImage = qImage;
		
	}





















	public qnaDTO(String qCategory, String qTitle, String qContent) {
		super();
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qContent = qContent;
	}










	public String getqImage() {
		return qImage;
	}












	public void setqImage(String qImage) {
		this.qImage = qImage;
	}












	public String getmId() {
		return mId;
	}










	public void setmId(String mId) {
		this.mId = mId;
	}










	public int getqNo() {
		return qNo;
	}










	public void setqNo(int qNo) {
		this.qNo = qNo;
	}










	public int getItems_iNo() {
		return items_iNo;
	}










	public void setItems_iNo(int items_iNo) {
		this.items_iNo = items_iNo;
	}










	public String getqCategory() {
		return qCategory;
	}










	public void setqCategory(String qCategory) {
		this.qCategory = qCategory;
	}










	public String getqTitle() {
		return qTitle;
	}










	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}










	public String getqContent() {
		return qContent;
	}










	public void setqContent(String qContent) {
		this.qContent = qContent;
	}










	public String getqComment() {
		return qComment;
	}










	public void setqComment(String qComment) {
		this.qComment = qComment;
	}










	public String getqInsertdate() {
		return qInsertdate;
	}










	public void setqInsertdate(String qInsertdate) {
		this.qInsertdate = qInsertdate;
	}










	public String getqClick() {
		return qClick;
	}










	public void setqClick(String qClick) {
		this.qClick = qClick;
	}










	public String getMember_mNo() {
		return member_mNo;
	}










	public void setMember_mNo(String member_mNo) {
		this.member_mNo = member_mNo;
	}












	


	// qnaview
//	public qnaDTO(int qNo, int items_iNo, String qCategory, String qTitle, String qContent, String qComment,
//			String qInsertdate, String member_mNo) {
//		super();
//		this.qNo = qNo;
//		this.items_iNo = items_iNo;
//		this.qCategory = qCategory;
//		this.qTitle = qTitle;
//		this.qContent = qContent;
//		this.qComment = qComment;
//		this.qInsertdate = qInsertdate;
//		this.member_mNo = member_mNo;
//	}	





//	// mylist
//	public qnaDTO(int qNo, int items_iNo, String qCategory, String qTitle, String qContent, String qInsertdate) {
//		super();
//		this.qNo = qNo;
//		this.items_iNo = items_iNo;
//		this.qCategory = qCategory;
//		this.qTitle = qTitle;
//		this.qContent = qContent;
//		this.qInsertdate = qInsertdate;
//	}
//
//
//
//
//
//
//	// qnamyview
//	public qnaDTO(int qNo, int items_iNo, String qCategory, String qTitle, String qContent, String qComment,
//			String qInsertdate) {
//		super();
//		this.qNo = qNo;
//		this.items_iNo = items_iNo;
//		this.qCategory = qCategory;
//		this.qTitle = qTitle;
//		this.qContent = qContent;
//		this.qComment = qComment;
//		this.qInsertdate = qInsertdate;
//	}



	
}