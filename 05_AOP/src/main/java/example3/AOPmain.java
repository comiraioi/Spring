package example3;

//pom.xml���� <dependecy> ����
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPmain {

	public static void main(String[] args) {
		
		/* �ٽ� ����� ȣ���ϸ� �ڵ����� ���� ��� ȣ��� */
		AbstractApplicationContext context = new GenericXmlApplicationContext("aopExam.xml");
		Board myboard = (Board)context.getBean("myboard");
		myboard.board();
		System.out.println("-------------");
		Order myorder = (Order)context.getBean("myorder");
		myorder.order();

	}

}
