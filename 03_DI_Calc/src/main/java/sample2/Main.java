package sample2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
	/*
		CalcBeanImpl cb = new CalcBeanImpl(4);	//생성자로 su2에 값 주입
		cb.setSu1(13);	//setter로 su1에 값 주입
	*/
		
		//Bean 객체 생성
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CalcBean cb = (CalcBean)factory.getBean("cbean");
		cb.calculate();	//메서드 호출
	}

}
