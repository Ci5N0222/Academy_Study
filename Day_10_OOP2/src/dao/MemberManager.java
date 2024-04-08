package dao;

import classes.Gold;
import classes.Silver;

public class MemberManager {
	
	Silver[] silver = new Silver[10];
	Gold[] gold = new Gold[10];
	
	int silverIndex = 0;
	int goldIndex = 0;
	
	// Silver index를 넘겨주는 메서드
	public int getIndex() {
		return silverIndex;
	}
	
	// Gold index를 넘겨주는 메서드
	public int getGoldIndex() {
		return goldIndex;
	}
	
	// Member를 추가하는 메서드
	public int addMember(String id, String name, int point) {
		if(silverIndex == 10) {
			return 0;
		} else {
			// 회원 추가 로직
			Silver sv = new Silver(id, name, point);
			silver[silverIndex++] = sv;
			return 1;
		}
	}
	
	public int addGoldMember(String id, String name, int point) {
		if(goldIndex == 10) {
			return 0;
		} else {
			// 회원 추가 로직
			Gold gd = new Gold(id, name, point);
			gold[goldIndex++] = gd;
			return 1;
		}
	}
	
	
	// Silver Member를 반환하는 메서드
	public Silver[] getMembers() {
		if(silverIndex == 0) {
			return null;
		} else {
			// 회원 정보 출력 로직
			return silver;
		}
	}
	// Gold Member를 반환하는 메서드	
	public Gold[] getGoldMembers() {
		if(goldIndex == 0) {
			return null;
		} else {
			// 회원 정보 출력 로직
			return gold;
		}
	}
	
}
