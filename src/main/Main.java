package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import dao.MovieDAO;
import dto.MovieDTO;

public class Main {

	public static void main(String[] args) {
		
		/** MovieDAO **/
		MovieDAO dao = new MovieDAO();
		
		// Create Input stream
		InputStream is = null;
		DataInputStream dis = null;

		// Create Output stream
		OutputStream os = null;
		DataOutputStream dos = null;

		try {
			ServerSocket server = new ServerSocket(26000);
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress() + "로 부터 접속");
			
			// Setting Input stream
			is = socket.getInputStream();
			dis = new DataInputStream(is);

			// Setting Output stream
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
			System.exit(0);
		}

		while (true) {
			try {
				String msg = dis.readUTF();
				System.out.println("MSG === " + msg);
				String[] result = msg.split(",");
				
				/** 신규 영화 등록 **/
				if (result[0].equals("1")) {
					String message = dao.addMovie(result[1], result[2]);
					dos.writeUTF(message);
					dos.flush();
				
				/** 영화 목록 조회 **/
				} else if (result[0].equals("2")) {
					String resultStr = "";
					int split = 0;
					ArrayList<MovieDTO> movieList = dao.movieList();
					for (MovieDTO movie : movieList) {
						// 내용 단위 (,)를 기준으로 분기
						resultStr += movie.getId() + "," + movie.getTitle() + "," + movie.getGenre() + ","
								+ movie.getWrite_date();
						
						// 리스트 단위 (/)를 기준으로 분기
						if (movieList.size() - 1 > split) {
							resultStr += "/";
							split++;
						}
					}
					
					dos.writeUTF(resultStr);
					dos.flush();
					
				/** 영화 검색 **/
				} else if (result[0].equals("3")) {
					String resultStr = "";
					int split = 0;
					ArrayList<MovieDTO> movieList = dao.searchMovies(result[1]);
					for (MovieDTO movie : movieList) {
						// 내용 단위 (,)를 기준으로 분기
						resultStr += movie.getId() + "," + 
								  movie.getTitle() + "," + 
								  movie.getGenre() + "," + 
								  movie.getWrite_date();
						
						// 리스트 단위 (/)를 기준으로 분기
						if (movieList.size() - 1 > split) {
							resultStr += "/";
							split++;
						}
					}
					
					dos.writeUTF(resultStr);
					dos.flush();
					
				/** 영화 삭제 **/
				} else if (result[0].equals("4")) {
					String message = dao.deleteMovie(Integer.parseInt(result[1]));
					dos.writeUTF(message);
					dos.flush();
					
				/** 영화 영화 정보 변경 **/
				} else if (result[0].equals("5")) {
					String message = dao.updateMovie(Integer.parseInt(result[1]), result[2], result[3]);
					dos.writeUTF(message);
					dos.flush();
					
				/** 오입력 오류 **/
				} else {
					dos.writeUTF("잘못입력하셨습니다");
					dos.flush();
				}

			} catch (Exception e) {
				System.out.println("Error : " + e);
				System.exit(0);
			}

		}

	}

}
