package DTO;

public class noticeDTO {
	int nNo;
	String nTitle;
	String nContent;
	String nInsertdate;
	int nClick;
	String mId;
	String wcContent;
	String wcInsertdate;

	
	
	
	
	
	
	public noticeDTO(String mId, String wcContent, String wcInsertdate) {
		super();
		this.mId = mId;
		this.wcContent = wcContent;
		this.wcInsertdate = wcInsertdate;
	}

	public noticeDTO(int nNo, String nTitle, String nContent, String nInsertdate, int nClick) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nInsertdate = nInsertdate;
		this.nClick = nClick;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnInsertdate() {
		return nInsertdate;
	}

	public void setnInsertdate(String nInsertdate) {
		this.nInsertdate = nInsertdate;
	}

	public int getnClick() {
		return nClick;
	}

	public void setnClick(int nClick) {
		this.nClick = nClick;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
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
	
	
	
}
