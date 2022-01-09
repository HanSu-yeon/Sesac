package ex01.service;

import java.util.Collection;

import ex01.dao.MemberDao;
import ex01.vo.Member;

public class MemberListPrint {
	// memberDao와 memberPrint를 같이 사용함
	// =>의존관계에 있는 필드가 2개있음 (의존관계수만큼 필드를 정의하는 듯?)
	private MemberDao memberDao;
	private MemberPrint print;

	// 생성자를 이용해서 의존객체를 주입(의존관계를 설정)
	public MemberListPrint(MemberDao memberDao, MemberPrint print) {
		this.memberDao = memberDao;
		this.print = print;
	}

	// memberDao가 갖고있는걸 호출해준다
	public void printAll() {
		// Collection객체를 반환. 컬렉션객체는 이터러블하게 처리할 수 있다 자바에서 이터러블한 처리는 forEach로 함
		Collection<Member> members = memberDao.selectAll();
		// 여기에 들어온 print가 갖고있는 print메소드호출하는데 이때 member인스턴스가 넘어감
		members.forEach(m -> print.print(m));
	}

}
