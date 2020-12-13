package DTO;

public class orderDTO {

	
	//field
	String oNo ;
	String iImage = "";
	String iName;
	String iPrice;
	String oQty;
	int oSum ;
	int iNo ;
	String odate;
	String mName ;
	String mTel ;
	String iStock;
	
	
	
	

	//constructor
	public orderDTO() {
		// TODO Auto-generated constructor stub
	}







	public orderDTO(String iImage, String iName, String iPrice,String iStock) 
	{
		super();
		this.iImage = iImage;
		this.iName = iName;
		this.iPrice = iPrice;
		this.iStock = iStock;
	}







	public orderDTO(String oNo, int oSum ,String oQty, int iNo) {
		super();
		this.oNo = oNo;
		this.oQty = oQty;
		this.oSum = oSum;
		this.iNo = iNo;
	}



	public orderDTO(String mName, String mTel) {
		super();
		this.mName = mName;
		this.mTel = mTel;
	}



	public orderDTO(int oSum) {
		super();
		this.oSum = oSum;
	}






	public String getoQty() {
		return oQty;
	}





	public void setoQty(String oQty) {
		this.oQty = oQty;
	}





	public String getmName() {
		return mName;
	}





	public void setmName(String mName) {
		this.mName = mName;
	}





	public String getmTel() {
		return mTel;
	}





	public void setmTel(String mTel) {
		this.mTel = mTel;
	}





	public String getoNo() {
		return oNo;
	}





	public void setoNo(String oNo) {
		this.oNo = oNo;
	}





	public int getoSum() {
		return oSum;
	}





	public void setoSum(int oSum) {
		this.oSum = oSum;
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



	public String getiPrice() {
		return iPrice;
	}



	public void setiPrice(String iPrice) {
		this.iPrice = iPrice;
	}



	public String getOdate() {
		return odate;
	}



	public void setOdate(String odate) {
		this.odate = odate;
	}







	public int getiNo() {
		return iNo;
	}







	public void setiNo(int iNo) {
		this.iNo = iNo;
	}







	public String getiStock() {
		return iStock;
	}







	public void setiStock(String iStock) {
		this.iStock = iStock;
	}
	
	
	
	
	
	
}