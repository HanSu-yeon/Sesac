package ex01.service;

import ex01.dao.MemberDao;
import ex01.exception.MemberNotFoundException;
import ex01.exception.WrongIdPasswordException;
import ex01.vo.Member;

//데이터를 접근해야 하기 때문에 MemberDao필요함
public class ChangePasswordService {

	// DI방법
	private MemberDao memberDao;

	public ChangePasswordService() {
	}

//	1. 생성자를 통해서 의존객체를 주입	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 2. setter메소드를 통해서 의존객체를 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 패스워드 변경
	public void changePassword(String email, String oldPw, String newPw)
			throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPw, newPw);
		memberDao.update(member); // 패스워드가 변경된 member가 전달된다
	}

}
