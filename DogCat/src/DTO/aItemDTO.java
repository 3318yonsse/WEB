package DTO;

public class aItemDTO {
	
	
	//field
	int iNo;
	String iImage = "";
	String iImageReal = "";
	String iImage2 = "";
	String iImageReal2 = "";
	String iName ;
	String iNation;
	String iCategory ;
	int iPrice;
	String iInfo;
	int iStock;
	String iClick;
	String iInsertdate;
	String iState;
	String iUpdatedate;
	String iDeletedate;
	
	
	//constructor
	
	







	public aItemDTO(int iNo, String iImage, String iImageReal, String iName, String iNation, String iCategory,
			int iPrice, String iInfo, int iStock, String iClick, String iInsertdate, String iState) {
		super();
		this.iNo = iNo;
		this.iImage = iImage;
		this.iImageReal = iImageReal;
		this.iName = iName;
		this.iNation = iNation;
		this.iCategory = iCategory;
		this.iPrice = iPrice;
		this.iInfo = iInfo;
		this.iStock = iStock;
		this.iClick = iClick;
		this.iInsertdate = iInsertdate;
		this.iState = iState;
	}

	
	
	public aItemDTO(int iNo, String iImage, String iName, String iNation, String iCategory, int iPrice, String iImage2, String iInfo,
			int iStock, String iClick, String iInsertdate, String iState) {
		super();
		this.iNo = iNo;
		this.iImage = iImage;
		this.iImage2 = iImage2;
		this.iName = iName;
		this.iNation = iNation;
		this.iCategory = iCategory;
		this.iPrice = iPrice;
		this.iInfo = iInfo;
		this.iStock = iStock;
		this.iClick = iClick;
		this.iInsertdate = iInsertdate;
		this.iState = iState;
	}

	
	
	
	
	
	
	
	

	public aItemDTO(int iNo, String iImage, String iName, String iNation, String iCategory, int iPrice, String iInfo,
			int iStock, String iClick, String iInsertdate, String iState) {
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
		this.iInsertdate = iInsertdate;
		this.iState = iState;
	}



	public String getiImage2() {
		return iImage2;
	}



	public void setiImage2(String iImage2) {
		this.iImage2 = iImage2;
	}



	public String getiImageReal2() {
		return iImageReal2;
	}



	public void setiImageReal2(String iImageReal2) {
		this.iImageReal2 = iImageReal2;
	}



	public String getiClick() {
		return iClick;
	}



	public void setiClick(String iClick) {
		this.iClick = iClick;
	}



	public int getiNo() {
		return iNo;
	}
	

	public String getiNation() {
		return iNation;
	}


	public void setiNation(String iNation) {
		this.iNation = iNation;
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


	public String getiImageReal() {
		return iImageReal;
	}


	public void setiImageReal(String iImageReal) {
		this.iImageReal = iImageReal;
	}


	public String getiName() {
		return iName;
	}


	public void setiName(String iName) {
		this.iName = iName;
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


	public String getiInsertdate() {
		return iInsertdate;
	}


	public void setiInsertdate(String iInsertdate) {
		this.iInsertdate = iInsertdate;
	}


	public String getiState() {
		return iState;
	}


	public void setiState(String iState) {
		this.iState = iState;
	}


	public String getiUpdatedate() {
		return iUpdatedate;
	}


	public void setiUpdatedate(String iUpdatedate) {
		this.iUpdatedate = iUpdatedate;
	}


	public String getiDeletedate() {
		return iDeletedate;
	}


	public void setiDeletedate(String iDeletedate) {
		this.iDeletedate = iDeletedate;
	}
	
}
