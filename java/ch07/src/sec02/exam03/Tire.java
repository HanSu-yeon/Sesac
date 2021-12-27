package sec02.exam03;

public class Tire {
	public int maxRotation; //최대회전수
	public int accumulatedRotation; //누적회전
	public String location; //타이어 위치
	
	//생성자
	public Tire(String location, int maxRotation) {
		this.location=location;
		this.maxRotation = maxRotation;
	}
	
	//메서드
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation< maxRotation) {
			System.out.println(location+"Tire수명: "+(maxRotation-accumulatedRotation)+"회");
			return true;
		}else {
			System.out.println(location+"타이어 펑크");
			return false;
		}
	}
}
