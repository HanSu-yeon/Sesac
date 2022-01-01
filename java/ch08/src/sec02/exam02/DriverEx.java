package sec02.exam02;

//Driver클래스 이용해서 실행하는 DriverEx클래스
public class DriverEx {

	public static void main(String[] args) {
		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.drive(bus); // 자동 타입 변환: Vehicle vehicle =bus;
		driver.drive(taxi);// Vehicle vehicle =taxi;

		// 인터페이스로 구현 객체 사용하기
		// 인터페이스 타입으로 변수 선언하고 구현 객체를 대입
		Vehicle vehicle = new Bus();
		// vehicle.checkFare(); =>Vehicle 인터페이스에는 checkFare()가 없다

		// 강제 타입 변환
		Bus bus2 = (Bus) vehicle;
		bus2.run();
		bus2.checkFare(); // Bus클래스에는 checkFare()가 있음

	}

}
