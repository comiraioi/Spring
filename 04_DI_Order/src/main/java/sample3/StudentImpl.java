package sample3;

public class StudentImpl implements Student{
	private int kor;
	private int eng;
	private Person per;
	
	@Override
	public int getKor() {
		return kor;
	}

	@Override
	public void setKor(int kor) {
		this.kor = kor;
	}

	@Override
	public int getEng() {
		return eng;
	}

	@Override
	public void setEng(int eng) {
		this.eng = eng;	
	}

	@Override
	public Person getPer() {
		return per;
	}

	@Override
	public void setPer(Person per) {
		this.per = per;
	}

}
