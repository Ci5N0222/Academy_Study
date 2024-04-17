package exam;

class Multi1 extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("@ ");
		}
	}
}

class Multi2 extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("$ ");
		}
	}
}

public class Exam02 {

	public static void main(String[] args) {
		
		// #, @, $ 각 100번씩 멀티 스레드로 화면에 출력
		Multi1 m1 = new Multi1();
		Multi2 m2 = new Multi2();
		
		m1.start();
		m2.start();
		
		for(int i=0; i<100; i++) {
			System.out.print("# ");
		}
	}

}
