package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;

@WebServlet("/Quiz01")
public class Quiz01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request type 'get!'");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		System.out.println("title : " + title);
		System.out.println("genre : " + genre);
		
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request type 'post!'");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		System.out.println("title : " + title);
		System.out.println("genre : " + genre);
		
		response.sendRedirect("/");
	}

}
