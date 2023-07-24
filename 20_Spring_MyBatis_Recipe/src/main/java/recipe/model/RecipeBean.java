package recipe.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class RecipeBean {
	private final String must_input = " 필수 입력사항 입니다.";
	private final String must_check = " 선택하세요.";
	
	private int num;
	
	@NotBlank(message="이름은"+must_input)
	private String dish;
	
	@NotBlank(message="대륙을"+must_check)
	private String continent;
	
	@NotBlank(message="나라를"+must_check)
	private String nation;
	
	@NotBlank(message="재료를 1개 이상"+must_check)
	private String ingredient;
	
	@NotBlank(message="양념을"+must_check)
	private String seasoning;
	
	@NotBlank(message="칼로리는 "+must_input)
	@Range(min=100, max=700, message="100 이상, 700 이하로 작성해야 합니다.")
	private String calorie;
	
	public RecipeBean() {
		super();
	}

	public RecipeBean(int num, String dish, String continent, String nation, String ingredient, String seasoning,
			String calorie) {
		super();
		this.num = num;
		this.dish = dish;
		this.continent = continent;
		this.nation = nation;
		this.ingredient = ingredient;
		this.seasoning = seasoning;
		this.calorie = calorie;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getSeasoning() {
		return seasoning;
	}

	public void setSeasoning(String seasoning) {
		this.seasoning = seasoning;
	}

	public String getCalorie() {
		return calorie;
	}

	public void setCalorie(String calorie) {
		this.calorie = calorie;
	}

	
}
