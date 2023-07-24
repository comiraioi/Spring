package sample1;

public class Main {

	public static void main(String[] args) {
		CalcBeanImpl cb = new CalcBeanImpl(4);	//생성자로 su2에 값 주입
		cb.setSu1(13);	//setter로 su1에 값 주입
		
		cb.calculate();	//메서드 호출
	}

}
