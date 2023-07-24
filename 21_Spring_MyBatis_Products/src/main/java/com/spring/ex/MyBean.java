package com.spring.ex;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBean implements InitializingBean{
	@Autowired
	ServletContext servletContext;
	
	@PostConstruct	//��Ű�� �������� => dependency �ۼ�
	public void init() {
		//������ ����Ǹ� ù��°�� ����Ǵ� �޼���
		System.out.println("===init()===");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("===afterPropertiesSet===");
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: "+uploadPath);
		File destination = new File(uploadPath);
		
		/* �ӽ� ���� */
		String str = "c:/tempUpload";
		File destination_local = new File(str);
		
		/* �ӽ� ������ ����� ���� ������ ������ ���� */
		FileUtils.copyDirectory(destination_local, destination);	//commons-io ���� 2.0�� ����
		
	}

}
