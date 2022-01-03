package ex01;

import java.time.LocalDateTime;

//RegistRequest와의 차이점: 
//1.Member는 입력받은 값을 어플리케이션 내부에서 사용하는 데이터
//2.데이터가 언제 저장됐는지 date도 알 수 있음
//그리고 Member의 password는 사용자가 입력한 패스워드값이 아니라 암호화된 형태의 데이터가 저장된다
//사용자가 입력한 것과 사용자에게 보여주는것을 분리하는게 일반적이다
//회원 정보를 담을 객체
public class Member {
	// 필드정의
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registDate;

	public Member(String email, String password, String name) {
		// 들어온 매개값들로 필드를 초기화 해줌
		this.email = email;
		this.password = password;
		this.name = name;
		// registDate는 별도로 받는게 아니라 여기서 집어넣어준다
		this.registDate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// 데이터 주고 받을때 필드는 private선언하고 그것의 값을 넣고 빼고하는 getter,setter 만들어준다
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegistDate() {
		return registDate;
	}

	public void setRegistDate(LocalDateTime registDate) {
		this.registDate = registDate;
	}

	// 패스워드 변경 처리 메소드
	public void changePassword(String oldPassword, String newPassword) throws WrongIdPasswordException {
		// 패스워드 변경을 요청하는 사용자를 확인
		// 문자열이기때문에 .equals로 비교
		if (!this.password.equals(oldPassword)) { // 같지않다면
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}

}
