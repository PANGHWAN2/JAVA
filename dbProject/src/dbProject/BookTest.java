package dbProject;

import java.sql.SQLException;

//TODO Auto-generated method stub
		//BookDAO 클래스의 insertBook() 메서드 호출하고 전달
		// - 입력 데이터 : B004 자바스크립트 강길동 2020 28000 서울출판사
		// - BookDAO 클래스의 selectBook() 호출해서 데이터 출력되도록

public class BookTest {

	public static void main(String[] args) {
		BookDAO bd = new BookDAO();
		
		try {
			BookDTO book = new BookDTO("B004","자바스크립트","강길동",2020,28000,"서울출판사");
			bd.insertBook(book);
			bd.selectBook();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	


}
