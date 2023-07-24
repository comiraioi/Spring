package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("myContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		MyInfo info = (MyInfo)factory.getBean("myinfo");
		
		info.personPrint();
		info.studentPrint();
	}

}
