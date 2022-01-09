package ex01.service;

import ex01.dao.MemberDao;
import ex01.exception.DuplicateMemberException;
import ex01.vo.Member;
import ex01.vo.RegistRequest;

//회원 등록 서비스
//=> db연동이 필요함 : MemberDao
public class MemberRegisterService {
	// 의존 객체 직접 생성
	// private MemberDao memberDao = new MemberDao();

	// 의존주입
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 회원 가입 서비스
	// 사용자가 입력한 데이터를 매개값을 넣는다
	public Long regist(RegistRequest req) throws DuplicateMemberException {
		// 이메일 중복 체크
		Member member = memberDao.selectByEmail(req.getEmail());
		// member로 받았을때
		if (member != null) {
			// 동일한 이메일 주소를 사용하는 사용자가 존재 => 이메일 주소 리턴
			throw new DuplicateMemberException("이메일 중복" + req.getEmail());
		}
		// 동일한 이메일 주소가 없는 경우, 사용자 정보를 등록
		// 등록하기위해선 Member를 만든다
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName());
		memberDao.insert(newMember); // db에 넘긴다
		return newMember.getId(); // getId를 return하므로 리턴타입을 Long으로 바꾼다
	}
}
