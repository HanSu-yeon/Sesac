package madang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			new ConnManager();
		}
		return con;
	}

	// DB 접속 정보
	// 외부에서 접근하면 x =>private, 값 안바뀜=>final, 한번만 만들면 o =>static
	// 드라이버:DB종류:DB서버위치:서비스포트/디폴트DB(?옵션(서버타임존))
	private static final String DB_URL = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "madang";
	private static final String DB_PASSWRD = "madang";

	// 생성자
	public ConnManager() {
		// #1.JDBC 드라이버를 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다");
			e.printStackTrace(); // 에러 발생근원지를 찾아 단계별로 에러를 출력함
		}

		// #2.DB에 연결을 생성
		try {
			// connection을 반환함
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWRD);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
	}
}
