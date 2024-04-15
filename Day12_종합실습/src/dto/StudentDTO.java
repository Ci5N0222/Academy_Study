package dto;

import java.time.LocalDate;

public class StudentDTO {

	/** StudentDTO **/
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private LocalDate write_date;
	
	/** 총점을 구하는 메서드 **/
	public int sumScore(int kor,int eng, int math) {
		return kor + eng + math;
	}
	
	/** 평균을 구하는 메서드 **/
	public double avgScore(int sum) {
		return sum / 3;
	}
	
	/** Getter & Setter **/
	
	public int getId() {
		return id;
	}
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public LocalDate getWrite_date() {
		return write_date;
	}
	public void setWrite_date(LocalDate write_date) {
		this.write_date = write_date;
	}
	
	/** StudentDTO **/
	public StudentDTO(int id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sumScore(kor, eng, math);
		this.avg = avgScore(this.sum);
		this.write_date = LocalDate.now();
	}
	
	public StudentDTO() {
		
	}
	
}
