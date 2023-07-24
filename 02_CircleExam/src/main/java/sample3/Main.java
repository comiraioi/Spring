package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
	/* 
		PointImpl point = new PointImpl();
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		CircleImpl circle = new CircleImpl(point,10.0);
		circle.display();
	*/
		
		/* appContext.xml(point, circle 객체생성)을 관리하는 resource(출처) 객체 만들기 */
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);	//resource에 따라 bean 생성
		
		Circle circle = (Circle)factory.getBean("circle");	//부모타입으로 다운캐스팅
		circle.display();
		
		Point point = (Point)factory.getBean("point");
		System.out.println("xpos: "+point.getXpos());
		System.out.println("ypos: "+point.getYpos());
	}

}
