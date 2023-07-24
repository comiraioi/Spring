package product.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private final String must_input = " �ʼ� �Է»��� �Դϴ�.";
	
	private int num;
	
	@NotBlank(message="��ǰ����"+must_input)
	@Length(min = 3, max = 10, message = "3~10�ڸ��� �Է��ϼ���")
	private String name;
	
	private String company;
	
	@NotEmpty(message="���� ���ε�� �ʼ� �Դϴ�.")
	private String image;	//���ϸ��� ���� ��ü
	
	/* ���̺� ���� �ӽ� ���� */
	private MultipartFile upload;	//��¥ ���� ��θ� ���� ��ü
	
	/* ���� �̹����� */
	private String upload2;
	
	private int stock;
	
	@Min(value=3000, message="�ּ� 3000�� �̻����� �Է��ϼ���")
	private int price;
	
	private String category;
	
	@NotBlank(message="������"+must_input)
	@Size(min = 3, max = 10, message = "3~10�ڸ��� �Է��ϼ���")
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
	
	/* �ӽú��� upload�� getter, setter �޼��� */
	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		System.out.println("=== setUpload() ===");
		this.upload = upload;	//file ��ü
		
		String uploadImg = upload.getOriginalFilename();
		System.out.println("uploadImg: "+uploadImg);
		
		this.image = uploadImg;	//�̹����� ���ϸ� �ֱ�
	}
	
	/* ���� �̹����� */
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
