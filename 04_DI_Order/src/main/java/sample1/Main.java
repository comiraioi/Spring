package sample1;

public class Main {

	public static void main(String[] args) {
		OrderDao odao = new OrderDao();
		DeliveryDao ddao = new DeliveryDao();
		ServiceDao sdao = new ServiceDao();
		
		sdao.setOdao(odao);
		sdao.setDdao(ddao);
		sdao.order();
		sdao.cancel();

	}

}
