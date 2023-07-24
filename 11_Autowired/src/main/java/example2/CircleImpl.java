package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl")	//CircleImpl myCircleImpl = new CircleImpl();
public class CircleImpl implements Circle{
	
	@Autowired	//Shape�� �ڽ��� �ڵ����� ����
	@Qualifier("PointX")	//�ڽ��� 2�� �̻��̹Ƿ� �����ϰ� ���� �ڽ��� �������� �ۼ�
	Shape point;	//Shape�� �ڽ� Ŭ����(PointX, PointY)�� �����ϴ� ����
	
	int x;
	int y;
	
	public CircleImpl() {
		super();
		System.out.println("������: CircleImpl()");
	}

	public Shape getPoint() {
		return point;
	}

	public void setPoint(Shape point) {
		System.out.println("setPoint()");
		this.point = point;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String make() {
		return point.make();	//�ڽ�((PointX, PointY)�� make �޼��� ȣ��
	}

}
