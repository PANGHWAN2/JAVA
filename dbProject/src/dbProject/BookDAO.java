package dbProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//public void insertBook(BookDTO bookDTO) { } : book 테이블에 데이터 저장
//public void selectBook() { } : book 테이블에 있는 모든 데이터 출력
public class BookDAO {

	public void insertBook(BookDTO dto) throws SQLException {
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();

		String sql = "insert into book(bookNo,bookTitle,bookAuthor,bookYear,bookPrice,bookPublisher) values(?,?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getBookNo());
		pstmt.setString(2, dto.getBookTitle());
		pstmt.setString(3, dto.getBookAuthor());
		pstmt.setInt(4, dto.getBookYear());
		pstmt.setInt(5, dto.getBookPrice());
		pstmt.setString(6, dto.getBookPublisher());

		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();

	}

	public void selectBook() throws SQLException {
		String sql = "select * from book";

		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.printf("%s\t%s\t%s\t%d\t%d\t%s \n", rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getString(6));
		}
		rs.close();
		stmt.close();
	}
}