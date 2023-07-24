package sample3;

public class MyInfo {
	private Person per;
	private Student stu;
	
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public void personPrint() {
		System.out.println("name:" + per.getName());
		System.out.println("age:" + per.getAge());
		System.out.println("height:" + per.getHeight());
	}
	
	public void studentPrint() {
		System.out.println("kor:" + stu.getKor());
		System.out.println("eng:" + stu.getEng());
		System.out.println("per:" + stu.getPer());
	}
}
