package sec02.exam02;

//Driver클래스 이용해서 실행하는 DriverEx클래스
public class DriverEx {

	public static void main(String[] args) {
		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.drive(bus); // 자동 타입 변환: Vehicle vehicle =bus;
		driver.drive(taxi);// Vehicle vehicle =taxi;
	}

}
