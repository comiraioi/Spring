package com.spring.ex;

public class PersonBean {
	private String id;
	private String passwd;
	private String addr;
	
	public PersonBean() {
		super();
		System.out.println("»ý¼ºÀÚ: PersonBean()");
	}

	public PersonBean(String id, String passwd, String addr) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId()");
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		System.out.println("setPasswd()");
		this.passwd = passwd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr()");
		this.addr = addr;
	}
	
	
}
