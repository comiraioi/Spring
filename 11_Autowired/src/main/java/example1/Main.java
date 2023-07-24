package example1;

public class Main {

	public static void main(String[] args) {
		
		Shape px = new PointX();	//부모타입으로 관리
		PointY py = new PointY();	//자식타입으로 관리
		System.out.println("----------------------");
		
		CircleImpl circle = new CircleImpl();
		circle.setPoint(px);	//setter로 자식 객체(px 또는 py) 주입
		
		System.out.println(circle.make());	//자식 객체의 make() 메서드
		System.out.println("----------------------");
		
		RectangleImpl rect = new RectangleImpl();
		rect.setPoint(py);
		
		System.out.println(rect.make());
		
	}

}
