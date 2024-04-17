package exam;

import javax.swing.JOptionPane;

class CountDown extends Thread {
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {Thread.sleep(1000);}
			catch (Exception e) {}
		}
		System.out.println("실패");
		System.exit(0);
	}
}


public class Exam03 {

	public static void main(String[] args) {
		
		CountDown cd = new CountDown();
		cd.start();
		
		String[] sentences = new String[] {
				"public static void main(String[] ar)",
				"Scanner sc = new Scanner(System.in)",
				"DataInputStream dis = new DatainputStream()"
		};
		
		int rand = (int)(Math.random()*3);
		
		String msg = JOptionPane.showInputDialog(sentences[rand]);
		if(msg.equals(sentences[rand])) {
			System.out.println("성공");
			System.exit(0);
		} else {
			System.out.println("실패");
			System.exit(0);
		}
		
	}

}
