package sample2;

public class OrderImplDao implements OrderDao{
	
	public OrderImplDao() {
		System.out.println("������: OrderDao()");
	}
	
	public void insertOrder() {
		System.out.println("�ֹ����� �߰�: insertOrder()");
	}
	
	public void removeOrder() {
		System.out.println("�ֹ����� ���: removeOrder()");
	}
	
}
