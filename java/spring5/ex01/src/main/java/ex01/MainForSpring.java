package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForSpring {
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		// main함수가 호출될때 ctx를 정의해야함
		ctx = new AnnotationConfigApplicationContext(AppCtx.class); // annotation어쩌구 기반으로 ~~
		// 위에서 매개값으로 들어가는 Appcts는 객체를 어떻게 만들건지 정의해 놓은거고 여기에 어노테이션을 달아놓은거 =>이걸 해석해서 객체를
		// 만들어주는거다
		// ctx에는 생성된 객체 목록들이 저장되어있다
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요. (new:등록 | change:비번 변경 |list:목록출력 |info:회원정보 |version:버전 exit:종료");
			String command = reader.readLine();
			// 대소문자 구분하지 않고 command가 "exit"면 프로그램 종료
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			// 입력 형태=>new email name password confirmpassword
			if (command.startsWith("new ")) {
				doRegist(command.split(" ")); // 공백을 기준으로 분할하고 String(문자열) 배열 타입으로 리턴해준다
			} else if (command.startsWith("change")) {
				// change email oldpassword newpassword
				doChangePassword(command.split(" "));
			} else if (command.equalsIgnoreCase("list")) {
				doPrintList();
			} else if (command.startsWith("info")) {
				// info email
				doPrintInfo(command.split(" "));
			}
		}

	}

	private static void doPrintInfo(String[] args) {
		// info email
		if (args.length != 2) {
			System.out.println("info email 이렇게 작성해쥬");
			return;
		}
		MemberInfoPrint mip = ctx.getBean("memberInfoPrint", MemberInfoPrint.class);
		mip.printMemberInfo(args[1]);
	}

	private static void doPrintList() {
		// 우리가 필요한 걸 가져온다
		MemberListPrint mlp = ctx.getBean("memberListPrint", MemberListPrint.class);
		mlp.printAll();
	}

	private static void doChangePassword(String[] args) {
		// change email oldpassword newpassword
		if (args.length != 4) {
			System.out.println("change email oldpassword newpassword 이렇게 작성해쥬");
			return;
		}

		// ctx사용법: ctx.getBean(빈이름(=메소드이름), 데이터타입)
		// ctx에 들어가는 객체는 어떤 형태가 될지 모르기때문에 object형태로 들어감=>즉 promotion되는거임(부모꺼밖에 못쓴다)
		// 자식껄 쓰고싶으니 getBean할때 데이터타입을(이러한 형태다) 적어줘 casting해서 return해주게한다?? 정확하지는 않음
		ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.changePassword(args[1], args[2], args[3]);
			System.out.println("정상적으로 패스워드를 변경했습니다");
		} catch (MemberNotFoundException e) {
			System.out.println("일치하는 회원 정보가 존재하지 않습니다");
		} catch (WrongIdPasswordException e) {

			System.out.println("이메일과 패스워드가 일치하지 않습니다");
		}
	}

	// main함수가 static이니까 이것도 static으로 만들어짐
	// 별도로 반환받는 값이x=> void
	// 넘어오는 인자값이 split한 결과이기 때문에 String[] 타입이다
	private static void doRegist(String[] args) {
		// new email name password confirmpassword
		if (args.length != 5) {
			System.out.println("new email name password confirmpassword 이렇게 입력해주세요");
			return; // 호출한쪽으로 돌아가기
		}

		MemberRegisterService mrs = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegistRequest request = new RegistRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		try {
			mrs.regist(request);
			System.out.println("정상적으로 등록되었습니다");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 등록된 사용자입니다");
		}

	}
}
