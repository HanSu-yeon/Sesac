package sec02.exam01;

public class CarEx {

	public static void main(String[] args) {
		Car myCar = new Car();

		myCar.run();
		// 필드값 교체
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();

		myCar.run();
	}

}
