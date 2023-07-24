package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	@NotBlank(message="제목을 입력하세요") 	//text ->  @NotBlank(공백처리 가능), @NotEmpty(공백처리 불가)
	private String title;
	
	@Size(min = 3, message = "3글자 이상 입력하세요")
	private String author;
	
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력하세요")
	@Length(max = 5, message = "5자리 이하로 입력하세요")
	private String price;
	
	@NotEmpty(message="출판사를 입력하세요")
	private String publisher;
	
	@NotEmpty(message="서점 1개 이상을 선택하세요")		//checkbox -> @NotNull, @NotEmpty, @NotBlank
	private String bookstore;
	
	@NotNull(message="배송비를 선택하세요")	//radio -> @NotNull, @NotEmpty, @NotBlank
	private String kind;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookstore() {
		return bookstore;
	}
	public void setBookstore(String bookstore) {	//커맨드 객체 생성시 자동으로 배열 처리됨
		this.bookstore = bookstore;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
