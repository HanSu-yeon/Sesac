package ex01.example;

import ex01.dao.MemberDao;
import ex01.service.ChangePasswordService;
import ex01.service.MemberRegisterService;

public class Assembler {
	// 우리 어플리케이션에서 필요로 하는 객체들을 갖고 있음
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;

	// 이 Assembler클래스가 생성되면
	public Assembler() {
		// 이 어플리케이션에서 필요로 하는 클래스들을 다 만들어준다
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);
		changePasswordService = new ChangePasswordService(memberDao);
	}

	// 생성되어 있는 것을 쓰고 싶은 쪽으로 전달하는 메소드
	public MemberRegisterService getMemberRegisterService() {
		// 반환값: MemberRegisterService의 인스턴스
		return this.memberRegisterService;
	}

	public ChangePasswordService getChangePasswordService() {
		return this.changePasswordService;
	}
}
