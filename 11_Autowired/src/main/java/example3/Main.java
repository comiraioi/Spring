package example3;

public class Main {

	public static void main(String[] args) {
		Car morning = new Morning();
		Car sonata = new Sonata();
		System.out.println("----------------------");
		
		Person con = new Consumer();
		con.setName("À¢µð");
		con.setAge(30);
		con.setCar(morning);
		
		System.out.println(con.getName()+","+con.getAge()+","+con.personDrive());
		System.out.println("----------------------");
		
		Person con2 = new Consumer();
		con2.setName("Á¤±¹");
		con2.setAge(40);
		con2.setCar(sonata);
		
		System.out.println(con2.getName()+","+con2.getAge()+","+con2.personDrive());

	}

}
