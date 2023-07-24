package product.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private final String must_input = " 필수 입력사항 입니다.";
	
	private int num;
	
	@NotBlank(message="상품명은"+must_input)
	@Length(min = 3, max = 10, message = "3~10자리로 입력하세요")
	private String name;
	
	private String company;
	
	@NotEmpty(message="파일 업로드는 필수 입니다.")
	private String image;	//파일명을 갖는 객체
	
	/* 테이블에 없는 임시 변수 */
	private MultipartFile upload;	//진짜 파일 경로를 갖는 객체
	
	/* 기존 이미지명 */
	private String upload2;
	
	private int stock;
	
	@Min(value=3000, message="최소 3000원 이상으로 입력하세요")
	private int price;
	
	private String category;
	
	@NotBlank(message="설명은"+must_input)
	@Size(min = 3, max = 10, message = "3~10자리로 입력하세요")
	private String contents;
	
	private int point;
	
	private String inputdate;
	
	
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	/* 임시변수 upload의 getter, setter 메서드 */
	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		System.out.println("=== setUpload() ===");
		this.upload = upload;	//file 객체
		
		String uploadImg = upload.getOriginalFilename();
		System.out.println("uploadImg: "+uploadImg);
		
		this.image = uploadImg;	//이미지에 파일명 넣기
	}
	
	/* 기존 이미지명 */
	public String getUpload2() {
		return upload2;
	}
	
	public void setUpload2(String upload2) {
		System.out.println("=== setUpload2() ===");
		this.upload2 = upload2;
		
		System.out.println("upload2: "+upload2);
	}
	//////////////////////////////////////////////

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getMust_input() {
		return must_input;
	}

	
}
