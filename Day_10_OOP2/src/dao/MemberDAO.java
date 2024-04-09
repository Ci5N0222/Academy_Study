package dao;

import java.util.ArrayList;

import classes.Member;

public class MemberDAO {
	
	private ArrayList<Member> members = new ArrayList<Member>();
	
	/**
	 * 신규 회원을 추가하는 메서드
	 * @param member
	 * @return
	 */
	public void addMember(Member member) {
		members.add(member);
	}
	
	
	/**
	 * 멤버들의 목록 출력하는 메서드
	 * @return
	 */
	public ArrayList<Member> getMembers() {
		return members;
	}
	
}
