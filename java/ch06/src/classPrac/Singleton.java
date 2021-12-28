package classPrac;

public class Singleton {
	// 정적필드
	private static Singleton singleton = new Singleton();

	// 생성자
	private Singleton() {
	};

	// 메소드
	static Singleton getInstance() {
		return singleton;
	}
}
