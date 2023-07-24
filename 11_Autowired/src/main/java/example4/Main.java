package example4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Main {

	public static void main(String[] args) {
		/*
		Car morning = new Morning();	=> @Component("morning")
		Car sonata = new Sonata();		=> @Component("sonata")
		System.out.println("----------------------");
		
		Person con = new Consumer();	=> @Component("Consumer")
		con.setName("À¢µð");
		con.setAge(30);
		con.setCar(morning);			=> @Autowired, @Qualifier("morning")
		
		System.out.println(con.getName()+","+con.getAge()+","+con.personDrive());
		System.out.println("----------------------");
		
		Person con2 = new Consumer();
		con2.setName("Á¤±¹");
		con2.setAge(40);
		con2.setCar(sonata);
		
		System.out.println(con2.getName()+","+con2.getAge()+","+con2.personDrive());
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext2.xml");
		
		Person con = (Person)context.getBean("Consumer");
		con.setName("À¢µð");
		con.setAge(30);
		
		System.out.println(con.getName()+","+con.getAge()+","+con.personDrive());
		
		Person con2 = (Person)context.getBean("Consumer");
		con2.setName("Á¤±¹");
		con2.setAge(40);
		
		System.out.println(con2.getName()+","+con2.getAge()+","+con2.personDrive());

	}

}
