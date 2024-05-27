package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Sha512;
import members.dao.MembersDAO;
import members.dto.MembersDTO;

@WebServlet("*.members")
public class MembersController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			if(result > 0) System.err.println("이미 사용중인 ID임");
			else System.out.println("사용 가능한 ID임");
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/members/idcheck.jsp").forward(request, response);
		
		} 
		
		/** 회원 가입 **/
		else if(cmd.equals("/members/join.members")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
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
				result = dao.joinMembers(new MembersDTO(id, Sha512.getSHA512(pw), name, phone, email, zipcode, address1, address2, null));
			} catch (Exception e) {

			}
			
			if(result == 1) request.getRequestDispatcher("/members/join_success.jsp").forward(request, response);
			else {
				System.out.println("회원가입 실패");
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
