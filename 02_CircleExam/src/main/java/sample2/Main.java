package sample2;

public class Main {

	public static void main(String[] args) {
		PointImpl point = new PointImpl();
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		CircleImpl circle = new CircleImpl(point,10.0);
		circle.display();
	}

}
