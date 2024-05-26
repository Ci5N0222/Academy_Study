package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDAO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("(Parameter) id ==== " + id);
		
		try {
			int result = MovieDAO.getInstance().deleteMovie(Integer.parseInt(id));

			if(result > 0) response.sendRedirect("/OutputServlet");
			else {
				request.setAttribute("state", 2);
				request.getRequestDispatcher("failed.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("state", 2);
			request.getRequestDispatcher("failed.jsp").forward(request, response);
			
		}
		
	}

}
