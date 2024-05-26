package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDAO;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		System.out.println("(Parameter) title ===== " + title);
		System.out.println("(Parameter) genre ===== " + genre);
		
		int result = 0;
		try {
			result = MovieDAO.getInstance().addMovie(title, genre);
			
			// JSP로 화면을 만들어 달라는 요청을 보낼 때 파라미터 값을 넣어 줄 수 있다?
			// Response를 보내는 이유 response.getWrite().append("<어쩌고>");
			request.setAttribute("result", result);
			request.getRequestDispatcher("success.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if(result > 0) response.sendRedirect("/");
		else {
			request.setAttribute("state", 1);
			request.getRequestDispatcher("failed.jsp").forward(request, response);
		}
		
	}

}
