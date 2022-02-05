package javaProject1;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductTest pd = new ProductTest();
		pd.test1();
	}
	public void test1() {
		String product1 = "001,노트북,1200000,2021,삼성";
		String product2 = "002,모니터,300000,2021,LG";
		String product3 = "003,마우스,30000,2020,로지텍";
		
		String[] productnum = {product1,product2,product3};
		System.out.println("상품번호	 상품명	가격	연도   제조사");
		System.out.println("----------------------------------");
		for(int i=0;i<productnum.length;i++) {
			String[] temp = productnum[i].split(",");
			String prdNo = temp[0];
			String prdName = temp[1];
			int prdPrice = 0;
			int prdYear = 0;
			String prdMaker = temp[4] ;
			try {
				prdPrice = Integer.parseInt(temp[2].trim());
				prdYear = Integer.parseInt(temp[3].trim());
			
			} catch(NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
			Product result = new Product(prdNo,prdName,prdPrice,prdYear,prdMaker);
			System.out.println(result);
		}

	}

}