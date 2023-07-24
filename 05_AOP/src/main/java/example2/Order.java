package example2;

public class Order {
	
	public void order() {
		String msg="상품 주문";
		
		//System.out.println(msg+"을 위한 로그인");	=> 공통사항
		Login.login(msg);
				
		System.out.println(msg+"하기");	//핵심기능
				
		//System.out.println(msg+"을 DB에 저장");
		//System.out.println(msg+"을 위한 로그아웃");
		Logout.logout(msg);
	}
	
}
