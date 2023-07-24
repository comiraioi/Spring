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
		
		/* appContext.xml(point, circle ��ü����)�� �����ϴ� resource(��ó) ��ü ����� */
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);	//resource�� ���� bean ����
		
		Circle circle = (Circle)factory.getBean("circle");	//�θ�Ÿ������ �ٿ�ĳ����
		circle.display();
		
		Point point = (Point)factory.getBean("point");
		System.out.println("xpos: "+point.getXpos());
		System.out.println("ypos: "+point.getYpos());
	}

}
