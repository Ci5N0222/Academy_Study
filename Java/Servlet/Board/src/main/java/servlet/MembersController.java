package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Sha512;
import members.dao.MembersDAO;
import members.dto.MembersDTO;

@WebServlet("*.members")
public class MembersController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트로 부터 전송되는 문자열에 대한 인코딩을 utf8 처리
		// 리퀘스트로 부터 값을 꺼내기 전에 처리해야 함!!
		request.setCharacterEncoding("utf8");
		
		MembersDAO dao = MembersDAO.getInstance();
		String cmd = request.getRequestURI();
		
		System.out.println("요청 받은 내용 : " + cmd);
		
		
		/** ID 중복체크 **/
		if(cmd.equals("/idCheck.members")) {
			int result = 0;
			String id = request.getParameter("id");
			 
			try {
				result = dao.duplicateById(id);	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/members/idcheck.jsp").forward(request, response);
		} 
		
		
		/** 회원 가입 **/
		else if(cmd.equals("/join.members")) {
			String id = request.getParameter("id");
			String pw = Sha512.getSHA512(request.getParameter("pw"));
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String zipcode = request.getParameter("pcode");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			
			if(phone.equals("")) phone = null;
			if(email.equals("")) email = null;
			if(zipcode.equals("")) zipcode = null;
			if(address1.equals("")) address1 = null;
			if(address2.equals("")) address2 = null;
			
			int result = 0;
			try {
				result = dao.joinMembers(new MembersDTO(id, pw, name, phone, email, zipcode, address1, address2, null));
			} catch (Exception e) {

			}
			
			if(result == 1) response.sendRedirect("/");
			else {
				System.out.println("회원가입 실패");
			}
		}
		
		
		/** 회원 탈퇴 **/
		else if(cmd.equals("/memberOut.members")) {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("loginID");
			
			int result = 0;
			try {
				 result = dao.outMembers(id);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
				session.invalidate();
				response.sendRedirect("/");
			} else {
				// 회원 탈퇴 실패
				response.sendRedirect("/");
			}
		}
		
		
		/** 로그인 **/
		else if(cmd.equals("/signin.members")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String result = "";
			try {
				result = dao.signIn(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
				result = "error";
			}
			
			if(result.equals("success")) {
				HttpSession session = request.getSession();
				session.setAttribute("loginID", id);
				response.sendRedirect("/");
				
			} else {
				// 로그인 실패
				response.sendRedirect("/");
			}
		}
		
		
		/** 로그아웃 **/
		else if(cmd.equals("/signout.members")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/");
		}
		
		
		/** 마이페이지 **/
		else if(cmd.equals("/myPage.members")) {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("loginID");
			
			MembersDTO dto = null;
			try {
				dto =  dao.myPage(id);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/members/my_page.jsp").forward(request, response);
				
			} catch (Exception e) {
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/members/my_page.jsp").forward(request, response);
			}
		}
		

		/** 회원 정보 수정 **/
		else if(cmd.equals("/update.members")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String zipcode = request.getParameter("zipcode");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			
			int result = 0;
			try {
				result = dao.updateMembers(new MembersDTO(id, null, name, phone, email, zipcode, address1, address2, null));
			} catch (Exception e) {

			}
			
			if(result > 0) {
				response.sendRedirect("/myPage.members");
			} else {
				// 수정 실패
				response.sendRedirect("/myPage.members");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
