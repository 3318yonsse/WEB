package DTO;

import java.sql.Timestamp;

public class aNoticeDTO {

	public aNoticeDTO(String mId) {
		super();
		this.mId = mId;
	}



		//field
		String nNo;
		String nTitle;
		String nContent;
		String nInsertdate;
		String nDeletedate;
		String nUpdatedate;
		int nClick;
		String mId;
		String wcContent;
		String wcInsertdate;
		String wcNo;
		
		
		//constructor
		
		
		public aNoticeDTO(String wcNo,String mId, String wcContent, String wcInsertdate) {
			super();
			this.wcNo = wcNo;
			this.mId = mId;
			this.wcContent = wcContent;
			this.wcInsertdate = wcInsertdate;
		}
		
		
		
		
		public aNoticeDTO(String nNo, String nTitle, String nContent, String nInsertdate, int nClick, String mId) {
			super();
			this.mId = mId;
			this.nNo = nNo;
			this.nTitle = nTitle;
			this.nContent = nContent;
			this.nInsertdate = nInsertdate;
			this.nClick = nClick;
		}
		
		public aNoticeDTO(String nNo, String nTitle, String nContent, String nInsertdate, int nClick) {
			super();
			this.nNo = nNo;
			this.nTitle = nTitle;
			this.nContent = nContent;
			this.nInsertdate = nInsertdate;
			this.nClick = nClick;
		}
		





		public aNoticeDTO(String nTitle, String nContent) {
			super();
			this.nTitle = nTitle;
			this.nContent = nContent;
		}


		
		
		
		
		public String getWcNo() {
			return wcNo;
		}




		public void setWcNo(String wcNo) {
			this.wcNo = wcNo;
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




		public String getnNo() {
			return nNo;
		}



		public void setnNo(String nNo) {
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



		public String getnDeletedate() {
			return nDeletedate;
		}



		public void setnDeletedate(String nDeletedate) {
			this.nDeletedate = nDeletedate;
		}



		public String getnUpdatedate() {
			return nUpdatedate;
		}



		public void setnUpdatedate(String nUpdatedate) {
			this.nUpdatedate = nUpdatedate;
		}



		public int getnClick() {
			return nClick;
		}



		public void setnClick(int nClick) {
			this.nClick = nClick;
		}

		
		
		
		
		
}


		
		
