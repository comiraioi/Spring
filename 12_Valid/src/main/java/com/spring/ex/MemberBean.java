package com.spring.ex;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	@NotEmpty(message="아이디 입력 누락")	//id 변수에 값이 없으면 message 출력
	private String id;
	
	//@NotEmpty(message="비밀번호 입력 누락")
	@Size(min = 3, max = 5, message = "3~5자리로 입력하세요")		//글자수로 유효성검사
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력하세요")	//정규표현식: 0~9의 숫자만 (0번 이상->*, 1번 이상-> +, ^->시작, $->끝)
	private String passwd;
	
	public MemberBean() {
		super();
	}
	
	public MemberBean(String id, String passwd) {
		super();
		this.id = id;
		this.passwd = passwd;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
