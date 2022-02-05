package javaProject2;

public class Book {
	String bookNo;
	String bookTitle;
	String bookAuthor;
	int bookYear;
	int bookPrice;
	String bookPublisher;

	public Book(String bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
	}

	public String getbookNo() {
		return bookNo;
	}

	public void setbookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getbookTitle() {
		return bookTitle;
	}

	public void setbookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getbookAuthor() {
		return bookAuthor;
	}

	public void setprdPrice(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getbookYear() {
		return bookYear;
	}

	public void setbookYear(int bookYear) {
		this.bookYear = bookYear;
	}

	public int getbookPrice() {
		return bookPrice;
	}

	public void setbookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getbookPublisher() {
		return bookPublisher;
	}

	public void setbookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	@Override
	public String toString() {
		String result = "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor+ ", bookPrice=" + bookPrice + ", bookYear=" + bookYear + ", bookPublisher=" + bookPublisher + "]";
		result = String.format("%s\t%s\t%s\t%d\t%d\t%s", bookNo, bookTitle, bookAuthor, bookPrice, bookYear,bookPublisher);
		return result;
	}
}
