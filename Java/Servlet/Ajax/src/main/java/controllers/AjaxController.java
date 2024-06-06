package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.MovieDTO;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getRequestURI();
		
		// Google에서 만든 JSON 직렬화 라이브러리 : gson
		Gson g = new Gson();
		
		if(cmd.equals("/exam01.ajax")) {
			System.out.println("단순 요청 확인");
		}
		
		else if(cmd.equals("/exam02.ajax")) {
			String key1 = request.getParameter("key1");
			String key2 = request.getParameter("key2");
			System.out.println("key1 ==== " + key1);
			System.out.println("key2 ==== " + key2);
			
		}
		
		else if(cmd.equals("/exam03.ajax")) {
			PrintWriter pw =  response.getWriter();
			pw.append("AJAX 응답 데이터 입니다.");
		}
		
		else if(cmd.equals("/exam04.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			
			String[] fruits = new String[] {
					"Orange", "Mango", "Apple"
			};
			
			String result = g.toJson(fruits);
			
			PrintWriter pw =  response.getWriter();
			pw.append(result);
		}
		
		else if(cmd.equals("/exam05.ajax")) {
			MovieDTO dto = new MovieDTO(1001, "범되도시", "액션");
			
			String result = g.toJson(dto);
			
			PrintWriter pw =  response.getWriter();
			pw.append(result);
			
		}
		
		else if(cmd.equals("/exam06.ajax")) {
			List<MovieDTO> list = new ArrayList<>();
			
			list.add(new MovieDTO(1001, "범되도시1", "액션"));
			list.add(new MovieDTO(1002, "범되도시2", "액션"));
			list.add(new MovieDTO(1003, "범되도시3", "액션"));
			
			String result = g.toJson(list);
			PrintWriter pw =  response.getWriter();
			pw.append(result);
			
		}
		
		else if(cmd.equals("/exam07.ajax")) {
			List<MovieDTO> list = new ArrayList<>();
			
			// "{ }"
			JsonObject obj = new JsonObject();
			
			// "[ ]"
			JsonArray arr = new JsonArray();
			
			obj.addProperty("title", "범죄도시");
			obj.addProperty("genre", "액션");
			
			PrintWriter pw =  response.getWriter();
			pw.append(obj.toString());
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
