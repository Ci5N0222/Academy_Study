package exam;

import javax.swing.JOptionPane;

class CountDown extends Thread {
	
	public static int i = 10;
	public static int bonus = 0;
	public static int score = 0;
	
	public void run() {
		for(i=10; i>0; i--) {
			System.out.println(i);
			try {Thread.sleep(1000);}
			catch (Exception e) {}
		}
		System.out.println("Time out!!!");
		System.out.println("총점 : " + score);
		System.exit(0);
	}
}


public class Exam03 {

	public static void main(String[] args) {
		
		CountDown cd = new CountDown();
		cd.start();
		
//		String[] sentences = new String[] {
//				"public static void main(String[] ar)",
//				"Scanner sc = new Scanner(System.in)",
//				"DataInputStream dis = new DatainputStream()"
//		};
		
		String[] sentences = new String[] {
				"public static void main",
				"Scanner sc = new Scanner",
				"DataInputStream"
		};
		
		while(true) {
			int rand = (int)(Math.random()*3);
			String msg = JOptionPane.showInputDialog(sentences[rand]);
			if(msg.equals(sentences[rand])) {
				System.out.println("성공!!!");
				cd.i += 5;
				cd.score += 10 + cd.bonus;
				cd.bonus++;
			} else {
				System.out.println("오타!!!");
				cd.i -= 2;
				cd.bonus = 0;
			}
		}
		
	}

}
