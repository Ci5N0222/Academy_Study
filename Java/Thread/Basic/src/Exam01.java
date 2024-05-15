
class Worker extends Thread {
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(i);
        }
    }
}

public class Exam01 {
    public static void main(String[] args) {

        /**
         *	Use thread
         *	1. Thread 클래스를 상속받는 사용자 정의 클래스를 작성한다.
         *	2. Thread 클래스로 부터 상속받은 public void run 메서드를 override 한다.
         * 	3. Override 된 메서드 내에 병행처리할 코드를 작성한다.
         * 	4. 사용자 정의 클래스로 부터 인스턴스를 생성한다.
         * 	5. 생성된 인스턴스로 부터 start 메서드를 콜 한다.
         */

        Worker worker = new Worker();

        worker.start();

        for(int i=0; i<100; i++) {
            System.out.println(i);
        }
    }
}
