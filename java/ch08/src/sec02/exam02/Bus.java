package sec02.exam02;

//구현 클래스
public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스가 달린다");
	}

	public void checkFare() {
		System.out.println("승차요금을 체크한다");
	}
}
