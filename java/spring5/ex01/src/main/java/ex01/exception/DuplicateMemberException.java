package ex01.exception;

public class DuplicateMemberException extends Exception {
	// 생성자 생성
	public DuplicateMemberException() {
		super();
	}

	public DuplicateMemberException(String message) {
		super(message);
	}

}
