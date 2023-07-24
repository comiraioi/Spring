package album.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class AlbumBean {
	
	/* 테이블의 칼럼명과 bean의 변수명이 반드시 일치해야함 */
	private int num;
	
	@NotBlank(message="제목 입력 누락")
	private String title;
	
	@Size(min=3, max=7, message="3~7글자로 입력")
	private String singer;
	
	@Min(value=1000, message="1000원 이상으로 입력")
	private String price;	//유효성검사 int 불가능
	
	@NotBlank(message="발매일 입력 누락")
	private String day;
	
	public AlbumBean() {
		super();
	}

	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
}
