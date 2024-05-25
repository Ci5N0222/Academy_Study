package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDAO;
import movie.dto.MovieDTO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("update id search (Parameter) id ==== " + id);
		
		try {
			MovieDTO movie = MovieDAO.getInstance().searchMovie(Integer.parseInt(id));
			
			request.setAttribute("movie", movie);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		System.out.println("update info (Parameter) id ==== " + id);
		System.out.println("update info (Parameter) title ==== " + title);
		System.out.println("update info (Parameter) genre ==== " + genre);
		
		int result = 0;
		
		try{
			result = MovieDAO.getInstance().updateMovie(Integer.parseInt(id), title, genre);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		if(result > 0) response.sendRedirect("/OutputServlet");
		else {
			request.setAttribute("state", 3);
			request.getRequestDispatcher("failed.jsp").forward(request, response);
		}
		
	}
	

}
