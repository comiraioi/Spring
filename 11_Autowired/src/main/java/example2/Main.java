package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Main {

	public static void main(String[] args) {
		
		//appContext.xml -> example2 ��Ű�� ��ĵ -> ������̼ǿ� ���� ��ü ����
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		System.out.println("------------------------");
		
		/* 
		//�ڽ�Ŭ���� ��ü ����	=> @Component("PointX"), @Component("PointY")
		Shape px = new PointX();	//�θ�Ÿ������ ����
		PointY py = new PointY();	//�ڽ�Ÿ������ ����
		System.out.println("----------------------");
		
		CircleImpl circle = new CircleImpl();	=> @Component("myCircleImpl")
		circle.setPoint(px);	//setter�� �ڽ� ��ü(px �Ǵ� py) ����	=> @Autowired, @Qualifier("PointX")
		
		System.out.println(circle.make());	//�ڽ� ��ü�� make() �޼���
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
