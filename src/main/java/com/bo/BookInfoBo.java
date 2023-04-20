package com.bo;

public class BookInfoBo {

	private int id;
	private String bookName;
	private String authorName;
	private String bookId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public BookInfoBo(String bookName, String authorName, String bookId) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookId = bookId;
	}
	public BookInfoBo(int id, String bookName, String authorName, String bookId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookId = bookId;
	}
	public BookInfoBo() {
		super();
	}
	
	
	
	
}