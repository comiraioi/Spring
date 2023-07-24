package com.spring.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPmain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("aopExam.xml");
		
		Student student = (Student)context.getBean("mystudent");
		student.getStudentInfo();
		
		System.out.println("==================");
		
		Worker worker = (Worker)context.getBean("myworker");
		worker.getWorkerInfo();
	}

}
