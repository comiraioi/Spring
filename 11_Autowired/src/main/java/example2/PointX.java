package example2;

import org.springframework.stereotype.Component;

//��������(Ŭ������� �����ص� ����) PointX�� ��ü ����
@Component("PointX")	//PointX PointX = new PointX(); 
public class PointX implements Shape{
	
	public PointX() {
		System.out.println("������: PointX()");
	}

	@Override
	public String make() {
		return "X�� �����";
	}

	@Override
	public String delete() {
		return "X�� �����";
	}
	
}
