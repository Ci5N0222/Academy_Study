package sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.ContentDAO;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	
	ContentDAO dao = new ContentDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		
		System.out.println("Get 요청 도착");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("(Param) writer ==== " + writer);
		System.out.println("(Param) content ==== " + content);
		
		// DB 저장 메서드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			result = dao.addContent(writer, content);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			response.sendRedirect("/");
		} else {
			PrintWriter pw = response.getWriter();
			pw.append("글 등록 실패");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		
		System.out.println("POST 요청 도착");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("(Param) writer ==== " + writer);
		System.out.println("(Param) content ==== " + content);
		
		// DB 저장 메서드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			result = dao.addContent(writer, content);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			response.sendRedirect("/");
		} else {
			PrintWriter pw = response.getWriter();
			pw.append("글 등록 실패");
		}
	}

}
