package sample3;

public class PointImpl implements Point{	//Point 인터페이스 상속
	/* 원의 중심 좌표 */
	private double xpos;
	private double ypos;
	
	/* 미완성 메서드 오버라이딩 */
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
}
