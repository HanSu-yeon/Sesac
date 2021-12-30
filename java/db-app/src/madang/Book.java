package madang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {
	Connection con;

	public Book(Connection con) {
		this.con = con;
	}

	// book 테이블 전체 조회
	public void select() {
		// 쿼리를 정의
		String sql = "SELECT bookid, bookname, publisher, price FROM book";
		try {
			// Statement객체를 생성
			Statement stmt = con.createStatement();
			// 쿼리 실행 및 실행 결과를 반환
			ResultSet rs = stmt.executeQuery(sql);
			// 실행 결과를 출력
			// rs.next() : ResultSet에 저장된 select문 실행결과를 1행씩 넘겨서 다음 행이 있으면 true,없으면 false를
			// 반환하는 함수
			while (rs.next()) {
				System.out.print(rs.getInt("bookid") + "\t");
				System.out.print(rs.getString("bookname") + "\t");
				System.out.print(rs.getString("publisher") + "\t");
				System.out.println(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("쿼리 실행 오류");
			e.printStackTrace();
		}
	}

	// 책 이름의 일부를 입력받아서 book 테이블 조회하는 기능
	// 메소드 오버로딩
	public void select(String keyword) {
// 주석부분은 안전하지 않은 코드		
//		String sql = "SELECT bookid, bookname, publisher, price FROM book WHERE bookname like '%" + keyword + "%'";
//		try {
//
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);

		// 안전한 코드
		// #1. 쿼리의 구조를 정의 = 변수 부분을 물음표로 마킹 (데이터 타입을 고려하지 않음)
		String sql = "SELECT bookid, bookname, publisher, price FROM book WHERE bookname like ?";
		try {
			// #2. PreparedStatement 객체를 생성
			// -connection.prepareStatement메소드를 이용
			// -쿼리문의 구조를 파라미터로 전달
			PreparedStatement stmt = con.prepareStatement(sql);
			// #3. 변수에 값을 할당하고 쿼리를 실행
			// PreparedStatement 객체에서 제공하는 set 메소드를 이용
			// set메소드는 데이터 타입별로 있기 때문에 데이터 타입을 고려해서 사용
			// 쿼리 실행시 별도의 sql문을 매개값으로 전달하지 않아도 된다 why? preparedStatement만들때 이미 쿼리의 구조를 알고 있기
			// 때문에
			stmt.setString(1, '%' + keyword + '%');
			ResultSet rs = stmt.executeQuery(); // sql문 전달할 필요x
			while (rs.next()) {
				System.out.print(rs.getInt("bookid") + "\t");
				System.out.print(rs.getString("bookname") + "\t");
				System.out.print(rs.getString("publisher") + "\t");
				System.out.println(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("쿼리 실행 오류");
			e.printStackTrace();
		}
	}
}
