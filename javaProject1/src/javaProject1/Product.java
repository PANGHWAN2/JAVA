package javaProject1;

public class Product {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private int prdYear;
	private String prdMaker;

	public Product(String prdNo, String prdName,int prdPrice,int prdYear,String prdMaker) {
			this.prdNo = prdNo;
			this.prdName = prdName;
			this.prdPrice = prdPrice;
			this.prdYear = prdYear;
			this.prdMaker = prdMaker;
	}

	public String getprdNo() {
		return prdNo;
	}

	public void setprdNo(String prdNo) {
		this.prdNo = prdNo;
	}

	public String getprdName() {
		return prdName;
	}

	public void setprdName(String prdName) {
		this.prdName = prdName;
	}

	public int getprdPrice() {
		return prdPrice;
	}

	public void setprdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public int getprdYear() {
		return prdYear;
	}

	public void setprdYear(int prdYear) {
		this.prdYear = prdYear;
	}
	public String getprdMaker() {
		return prdMaker;
	}

	public void setprdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}

	@Override
	public String toString() {
		String result = "Product [prdNo=" + prdNo + ", prdNmae=" + prdName + ", prdPrice=" + prdPrice + ", prdYear=" + prdYear + ", prdMaker=" + prdMaker + "]";
		result = String.format("%s\t%4s\t%3d\t%3d  %s", prdNo, prdName, prdPrice, prdYear, prdMaker);
		return result;
	}

}
