package com.spring.ex;


public class StudentImpl implements Student{
	
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;

	public StudentImpl(String name, int age, int gradeNum, int classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	@Override
	public void getStudentInfo() {
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("학년: "+gradeNum);
		System.out.println("반: "+classNum);
	}

}
