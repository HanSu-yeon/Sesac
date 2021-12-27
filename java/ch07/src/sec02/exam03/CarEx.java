package sec02.exam03;

public class CarEx {

	public static void main(String[] args) {
		Car car = new Car(); //객체생성
		
		//car객체의 run() 메소드 5번 반복 실행
		for(int i=1; i<=5; i++) {
			//run()메소드의 리턴값은 펑크 난 타이어의 번호
			int problemTireLocation = car.run();
			
			switch(problemTireLocation) {
				case 1:
					System.out.println("앞왼쪽 HankookTire로 교체");
					//car객체의 Tire필드에 HankookTire와 KumhoTire 객체를 대입
					//=>즉, 자동 타입 변환이 되고 있다
					/*교체된 이후부터는 car객체의 run()메소드가 호출될 때 
					HankookTire와 KumhoTire에서 재정의된 roll()메소드가 실행된다*/
					car.frontLeftTire = new HankookTire("앞왼쪽",15);
					break;
				case 2:
					System.out.println("앞오른쪽 KumhoTire로 교체");
					car.frontRightTire = new KumhoTire("앞오른쪽",13);
					break;
				case 3:
					System.out.println("뒤왼쪽 HankookTire로 교체");
					car.backLeftTire = new HankookTire("뒤왼쪽",14);
					break;
				case 4:
					System.out.println("뒤오른쪽 KumhoTire로 교체");
					car.backRightTire= new KumhoTire("뒤오른쪽",17);
					break;
			}
			//1회전 시 출력되는 내용을 구분
			System.out.println("---------------------------");
		}
	}

}
