package sample2;

public class CircleImpl implements Circle{
	private PointImpl point;	//Point 클래스(중심 좌표) 포함
	private double radius;	//반지름
	
	/* 생성자 통한 주입 */
	public CircleImpl(PointImpl point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	/* 미완성 메서드 오버라이딩 */
	public void display() {
		System.out.println("원의 중심: "+ point.getXpos() +","+ point.getYpos());
		System.out.println("원의 면적: "+ getArea());
	}
	
	public double getArea() {
		double area = Math.pow(radius, 2) * Math.PI;	//원의넓이 = 반지름*반지름*3.14
		return area;
	}
}
