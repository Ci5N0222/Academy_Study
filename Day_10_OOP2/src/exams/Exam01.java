package exams;

class A {
	public void funcA() {
		System.out.println("A class method");
	}
}
class B extends A{
	public void funcB() {
		System.out.println("B class method");
	}
}

public class Exam01 {

	public static void main(String[] args) {
		
		/**
		 *  [ 다형성 ]
		 *  형상이 많은 성질
		 *  is - a 상속관계에 놓인 두 클래스 중, 부모클래스 참조변수에 발현되는 성질
		 *  상속관계의 클래스에서 부모클래스는 참조변수는 자신을 상속받는 자식 클래스 인스턴스의 주소를 저장할 수 있는 성질
		 *  부모 클래스 참조변수에 자식 클래스 인스턴스의 주소를 저장했을 때, 기본적으로 참조변수의 타입만 접근 가능하다.
		 *  만약 저장된 인스턴스의 모든 것을 사용해야 한다면, DownCasting이 필요하다.
		 *  * 예외 사항: 다운캐스팅 없이 사용 가능한 메서드도 존재함 --> 오버라이딩 된 메서드
		 */
		
		// A형 변수의 다형성
		// 기본 형태: 업 캐스팅 (프로모션)
		A a = new B();	// ((A)a) 이런식으로 업 캐스팅 된다.	
		a.funcA();	
		
		// B class의 메서드를 사용하기 위해 B형으로 캐스팅(형 변환)한다.
		// 다운 캐스팅 (부모 --> 자식으로 캐스팅)
		((B)a).funcB();	
		
	}

}
