package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDAO;
import movie.dto.MovieDTO;

@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<MovieDTO> list = MovieDAO.getInstance().movieList();
			request.setAttribute("movieList", list);
			request.getRequestDispatcher("output_form.jsp").forward(request, response);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
