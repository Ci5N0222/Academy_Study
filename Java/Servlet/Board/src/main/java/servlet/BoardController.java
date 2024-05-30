package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import common.BoardConfig;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String cmd = request.getRequestURI();
		BoardDAO dao = BoardDAO.getInstance();
		
		/** 글 쓰기 **/
		if(cmd.equals("/write.board")) {
			String writer = (String) request.getSession().getAttribute("loginID");
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			int result = 0;
			try {
				result = dao.write(writer, title, contents);
			} catch (Exception e) {
				
			}
			
			if(result > 0) response.sendRedirect("/list.board");
			else {
				// 글 등록 실패
				response.sendRedirect("/list.board");
			}
		}
		
		
		/** 글 목록 **/
		else if(cmd.equals("/list.board")) {
			
			String pcpage = request.getParameter("cpage");
			if(pcpage == null) pcpage = "1";
			int cpage = Integer.parseInt(pcpage);
			
			List<BoardDTO> list = new ArrayList<>();
			String pageNavi = "";
			try {
				pageNavi = dao.getPageNavi(cpage);
				list =  dao.getListNtoM(
							cpage * BoardConfig.RECODE_COUNT_PER_PAGE - (BoardConfig.RECODE_COUNT_PER_PAGE - 1),
							cpage * BoardConfig.RECODE_COUNT_PER_PAGE);
//				list =  dao.getList();
				
			} catch (Exception e) {

			}
			request.setAttribute("pageNavi", pageNavi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		}
		
	
		/** 게시글 디테일 **/
		else if(cmd.equals("/detail.board")) {
			int seq = Integer.parseInt(request.getParameter("id"));
			
			// 조회수 업데이트 메서드
			
			
			BoardDTO dto = null;
			try {
				dao.viewCountUp(seq);
				dto = dao.boardDetail(seq);
				 
			} catch (Exception e) {

			}
			
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
		}
		
		
		/** 게시물 검색 **/
		else if(cmd.equals("/search.board")) {
			String search = request.getParameter("search");
			List<BoardDTO> list = new ArrayList<>();
			
			try {
				list = dao.searchList(search);
				
			} catch (Exception e) {
				
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		}
		
		
		/** 게시물 삭제 **/
		else if(cmd.equals("/delete.board")) {
			String idx = request.getParameter("idx");
			String writer = (String) request.getSession().getAttribute("loginID");
			
			System.out.println("idx ==== " + idx);
			System.out.println("writer ==== " + writer);
			
			int result = 0;
			try {
				result = dao.deleteContents(Integer.parseInt(idx), writer);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(result);
			
			if(result > 0) response.sendRedirect("/list.board");
			else {
				// 삭제 실패
				response.sendRedirect("/list.board");
				System.out.println("삭제실패");
			}
		}
		
		
		/** 게시글 업데이트 **/
		else if(cmd.equals("/update.board")) {
			String writer = (String) request.getSession().getAttribute("loginID");
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			int result = 0;
			try {
				result = dao.updateContents(Integer.parseInt(seq), writer, title, contents);
			} catch (Exception e) {

			}
			
			if(result > 0) {
				response.sendRedirect("/detail.board?id="+seq);
			} else {
				// 글 수정 실패
				response.sendRedirect("/detail.board?id="+seq);
			}
			
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
