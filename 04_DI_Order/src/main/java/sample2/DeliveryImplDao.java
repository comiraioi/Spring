package sample2;

public class DeliveryImplDao implements DeliveryDao{
	
	public DeliveryImplDao() {
		System.out.println("생성자: DeliveryDao()");
	}
	
	public void insertAddress() {
		System.out.println("배송지 추가: insertAddress()");
	}
	
	public void removeAddress() {
		System.out.println("배송지 삭제: removeAddress()");
	}
	
}
