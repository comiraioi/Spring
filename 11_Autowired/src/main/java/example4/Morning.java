package example4;

import org.springframework.stereotype.Component;

@Component("morning")
public class Morning implements Car{
	
	public Morning() {
		System.out.println("»ý¼ºÀÚ: Morning()");
	}
	
	@Override
	public String drive() {
		return "Morning-drive";
	}

}
