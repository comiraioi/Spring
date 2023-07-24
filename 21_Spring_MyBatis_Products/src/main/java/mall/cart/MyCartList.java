package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {
	private Map<Integer, Integer> orderlists = null;	//상품번호(num), 주문수량(orderqty)
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}//생성자

	public void addOrder(int num, int orderqty) {
		orderlists.put(num, orderqty);	//n번 상품, m개
	}

	public Map<Integer, Integer> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(Map<Integer, Integer> orderlists) {
		this.orderlists = orderlists;
	}
	
}
