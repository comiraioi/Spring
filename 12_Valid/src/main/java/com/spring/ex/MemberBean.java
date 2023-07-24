package com.spring.ex;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	@NotEmpty(message="���̵� �Է� ����")	//id ������ ���� ������ message ���
	private String id;
	
	//@NotEmpty(message="��й�ȣ �Է� ����")
	@Size(min = 3, max = 5, message = "3~5�ڸ��� �Է��ϼ���")		//���ڼ��� ��ȿ���˻�
	@Pattern(regexp = "^[0-9]+$", message = "���ڸ� �Է��ϼ���")	//����ǥ����: 0~9�� ���ڸ� (0�� �̻�->*, 1�� �̻�-> +, ^->����, $->��)
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
