package sample1;

public class Circle {
	private Point point;	//Point Ŭ����(�߽� ��ǥ) ����
	private double radius;	//������
	
	public Circle(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("���� �߽�: "+ point.getXpos() +","+ point.getYpos());
		System.out.println("���� ����: "+ getArea());
	}
	
	public double getArea() {
		double area = Math.pow(radius, 2) * Math.PI;	//���ǳ��� = ������*������*3.14
		return area;
	}
}
