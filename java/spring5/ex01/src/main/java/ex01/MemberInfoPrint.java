package ex01;

public class MemberInfoPrint {
	private MemberDao memberDao;
	private MemberPrint print;

	// 생성자 따로 x

	// setter
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setMemberPrint(MemberPrint print) {
		this.print = print;
	}

	// 고유한 값인 email을 파라미터로 받아와 memberDao로 뒤진다
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 데이터 없음");
			return;
		}
		// 반환값이 있으면 출력
		print.print(member);
	}
}
