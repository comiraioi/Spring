package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Main {

	public static void main(String[] args) {
		
		//appContext.xml -> example2 패키지 스캔 -> 어노테이션에 따라 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		System.out.println("------------------------");
		
		/* 
		//자식클래스 객체 생성	=> @Component("PointX"), @Component("PointY")
		Shape px = new PointX();	//부모타입으로 관리
		PointY py = new PointY();	//자식타입으로 관리
		System.out.println("----------------------");
		
		CircleImpl circle = new CircleImpl();	=> @Component("myCircleImpl")
		circle.setPoint(px);	//setter로 자식 객체(px 또는 py) 주입	=> @Autowired, @Qualifier("PointX")
		
		System.out.println(circle.make());	//자식 객체의 make() 메서드
		System.out.println("----------------------");
		
		RectangleImpl rect = new RectangleImpl();	=> @Component("myRectangleImpl")
		rect.setPoint(py);	=>  @Autowired, @Qualifier("PointY")
		System.out.println(rect.make());
		*/
		
		CircleImpl circle = (CircleImpl)context.getBean("myCircleImpl");
		System.out.println(circle.make());
		
		RectangleImpl rect = (RectangleImpl)context.getBean("myRectangleImpl");
		System.out.println(rect.make());
		
	}

}
