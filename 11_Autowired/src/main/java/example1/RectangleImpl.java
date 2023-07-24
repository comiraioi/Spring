package example1;

public class RectangleImpl implements Rectangle{

	Shape point;	//Shape�� �ڽ� Ŭ����(PointX, PointY)�� �����ϴ� ����
	int x;
	int y;
	
	public RectangleImpl() {
		super();
		System.out.println("������: RectangleImpl()");
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
		return point.make();
	}

}
