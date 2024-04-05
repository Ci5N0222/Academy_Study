package classes;

public class Student {

	private int id;
	private String name;
	private int korean;
	private int english;
	private int math;
	
	// 국어, 영어, 수학의 총점을 구하는 메서드
	public int getSum() {
		return korean + english + math;
	}
	
	// 점수의 평균을 구하는 메서드
	public float getAvg() {
		return (float)getSum()/3;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public Student(int id, String name, int korean, int english, int math) {
		super();
		this.id = id;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	public Student() {
		super();
	}

}
