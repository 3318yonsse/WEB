package DTO;

public class shoppingDTO {
	//field
		int iNo;
		String iImage = "";
		String iName ;
		String iNation;
		String iCategory ;
		int iPrice;
		String iInfo;
		int iStock;
		String iClick;
		String iState;
		String iImage2 = "";
		
	//contructor
		public shoppingDTO(int iNo, String iImage, String iName, String iNation, String iCategory, int iPrice,
				String iInfo, int iStock, String iClick, String iState,String iImage2) {
			super();
			this.iNo = iNo;
			this.iImage = iImage;
			this.iName = iName;
			this.iNation = iNation;
			this.iCategory = iCategory;
			this.iPrice = iPrice;
			this.iInfo = iInfo;
			this.iStock = iStock;
			this.iClick = iClick;
			this.iState = iState;
			this.iImage2 = iImage2;
		}


		public shoppingDTO(int iNo, String iImage, String iName, String iNation, String iCategory, int iPrice,
				String iClick,int iStock) {
			super();
			this.iNo = iNo;
			this.iImage = iImage;
			this.iName = iName;
			this.iNation = iNation;
			this.iCategory = iCategory;
			this.iPrice = iPrice;
			this.iClick = iClick;
			this.iStock = iStock;
		}


		public String getiImage2() {
			return iImage2;
		}


		public void setiImage2(String iImage2) {
			this.iImage2 = iImage2;
		}


		public int getiNo() {
			return iNo;
		}


		public void setiNo(int iNo) {
			this.iNo = iNo;
		}


		public String getiImage() {
			return iImage;
		}


		public void setiImage(String iImage) {
			this.iImage = iImage;
		}


		public String getiName() {
			return iName;
		}


		public void setiName(String iName) {
			this.iName = iName;
		}


		public String getiNation() {
			return iNation;
		}


		public void setiNation(String iNation) {
			this.iNation = iNation;
		}


		public String getiCategory() {
			return iCategory;
		}


		public void setiCategory(String iCategory) {
			this.iCategory = iCategory;
		}


		public int getiPrice() {
			return iPrice;
		}


		public void setiPrice(int iPrice) {
			this.iPrice = iPrice;
		}


		public String getiInfo() {
			return iInfo;
		}


		public void setiInfo(String iInfo) {
			this.iInfo = iInfo;
		}


		public int getiStock() {
			return iStock;
		}


		public void setiStock(int iStock) {
			this.iStock = iStock;
		}


		public String getiClick() {
			return iClick;
		}


		public void setiClick(String iClick) {
			this.iClick = iClick;
		}




		public String getiState() {
			return iState;
		}


		public void setiState(String iState) {
			this.iState = iState;
		}
	
		
		
}
