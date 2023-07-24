package movie.model;

import org.hibernate.validator.constraints.NotBlank;

public class MovieBean {
	private final String must_input = " �ʼ� �Է»��� �Դϴ�.";
	private final String must_check = " �����ϼ���.";
	
	private int num;
	
	@NotBlank(message="������"+must_input)
	private String title;
	
	@NotBlank(message="�����"+must_input)
	private String continent;
	
	@NotBlank(message="�����"+must_input)
	private String nation;
	
	@NotBlank(message="�帣�� �ּ� 1�� �̻�"+must_check)
	private String genre;
	
	@NotBlank(message="�����"+must_check)
	private String grade;
	
	private String actor;
	
	public MovieBean() {
		super();
	}

	public MovieBean(int num, String title, String continent, String nation, String genre, String grade, String actor) {
		super();
		this.num = num;
		this.title = title;
		this.continent = continent;
		this.nation = nation;
		this.genre = genre;
		this.grade = grade;
		this.actor = actor;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
