package example1;

public class CircleImpl implements Circle{

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
