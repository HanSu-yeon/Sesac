package ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정 정보를 가지고 있다는 것을 알려줄때쓰는것
@Configuration // <=이 어노테이션을 적어주면 객체를 어떻게 만들고 객체간의 관계가 어떻게 설정되는지를 알려준다(담고있다)
public class AppCtx {

	// MemberDao를 반환하는 memberDao라는 메소드
	// 요놈은 스프링이 관리해야되는 대상이기때문에 bean 어노테이션 붙여줌
	@Bean // 해당 메소드가 생성한 객체를 스프링 빈으로 설정(메소들 이름을 bean 객체의 이름으로 사용)
	public MemberDao memberDao() {
		return new MemberDao(); // 생성된 놈 반환
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		// 생성자를 이용해서 의존객체를 주입
		// MemberRegisterServic가 동작하기 위해서는 memberDao()가 필요하다 그래서 생성자를 통해 매개값을 전달하고있는거다
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		// setter 메서드를 이용해서 의존객체를 주입
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}

	@Bean
	public MemberPrint memberPrint() {
		return new MemberPrint();
	}

	@Bean
	public MemberListPrint memberListPrint() { // 생성자 통해 의존객체 주입
		return new MemberListPrint(memberDao(), memberPrint());
	}

	@Bean
	public MemberInfoPrint memberInfoPrint() { // setter를 통해 의존객체 주입
		// memberInfoPrint는 생성자를 통해서 만들어준다
		MemberInfoPrint mip = new MemberInfoPrint();
		mip.setMemberDao(memberDao()); // memberDao()를 호출해서 설정하도록해라
		mip.setMemberPrint(memberPrint());
		return mip;

	}
}
