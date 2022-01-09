package ex01.vo;

//사용자가 회원가입 시 입력한 정보를 담아서 전달하는 객체 

public class RegistRequest {
	private String email;
	private String password;
	private String name;
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// getter,setter 생성
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

	// password와 confirmPassword가 일치하는지
	public boolean isPasswordEqualsToConfirmPassword() {
		return this.password.equals(this.confirmPassword);
	}
}
