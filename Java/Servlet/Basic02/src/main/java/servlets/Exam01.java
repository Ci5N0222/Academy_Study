package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {
	
	// Servlet 직렬화 시 필요한 코드
//	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("GET 방식 요청 확인");
		
		String writer = request.getParameter("writer");
		String msg = request.getParameter("msg");
		
		// 1. 처리
		System.out.println("params.writer === " + writer);
		System.out.println("params.msg === " + msg);
		
		// 2. 응답
		PrintWriter pw = response.getWriter();
		pw.append("<html>");
		pw.append("<body>");
		pw.append("Process complete");
		pw.append("<button id='ok'>OK</button>");
		pw.append("<script>document.querySelector('#ok').onclick=function(){location.href='/';}</script>");
		pw.append("</body>");
		pw.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 방식 요청 확인");
		
		String writer = request.getParameter("writer");
		String msg = request.getParameter("msg");
		
		// 1. 처리
		System.out.println("params.writer === " + writer);
		System.out.println("params.msg === " + msg);
		
		// 2. 응답
		PrintWriter pw = response.getWriter();
		pw.append("<html>");
		pw.append("<body>");
		pw.append("Process complete");
		pw.append("<button id='ok'>OK</button>");
		pw.append("<script>document.querySelector('#ok').onclick=function(){location.href='/';}</script>");
		pw.append("</body>");
		pw.append("</html>");
	}

}
