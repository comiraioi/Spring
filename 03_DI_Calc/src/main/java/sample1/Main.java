package sample1;

public class Main {

	public static void main(String[] args) {
		CalcBeanImpl cb = new CalcBeanImpl(4);	//�����ڷ� su2�� �� ����
		cb.setSu1(13);	//setter�� su1�� �� ����
		
		cb.calculate();	//�޼��� ȣ��
	}

}
