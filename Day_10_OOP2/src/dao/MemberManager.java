package dao;

import classes.Silver;

public class MemberManager {
	
	Silver[] silver = new Silver[10];
	int index = 0;
	
	// index를 넘겨주는 메서드
	public int getIndex() {
		return index;
	}
	
	// Member를 추가하는 메서드
	public int addMember(String id, String name, int point) {
		if(index == 10) {
			return 0;
		} else {
			// 회원 추가 로직
			Silver sv = new Silver(id, name, point);
			silver[index++] = sv;
			return 1;
		}
	}
	
	// Member를 반환하는 메서드
	public Silver[] getMembers() {
		// index 길이 만큼만 리턴 --> 나중에 작업
		// Silver[] sv = new Silver[index];
		if(index == 0) {
			return null;
		} else {
			// 회원 정보 출력 로직
			return silver;
		}
	}
	
}
