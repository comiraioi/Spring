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
	
	@PostConstruct	//패키지 가져오기 => dependency 작성
	public void init() {
		//서블릿이 실행되면 첫번째로 실행되는 메서드
		System.out.println("===init()===");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("===afterPropertiesSet===");
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: "+uploadPath);
		File destination = new File(uploadPath);
		
		/* 임시 폴더 */
		String str = "c:/tempUpload";
		File destination_local = new File(str);
		
		/* 임시 폴더에 저장된 파일 웹서버 폴더로 복사 */
		FileUtils.copyDirectory(destination_local, destination);	//commons-io 버전 2.0만 가능
		
	}

}
