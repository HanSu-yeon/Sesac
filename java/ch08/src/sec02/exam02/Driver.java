package sec02.exam02;

//매개변수의 인터페이스화
public class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run(); // 구현 객체의 run()메소드가 실행됨
	}
}
