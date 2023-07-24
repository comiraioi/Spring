package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {
	private Map<Integer, Integer> orderlists = null;	//��ǰ��ȣ(num), �ֹ�����(orderqty)
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}//������

	public void addOrder(int num, int orderqty) {
		orderlists.put(num, orderqty);	//n�� ��ǰ, m��
	}

	public Map<Integer, Integer> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(Map<Integer, Integer> orderlists) {
		this.orderlists = orderlists;
	}
	
}
