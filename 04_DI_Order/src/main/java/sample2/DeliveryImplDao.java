package sample2;

public class DeliveryImplDao implements DeliveryDao{
	
	public DeliveryImplDao() {
		System.out.println("������: DeliveryDao()");
	}
	
	public void insertAddress() {
		System.out.println("����� �߰�: insertAddress()");
	}
	
	public void removeAddress() {
		System.out.println("����� ����: removeAddress()");
	}
	
}
