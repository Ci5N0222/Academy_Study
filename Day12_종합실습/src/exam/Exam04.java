package exam;

// static
public class Exam04 {
	
	// 멤버 필드: 클래스 내부에 있는 필드
	public int a;			// 인스턴스 멤버 필드
	public static int b;	// 클래스 멤버 필드
	
	public void funcA() {
		
	}
	
	public static void funcB() {
		System.out.println("funcB start");
	}		
	public static void main(String[] args) {
		// static이 들어간 모든 코드는 main의 실행과 동시에 같이 실행된다.
		Exam04.b = 10;
		
		// int a는 인스턴스를 만들어야 메모리에 할당된다.
		new Exam04();
		
		// 모든 인스턴스가 static으로 만들어진 변수를 공유한다.
		Exam04 e1 = new Exam04();
		Exam04 e2 = new Exam04();
		
		e1.b = 12;
		System.out.println(b);
		
		int b = 11;
		System.out.println(b);
		
		funcB();
	}
}
