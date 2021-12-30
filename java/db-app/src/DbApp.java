import java.sql.Connection;
import java.util.Scanner;

import madang.Book;
import madang.ConnManager;

//실행 클래스
public class DbApp {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Connection c = ConnManager.getConnection();

		Book book = new Book(c);

		book.select();
		System.out.print("책 검색> ");
		String keyword = scanner.nextLine();
		book.select(keyword);
		try {
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
