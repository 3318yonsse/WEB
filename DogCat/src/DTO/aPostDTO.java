package DTO;

import java.sql.Timestamp;

public class aPostDTO {

	//field
		String pwcNo;
		int pNo;
		String pTitle;
		String pContent;
		String pImage = "";
		String pImageReal = "";
		String pInsertdate;
		String pDeletedate;
		String pUpdatedate;
		int pClick;
		int member_mNo;
		int wcNo;
		String pwcContent;
		String pwcInsertdate;
		String wcDeletedate;
		String mId;
		int post_pNo;

		
		
		
		//constructor
		
		public aPostDTO(String pwcContent,int member_mNo) {
			super();
			this.member_mNo = member_mNo;
			this.pwcContent = pwcContent;
		}
		
		public aPostDTO(String pwcContent, String pwcInsertdate) {
			super();
			this.pwcContent = pwcContent;
			this.pwcInsertdate = pwcInsertdate;
		}

		public aPostDTO(int pNo, String pTitle, String pInsertdate, int pClick, int member_mNo) {
			super();
			this.pNo = pNo;
			this.pTitle = pTitle;
			this.pInsertdate = pInsertdate;
			this.pClick = pClick;
			this.member_mNo = member_mNo;
		}

		public aPostDTO(int pNo, String pImage, String pTitle, String pInsertdate, String mId,int pClick) {
			super();
			this.pNo = pNo;
			this.pImage = pImage;
			this.mId = mId;
			this.pTitle = pTitle;
			this.pInsertdate = pInsertdate;
			this.pClick = pClick;
		}
		
		
		public aPostDTO(int pNo, String pImage, String pTitle, String pContent, int pClick, String pInsertdate) {
			super();
			this.pNo = pNo;
			this.pImage = pImage;
			this.pInsertdate = pInsertdate;
			this.pTitle = pTitle;
			this.pClick = pClick;
			this.pContent = pContent;
		}

		
		
		
		
		public aPostDTO(String mId, String pwcContent, String pwcInsertdate ,String pwcNo) {
			super();
			this.pwcContent = pwcContent;
			this.pwcInsertdate = pwcInsertdate;
			this.pwcNo = pwcNo;
			this.mId = mId;
		}

		public aPostDTO(int pNo, String pwcContent) {
			super();
			this.pNo = pNo;
			this.pwcContent = pwcContent;
		}

		
		
		
		
		
		
		public String getPwcNo() {
			return pwcNo;
		}

		public void setPwcNo(String pwcNo) {
			this.pwcNo = pwcNo;
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

		public String getmId() {
			return mId;
		}

		public void setmId(String mId) {
			this.mId = mId;
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

		public int getWcNo() {
			return wcNo;
		}

		public void setWcNo(int wcNo) {
			this.wcNo = wcNo;
		}

	

		public String getWcDeletedate() {
			return wcDeletedate;
		}

		public void setWcDeletedate(String wcDeletedate) {
			this.wcDeletedate = wcDeletedate;
		}

		public int getPost_pNo() {
			return post_pNo;
		}

		public void setPost_pNo(int post_pNo) {
			this.post_pNo = post_pNo;
		}

		
		
}


		
		
