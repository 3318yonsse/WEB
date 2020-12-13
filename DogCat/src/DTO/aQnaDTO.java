package DTO;

public class aQnaDTO {
	
	//field
	int qNo;// 번호 1 번 적어도 됨.
	int items_iNo;// 번호 1 번 적어도 됨.
	String mId;
	String qCategory;
	String qTitle;
	String qContent;
	String qComment;
	String qInsertdate ;
	String qUpdatedate;
	String qDeletedate;
	int qClick;
	String qImage = "";
	String qImageReal = "";
	//constructor
	
	
	public aQnaDTO() {
		// TODO Auto-generated constructor stub
	}


	





	public aQnaDTO(int qNo, int items_iNo, String qImage, String mId, String qCategory, String qTitle, String qInsertdate,
			String qUpdatedate, String qDeletedate, int qClick) {
		super();
		this.qNo = qNo;
		this.items_iNo = items_iNo;
		this.mId = mId;
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qInsertdate = qInsertdate;
		this.qUpdatedate = qUpdatedate;
		this.qDeletedate = qDeletedate;
		this.qClick = qClick;
		this.qImage = qImage;
	}








	public aQnaDTO(int qNo, int items_iNo, String qImage, String mId, String qCategory, String qTitle, String qContent,
			 String qInsertdate, String qUpdatedate, String qDeletedate, int qClick,String qComment) {
		super();
		this.qNo = qNo;
		this.items_iNo = items_iNo;
		this.mId = mId;
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qComment = qComment;
		this.qInsertdate = qInsertdate;
		this.qUpdatedate = qUpdatedate;
		this.qDeletedate = qDeletedate;
		this.qClick = qClick;
		this.qImage = qImage;
	}








	public aQnaDTO(String qComment,int qNo) {
		super();
		this.qNo = qNo;
		this.qComment = qComment;
	}








	public String getqUpdatedate() {
		return qUpdatedate;
	}








	public void setqUpdatedate(String qUpdatedate) {
		this.qUpdatedate = qUpdatedate;
	}








	public String getqDeletedate() {
		return qDeletedate;
	}








	public void setqDeletedate(String qDeletedate) {
		this.qDeletedate = qDeletedate;
	}








	public aQnaDTO(int qNo, int items_iNo, String qImage, String mId, String qCategory, String qTitle, String qContent,
			String qComment, String qInsertdate, String qUpdatedate, String qDeletedate, int qClick) {
		super();
		this.qNo = qNo;
		this.items_iNo = items_iNo;
		this.mId = mId;
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qComment = qComment;
		this.qInsertdate = qInsertdate;
		this.qInsertdate = qUpdatedate;
		this.qInsertdate = qDeletedate;
		this.qClick = qClick;
		this.qImage = qImage;
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

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
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

	public int getqClick() {
		return qClick;
	}

	public void setqClick(int qClick) {
		this.qClick = qClick;
	}

	public String getqImage() {
		return qImage;
	}

	public void setqImage(String qImage) {
		this.qImage = qImage;
	}

	
	
}
