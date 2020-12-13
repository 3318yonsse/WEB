package DTO;

public class aOrderDTO {

	//field
	int oNo;
	String iImage = "";
	String mId;
	String iName;
	String oName;
	String oTel;
	String oToName;
	String oToTel;
	String oAddress;
	String oPaymentMethod;
	String oQty;
	String iStock;
	
	int iPrice;
	int oSum;
	int oDelno;
	String odate;
	String oState;
	
	//constructor
	public aOrderDTO(int oNo, String iImage, String mId, String iName, String oName, String oTel, String oToName,
			String oToTel, String oAddress, String oPaymentMethod, String oQty, String iStock, int iPrice, int oSum,
			int oDelno, String odate, String oState) {
		super();
		this.oNo = oNo;
		this.iImage = iImage;
		this.mId = mId;
		this.iName = iName;
		this.oName = oName;
		this.iStock = iStock;
		this.oTel = oTel;
		this.oToName = oToName;
		this.oToTel = oToTel;
		this.oAddress = oAddress;
		this.oPaymentMethod = oPaymentMethod;
		this.oQty = oQty;
		this.iPrice = iPrice;
		this.oSum = oSum;
		this.oDelno = oDelno;
		this.odate = odate;
		this.oState = oState;
	}
	
	

	public String getiStock() {
		return iStock;
	}



	public void setiStock(String iStock) {
		this.iStock = iStock;
	}



	public int getiPrice() {
		return iPrice;
	}



	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}



	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public String getiImage() {
		return iImage;
	}

	public void setiImage(String iImage) {
		this.iImage = iImage;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoTel() {
		return oTel;
	}

	public void setoTel(String oTel) {
		this.oTel = oTel;
	}

	public String getoToName() {
		return oToName;
	}

	public void setoToName(String oToName) {
		this.oToName = oToName;
	}

	public String getoToTel() {
		return oToTel;
	}

	public void setoToTel(String oToTel) {
		this.oToTel = oToTel;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getoPaymentMethod() {
		return oPaymentMethod;
	}

	public void setoPaymentMethod(String oPaymentMethod) {
		this.oPaymentMethod = oPaymentMethod;
	}

	public String getoQty() {
		return oQty;
	}

	public void setoQty(String oQty) {
		this.oQty = oQty;
	}


	public int getoSum() {
		return oSum;
	}

	public void setoSum(int oSum) {
		this.oSum = oSum;
	}

	public int getoDelno() {
		return oDelno;
	}

	public void setoDelno(int oDelno) {
		this.oDelno = oDelno;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getoState() {
		return oState;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}	
	
	
	
	
}
