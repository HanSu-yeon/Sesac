package sec02.exam02;

//매개변수의 인터페이스화
public class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run(); // 구현 객체의 run()메소드가 실행됨

		// vehicle 매개 변수가 참조하는 객체가 Bus인지 조사
		if (vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle; // Bus객체일 경우 안전하게 강제 타입 변환
			bus.checkFare(); // Bus 타입으로 강제 타입 변환을 하는 이유 (인터페이스에 이 메소드 없기 때문)
		}
	}
}
