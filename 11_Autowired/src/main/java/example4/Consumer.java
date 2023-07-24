package example4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Consumer")
public class Consumer implements Person{
	
	private String name;
	private int age;
	
	@Autowired
	@Qualifier("morning")
	private Car car;	//자식클래스(Morning, Sonanta)를 관리하는 부모타입 변수

	public Consumer() {
		super();
		System.out.println("생성자: Consumer()");
	}
	
	@Override
	public Car getCar() {
		return car;
	}
	
	@Override
	public void setCar(Car car) {
		this.car = car;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String personDrive() {
		return car.drive();
	}

}
