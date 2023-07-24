package sample2;

public class ServiceImplDao implements ServiceDao{
	
	private OrderImplDao odao;
	private DeliveryImplDao ddao;
	
	public ServiceImplDao() {
		System.out.println("»ý¼ºÀÚ: Service()");
	}

	public OrderImplDao getOdao() {
		return odao;
	}

	public void setOdao(OrderImplDao odao) {
		this.odao = odao;
	}

	public DeliveryImplDao getDdao() {
		return ddao;
	}

	public void setDdao(DeliveryImplDao ddao) {
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
