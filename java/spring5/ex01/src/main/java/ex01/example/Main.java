package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// static MemberDao dao = new MemberDao();
	static Assembler asm = new Assembler();

	public static void main(String[] args) throws IOException {
		/*
		 * new ⇒ 새로운 회원 정보를 추가 change ⇒ 회원의 패스워드를 변경 exit ⇒ 프로그램 종료
		 */
		// 콘솔에서 사용자가 입력하는 값을 읽어들이는 객체

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요. (new:등록 | change:비번 변경 |list:목록출력 |version:버전 exit:종료");
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
			}
		}

	}

	private static void doChangePassword(String[] args) {
		// change email oldpassword newpassword
		if (args.length != 4) {
			System.out.println("change email oldpassword newpassword 이렇게 작성해쥬");
			return;
		}

		// new로 생성하지x고 Assembler에서 가져올거다
		// ChangePasswordService cps = new ChangePasswordService(dao);
		ChangePasswordService cps = asm.getChangePasswordService();
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
		// 5개가 맞다면
		// new로 생성하지x고 Assembler에서 가져올거다
		// MemberRegisterService mrs = new MemberRegisterService(dao);
		MemberRegisterService mrs = asm.getMemberRegisterService();
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