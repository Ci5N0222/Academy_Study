package classes;

public class Gold extends Member {
	
	public Gold(String id, String name, int point) {
		
		// 1. setter 사용
//		this.setId(id);
//		this.setName(name);
//		this.setPoint(point);
		
		// 2. 접근제한자 변경: Super Class 에서 private --> public || proteced  사용
		// public String id;
		// proteced String name;
		// ** 정보은닉 권고안을 위반
		
		// 3. Constructor 사용
		super(id, name, point);
	
	}

	@Override
	public double getBonus() {
		return this.getBonus() * 0.03;
	}
	
		
}
