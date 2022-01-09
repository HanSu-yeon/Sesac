package ex01.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ex01.vo.Member;

//DAO = Data Access Object
//일반적으로 DB연동을 구현하는 클래스 (멤버 정보 저장하는 db)
//실제 db와 연동을 안했기 때문에 여기서는 HashMap에 데이터를 저장, 수정, 조회 기능을 구현하겠다
public class MemberDao {
	// 1. 회원 정보 데이터를 저장할 필드를 정의
	// Map<key,value> ... => key는 고유값이어야한다=> email을 key로 설정
	// 내부적으로 회원ID를 부여할 필드를 정의 (DB와 연동이 X이기 때문에)
	private long nextId = 0;

	private Map<String, Member> map = new HashMap<>();

	// 파라미터로 전달된 이메일과 일치하는 회원 정보(Member)를 반환 => 리턴값 타입은 Member로 지정
	// map.get() : map에서 키값과 일치하는걸 찾을때 쓰는 메소드
	public Member selectByEmail(String email) {
		return map.get(email);
		// Member m = map.get(email);이메일을 넣어주면 반환되는 놈이 member가 된다 이 멤버를 리턴해준다
		// 일치하는게 없으면=> null 반환

	}

	// 파라미터로 전달된 회원 정보를 DB에 저장
	public void insert(Member member) {
		nextId++;
		member.setId(nextId);
		map.put(member.getEmail(), member);

	}

	// 모든 회원 정보를 조회, 반환
	public Collection<Member> selectAll() {
		return map.values();
	}

	// 회원 정보 수정
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}

}
