package DB;
import java.sql. *; 

public class MemberVO {
	String bookNum;
	String bookName;
	String author;
	String borrow;
	
	
	public String getBookNum() {
		return bookNum;
	}


	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getBorrow() {
		return borrow;
	}


	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}


	@Override
	public String toString() {
		return bookNum + "   " + bookName + "   " + author + "   " + borrow;
	}
	
	
	
}
