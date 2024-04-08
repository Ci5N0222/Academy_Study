package classes;

// abstract class: 추상 클래스
abstract public class Member {

	
	private String id;
	private String name;
	private int point;
	
	/** Get bonus **/
	abstract public double getBonus();
	
	/** Getter & Setter **/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	/** Constructor **/
	public Member(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	public Member() {
		
	}
	
}
