package sec02.exam03;

public class KumhoTire extends Tire {
	//생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation< maxRotation) {
			System.out.println(location+"KumhoTire수명: "+(maxRotation-accumulatedRotation)+"회");
			return true;
		}else {
			System.out.println(location+"KumhoTire타이어 펑크");
			return false;
		}
	}
	
}
