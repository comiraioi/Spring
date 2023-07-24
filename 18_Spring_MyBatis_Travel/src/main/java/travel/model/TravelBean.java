package travel.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private final String must_input = "필수 입력사항 입니다.";
	private final String must_select = "선택하세요.";
	
	private int num;
	
	@NotBlank(message="이름은 "+must_input)
	@Size(max = 10, message="10글자 이내로 입력하세요")
	private String name;
	
	@NotBlank(message="나이는 "+must_input)
	@Range(min=10, max=100, message="10살 이상, 100살 이하로 작성해야 합니다.")
	private String age;
	
	@NotBlank(message="관심 지역을 1개 이상 "+must_select)
	private String area;	//checkbox (자동으로 배열 , 연결 처리됨)
	
	@NotBlank(message="여행 스타일을 "+must_select)
	private String style;	//radio
	
	@NotBlank(message="가격대를 "+must_select)
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
