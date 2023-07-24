package sample1;

public class Circle {
	private Point point;	//Point 클래스(중심 좌표) 포함
	private double radius;	//반지름
	
	public Circle(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("원의 중심: "+ point.getXpos() +","+ point.getYpos());
		System.out.println("원의 면적: "+ getArea());
	}
	
	public double getArea() {
		double area = Math.pow(radius, 2) * Math.PI;	//원의넓이 = 반지름*반지름*3.14
		return area;
	}
}
