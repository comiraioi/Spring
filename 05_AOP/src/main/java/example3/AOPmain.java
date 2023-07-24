package example3;

//pom.xml에서 <dependecy> 설정
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPmain {

	public static void main(String[] args) {
		
		/* 핵심 기능을 호출하면 자동으로 공통 기능 호출됨 */
		AbstractApplicationContext context = new GenericXmlApplicationContext("aopExam.xml");
		Board myboard = (Board)context.getBean("myboard");
		myboard.board();
		System.out.println("-------------");
		Order myorder = (Order)context.getBean("myorder");
		myorder.order();

	}

}
