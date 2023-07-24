package sample2;

public class CircleImpl implements Circle{
	private PointImpl point;	//Point Ŭ����(�߽� ��ǥ) ����
	private double radius;	//������
	
	/* ������ ���� ���� */
	public CircleImpl(PointImpl point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	/* �̿ϼ� �޼��� �������̵� */
	public void display() {
		System.out.println("���� �߽�: "+ point.getXpos() +","+ point.getYpos());
		System.out.println("���� ����: "+ getArea());
	}
	
	public double getArea() {
		double area = Math.pow(radius, 2) * Math.PI;	//���ǳ��� = ������*������*3.14
		return area;
	}
}
