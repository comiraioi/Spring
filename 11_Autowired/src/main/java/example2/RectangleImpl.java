package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle{
	
	@Autowired
	@Qualifier("PointY")
	Shape point;	//Shape의 자식 클래스(PointX, PointY)를 관리하는 변수
	
	int x;
	int y;
	
	public RectangleImpl() {
		super();
		System.out.println("생성자: RectangleImpl()");
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
