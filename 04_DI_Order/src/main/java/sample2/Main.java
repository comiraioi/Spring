package sample2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
	/*
		OrderImplDao odao = new OrderImplDao();
		DeliveryImplDao ddao = new DeliveryImplDao();
		ServiceImplDao sdao = new ServiceImplDao();
		
		sdao.setOdao(odao);
		sdao.setDdao(ddao);		*/
		
	/*
		Resource resource = new ClassPathResource("orderContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		ServiceImplDao sdao = (ServiceImplDao)factory.getBean("sdao");	*/
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:orderContext.xml");
		ServiceImplDao sdao = (ServiceImplDao)context.getBean("sdao");
		
		sdao.order();
		sdao.cancel();

	}

}
