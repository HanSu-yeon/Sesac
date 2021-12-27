package sec02.exam03;

public class HankookTire extends Tire {
	//필드
		//생성자
		public HankookTire(String location, int maxRotation) {
			super(location, maxRotation);
		}

		@Override
		public boolean roll() {
			++accumulatedRotation;
			if(accumulatedRotation< maxRotation) {
				System.out.println(location+"HankookTire수명: "+(maxRotation-accumulatedRotation)+"회");
				return true;
			}else {
				System.out.println(location+"한국타이어 펑크");
				return false;
			}
		}
}
