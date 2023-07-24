package sample1;

public class ServiceDao {
	
	private OrderDao odao;
	private DeliveryDao ddao;
	
	public ServiceDao() {
		System.out.println("»ý¼ºÀÚ: Service()");
	}

	public OrderDao getOdao() {
		return odao;
	}

	public void setOdao(OrderDao odao) {
		this.odao = odao;
	}

	public DeliveryDao getDdao() {
		return ddao;
	}

	public void setDdao(DeliveryDao ddao) {
		this.ddao = ddao;
	}
	
	public void order() {
		odao.insertOrder();
		ddao.insertAddress();
	}
	
	public void cancel() {
		odao.removeOrder();
		ddao.removeAddress();
	}
	
}
