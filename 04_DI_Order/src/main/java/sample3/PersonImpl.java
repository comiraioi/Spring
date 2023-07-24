package sample3;

public class PersonImpl implements Person {

	private String name;
	private int age;
	private double height;
	
	public PersonImpl() {
		super();
	}

	public PersonImpl(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
