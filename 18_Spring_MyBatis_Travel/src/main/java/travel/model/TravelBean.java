package travel.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private final String must_input = "�ʼ� �Է»��� �Դϴ�.";
	private final String must_select = "�����ϼ���.";
	
	private int num;
	
	@NotBlank(message="�̸��� "+must_input)
	@Size(max = 10, message="10���� �̳��� �Է��ϼ���")
	private String name;
	
	@NotBlank(message="���̴� "+must_input)
	@Range(min=10, max=100, message="10�� �̻�, 100�� ���Ϸ� �ۼ��ؾ� �մϴ�.")
	private String age;
	
	@NotBlank(message="���� ������ 1�� �̻� "+must_select)
	private String area;	//checkbox (�ڵ����� �迭 , ���� ó����)
	
	@NotBlank(message="���� ��Ÿ���� "+must_select)
	private String style;	//radio
	
	@NotBlank(message="���ݴ븦 "+must_select)
	private String price;	//select
	
	public TravelBean() {
		super();
	}

	public TravelBean(int num, String name, String age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
