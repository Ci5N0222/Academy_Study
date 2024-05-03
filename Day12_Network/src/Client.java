import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Socket client = new Socket("127.0.0.1", 20000);
			
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			DataInputStream dis = new DataInputStream(client.getInputStream());
			
			boolean isLogin = false;
			String sessionId = "";
			
			while(true) {
				/** 로그인 페이지 **/
				while(!isLogin) {
					System.out.println("<< Login >>");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 종료");
					String input = sc.nextLine();
					
					try {
						if(input.equals("1")) {
							System.out.println("<< 로그인 >>");
							System.out.print("ID : ");
							String id = sc.nextLine();
							System.out.print("PW : ");
							String pw = sc.nextLine();
							
							dos.writeUTF("1");
							dos.writeUTF(id);
							dos.writeUTF(pw);
							dos.flush();
							
							String res = dis.readUTF();
							System.out.println(res);
							
							if(res.equals("로그인 성공")) {
								sessionId = id;
								isLogin = true;
								break;
							}
							
						} else if(input.equals("2")) {
							System.out.println("<< 회원 가입 >>");
							System.out.print("ID : ");
							String id = sc.nextLine();
							System.out.print("PW : ");
							String pw = sc.nextLine();
							System.out.print("Name : ");
							String name = sc.nextLine();
							
							dos.writeUTF("2");
							dos.writeUTF(id);
							dos.writeUTF(pw);
							dos.writeUTF(name);
							dos.flush();
							
							String res = dis.readUTF();
							System.out.println(res);
							
						} else if(input.equals("0")) {
							System.out.println("시스템을 종료합니다.");
							System.exit(0);
							
						} else {
							System.out.println("잘못 입력함!!!");
						}
						
					} catch (Exception e) {
						System.out.println("오류 발생함!!!");
					}
					
				}
				
				/** 로그인 후 **/
				while(isLogin) {
					System.out.println("<< Mini Board >>");
					System.out.println("1. 글 작성하기");
					System.out.println("2. 글 목록보기");
					System.out.println("3. 글 검색하기");
					System.out.println("4. 글 수정하기");
					System.out.println("5. 글 삭제하기");
					System.out.println("99. 시스템종료");
					System.out.println("0. 로그아웃");
					System.out.print(">>>  ");
					
					String input = sc.nextLine();
					dos.writeUTF(input);
					dos.flush();
					
					if(input.equals("1")) {
						System.out.println("<< 글 작성하기 >>");
						System.out.print("내용 : ");
						String content = sc.nextLine();
						
						dos.writeUTF(content);
						dos.flush();
						
						String result = dis.readUTF();
						System.out.println(result);
						
					} else if(input.equals("2")) {
						String result = dis.readUTF();
						String[] str = result.split("%");
						
						for(int i=0; i<str.length; i++) {
							System.out.println(str[i]);
						}
						
						
					} else if(input.equals("3")) {
						System.out.println("<< 글 검색하기 >>");
						System.out.print("검색 : ");
						String search = sc.nextLine();
						
						dos.writeUTF(search);
						dos.flush();
						
						String result = dis.readUTF();
						String[] str = result.split("%");
						
						for(int i=0; i<str.length; i++) {
							System.out.println(str[i]);
						}
						
					} else if(input.equals("4")) {
						System.out.println("<< 글 수정하기 >>");
						System.out.print("ID 입력 : ");
						int seq = Integer.parseInt(sc.nextLine());
						
						dos.writeInt(seq);
						dos.flush();
						
						boolean vali = dis.readBoolean();
						if(vali) {
							System.out.print("내용 : ");
							String content = sc.nextLine();
							dos.writeUTF(content);
							dos.flush();
							String result = dis.readUTF();
							System.out.println(result);
						} else {
							String result = dis.readUTF();
							System.out.println(result);
						}
						
					} else if(input.equals("5")) {
						System.out.println("<< 글 삭제하기 >>");
						System.out.print("ID 입력 : ");
						int seq = Integer.parseInt(sc.nextLine());
						
						dos.writeInt(seq);
						dos.flush();
						
						boolean vali = dis.readBoolean();
						if(vali) {
							String result = dis.readUTF();
							System.out.println(result);
						} else {
							String result = dis.readUTF();
							System.out.println(result);
						}
						
						
					} else if(input.equals("99")) {
						System.out.println("프로그램 종료!!");
						System.exit(0);
						
					} else if(input.equals("0")) {
						System.out.println("로그아웃!!!");
						isLogin = false;
						sessionId = "";
						break;
						
					} else {
						String result = dis.readUTF();
						System.out.println(result);
					}
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("오류 발생!!");
		}


	}

}
