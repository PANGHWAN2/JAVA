package javaProject2;

public class Magazine extends Book {
	int month;
	public Magazine(String bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher, int month) {
		super(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
		this.month = month;
	}
	public int getmonth() {
		return month;
	}

	public void setmonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		String result = super.toString() + "   " + month;
		//String result = "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice + ", bookYear=" + bookYear + ", bookPublisher=" + bookPublisher + ", month=" + month + "]";
		result = String.format("%s\t%s\t%s\t%d\t%d\t%s\t   %d", bookNo, bookTitle, bookAuthor, bookPrice, bookYear,bookPublisher,month);
		return result;
	}
}
