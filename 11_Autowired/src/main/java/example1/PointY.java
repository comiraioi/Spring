package example1;

public class PointY implements Shape{
	
	public PointY() {
		System.out.println("생성자: PointY()");
	}

	@Override
	public String make() {
		return "Y를 만들다";
	}

	@Override
	public String delete() {
		return "Y를 지우다";
	}
	
}
