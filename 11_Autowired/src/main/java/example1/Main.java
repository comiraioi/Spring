package example1;

public class Main {

	public static void main(String[] args) {
		
		Shape px = new PointX();	//�θ�Ÿ������ ����
		PointY py = new PointY();	//�ڽ�Ÿ������ ����
		System.out.println("----------------------");
		
		CircleImpl circle = new CircleImpl();
		circle.setPoint(px);	//setter�� �ڽ� ��ü(px �Ǵ� py) ����
		
		System.out.println(circle.make());	//�ڽ� ��ü�� make() �޼���
		System.out.println("----------------------");
		
		RectangleImpl rect = new RectangleImpl();
		rect.setPoint(py);
		
		System.out.println(rect.make());
		
	}

}
