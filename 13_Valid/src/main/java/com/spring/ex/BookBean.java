package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	@NotBlank(message="������ �Է��ϼ���") 	//text ->  @NotBlank(����ó�� ����), @NotEmpty(����ó�� �Ұ�)
	private String title;
	
	@Size(min = 3, message = "3���� �̻� �Է��ϼ���")
	private String author;
	
	@Pattern(regexp = "^[0-9]+$", message = "���ڸ� �Է��ϼ���")
	@Length(max = 5, message = "5�ڸ� ���Ϸ� �Է��ϼ���")
	private String price;
	
	@NotEmpty(message="���ǻ縦 �Է��ϼ���")
	private String publisher;
	
	@NotEmpty(message="���� 1�� �̻��� �����ϼ���")		//checkbox -> @NotNull, @NotEmpty, @NotBlank
	private String bookstore;
	
	@NotNull(message="��ۺ� �����ϼ���")	//radio -> @NotNull, @NotEmpty, @NotBlank
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
	public void setBookstore(String bookstore) {	//Ŀ�ǵ� ��ü ������ �ڵ����� �迭 ó����
		this.bookstore = bookstore;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
