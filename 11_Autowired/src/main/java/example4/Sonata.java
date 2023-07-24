package example4;

import org.springframework.stereotype.Component;

@Component("sonata")
public class Sonata implements Car{
	
	public Sonata() {
		System.out.println("������: Sonata()");
	}

	@Override
	public String drive() {
		return "Sonata-drive";
	}

}
