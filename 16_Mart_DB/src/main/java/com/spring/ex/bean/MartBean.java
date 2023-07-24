package com.spring.ex.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MartBean {
	
	private int num;
	
	@NotBlank(message="���̵� �Է��ϼ���")
	private String id;
	
	@NotBlank(message="��й�ȣ�� �Է��ϼ���")
	private String pw;
	
	@NotNull(message="1�� �̻��� ��ǰ�� �����ϼ���")
	private String product;
	
	@NotEmpty(message="��۽ð��� �����ϼ���")
	private String time;
	
	@NotEmpty(message="��������� �����ϼ���")
	private String approve;
	
	//@NotEmpty(message="���� ���Ǹ� �����ϼ���")
	private String agree;
	
	public MartBean() {
		super();
	}

	public MartBean(int num, String id, String pw, String product, String time, String approve, String agree) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.product = product;
		this.time = time;
		this.approve = approve;
		this.agree = agree;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}
	
	
}
