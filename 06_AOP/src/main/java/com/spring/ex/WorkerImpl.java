package com.spring.ex;

public class WorkerImpl implements Worker{
	
	private String name;
	private int age;
	private String job;

	public WorkerImpl() {
		super();
	}

	public WorkerImpl(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public void getWorkerInfo() {
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("직업: "+job);
	}

}
