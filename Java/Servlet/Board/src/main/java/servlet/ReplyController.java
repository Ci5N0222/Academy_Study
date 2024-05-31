package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.dao.ReplyDAO;

@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		String cmd = request.getRequestURI();
		
		ReplyDAO dao = ReplyDAO.getInstance();
		
		try {
		
			/** 댓글 입력 **/
			if(cmd.equals("/insert.reply")) {
				System.out.println("댓글 입력");
	
				String writer = (String)request.getSession().getAttribute("loginID");
				String parentSeq = request.getParameter("parent_seq");
				String replyContents = request.getParameter("reply_contents");
				
				int result = dao.insertReply(writer, replyContents, Integer.parseInt(parentSeq));
				
				if(result > 0) response.sendRedirect("/detail.board?id=" + parentSeq);
				else {
					// 작성 오류~
				}
				
			}
			
			/** 댓글 삭제 **/
			else if(cmd.equals("/delete.reply")) {
				String seq = request.getParameter("seq");
				String parent_seq = request.getParameter("detail_seq");
				
				int result = dao.deleteReply(Integer.parseInt(seq));
				
				if(result > 0) response.sendRedirect("/detail.board?id=" + parent_seq);
				else {
					// 삭제 오류~
				}
			}
			
			/** 댓글 수정 **/
			else if(cmd.equals("/update.reply")) {
				String seq = request.getParameter("seq");
				String parentSeq = request.getParameter("parent_seq");
				String contents = request.getParameter("contents");
				
				int result = dao.updateReply(Integer.parseInt(seq), contents);
				
				if(result > 0) response.sendRedirect("/detail.board?id=" + parentSeq);
				else {
					// 업데이트 오류
				}
				
			}
			

		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
