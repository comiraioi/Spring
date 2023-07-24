package example2;

import org.springframework.stereotype.Component;

//참조변수(클래스명과 동일해도 무관) PointX로 객체 생성
@Component("PointX")	//PointX PointX = new PointX(); 
public class PointX implements Shape{
	
	public PointX() {
		System.out.println("생성자: PointX()");
	}

	@Override
	public String make() {
		return "X를 만들다";
	}

	@Override
	public String delete() {
		return "X를 지우다";
	}
	
}
