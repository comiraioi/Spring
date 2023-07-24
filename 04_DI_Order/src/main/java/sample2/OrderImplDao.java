package sample2;

public class OrderImplDao implements OrderDao{
	
	public OrderImplDao() {
		System.out.println("생성자: OrderDao()");
	}
	
	public void insertOrder() {
		System.out.println("주문정보 추가: insertOrder()");
	}
	
	public void removeOrder() {
		System.out.println("주문정보 취소: removeOrder()");
	}
	
}
