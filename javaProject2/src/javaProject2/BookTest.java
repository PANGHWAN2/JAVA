package javaProject2;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookTest bt = new BookTest();
		bt.test1();
	}
	public void test1() {
		String B1 = "B001,자바 프로그래밍,홍길동,25000,2021,멀티출판사";
		String B2 = "B002,자바스크립트,이몽룡,30000,2020,서울출판사";
		String B3 = "B003,HTML/CSS,성춘향,18000,2021,강남출판사";
		String M1 = "B001,자바 월드,홍길동,25000,2021,멀티출판사,5";
		String M2 = "B002,웹 월드,이몽룡,30000,2020,서울출판사,7";
		String M3 = "B003,게임 월드,성춘향,18000,2021,강남출판사,9";
		
		String[] BookNum = {B1,B2,B3};
		String[] MagazineNum = {M1,M2,M3};
		System.out.println("도서번호  도서명		저자	가격   	발행일	출판사");
		System.out.println("--------------------------------------------------------");
		for(int i=0;i<BookNum.length;i++) {
			String[] temp = BookNum[i].split(",");
			String bookNo = temp[0];
			String bookTitle = temp[1];
			String bookAuthor = temp[2];
			int bookPrice = 0;
			int bookYear = 0;
			String bookPublisher = temp[5] ;
			try {
				bookPrice = Integer.parseInt(temp[3].trim());
				bookYear = Integer.parseInt(temp[4].trim());
			
			} catch(NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
			Book BookResult = new Book(bookNo, bookTitle, bookAuthor, bookPrice, bookYear, bookPublisher);
			System.out.println(BookResult);			
		}
		
		System.out.println();
		System.out.println("잡지번호  잡지명	발행인	가격     발행연도	출판사   발행월");
		System.out.println("--------------------------------------------------------");
		for(int i=0;i<MagazineNum.length;i++) {
			String[] temp = MagazineNum[i].split(",");
			String bookNo = temp[0];
			String bookTitle = temp[1];
			String bookAuthor = temp[2];
			int bookPrice = 0;
			int bookYear = 0;
			String bookPublisher = temp[5] ;
			int month = 0;
			try {
				bookPrice = Integer.parseInt(temp[3].trim());
				bookYear = Integer.parseInt(temp[4].trim());
				month = Integer.parseInt(temp[6].trim());
			
			} catch(NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
			Magazine MagazineResult = new Magazine(bookNo, bookTitle, bookAuthor, bookPrice, bookYear, bookPublisher, month);
			System.out.println(MagazineResult);		
		}
	}

}
