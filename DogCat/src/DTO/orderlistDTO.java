package DTO;

public class orderlistDTO {

	int items_iNo;
	String iName;
	String odate;
	int oNo;
	int oSum;
	int member_mNo;
	String iImage = "";
	String iImageReal = "";
	int oDelno;
	String oState;
	























	public orderlistDTO(int items_iNo ,String iImage,String iName, String odate, int oNo, int oSum,int oDelno,String oState) {
		super();
		this.items_iNo = items_iNo;
		this.iImage = iImage;
		this.iName = iName;
		this.odate = odate;
		this.oNo = oNo;
		this.oSum = oSum;
		this.oDelno = oDelno;
		this.oState = oState;
	}













	public int getoDelno() {
		return oDelno;
	}













	public void setoDelno(int oDelno) {
		this.oDelno = oDelno;
	}













	public String getoState() {
		return oState;
	}













	public void setoState(String oState) {
		this.oState = oState;
	}













	public int getItems_iNo() {
		return items_iNo;
	}













	public void setItems_iNo(int items_iNo) {
		this.items_iNo = items_iNo;
	}













	public String getiName() {
		return iName;
	}













	public void setiName(String iName) {
		this.iName = iName;
	}













	public String getOdate() {
		return odate;
	}













	public void setOdate(String odate) {
		this.odate = odate;
	}













	public int getoNo() {
		return oNo;
	}













	public void setoNo(int oNo) {
		this.oNo = oNo;
	}













	public int getoSum() {
		return oSum;
	}













	public void setoSum(int oSum) {
		this.oSum = oSum;
	}













	public int getMember_mNo() {
		return member_mNo;
	}













	public void setMember_mNo(int member_mNo) {
		this.member_mNo = member_mNo;
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







}