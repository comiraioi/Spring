package example2;

public class Order {
	
	public void order() {
		String msg="��ǰ �ֹ�";
		
		//System.out.println(msg+"�� ���� �α���");	=> �������
		Login.login(msg);
				
		System.out.println(msg+"�ϱ�");	//�ٽɱ��
				
		//System.out.println(msg+"�� DB�� ����");
		//System.out.println(msg+"�� ���� �α׾ƿ�");
		Logout.logout(msg);
	}
	
}