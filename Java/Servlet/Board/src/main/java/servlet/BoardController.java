package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import common.BoardConfig;
import files.dao.FilesDAO;
import files.dto.FilesDTO;
import reply.dao.ReplyDAO;
import reply.dto.ReplyDTO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String cmd = request.getRequestURI();
		BoardDAO dao = BoardDAO.getInstance();
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		FilesDAO filesDAO = FilesDAO.getInstance();
		
		try {
			/** 글 쓰기 **/
			if(cmd.equals("/write.board")) {
				
				int maxSize = 1024 * 1024 * 10;
				String realPath = request.getServletContext().getRealPath("files");
				File uploadPath = new File(realPath);
				if(!uploadPath.exists()) {
					uploadPath.mkdir();
				}
				
				MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				
				String writer = (String) request.getSession().getAttribute("loginID");
				String title = multi.getParameter("title");
				String contents = multi.getParameter("contents");
				
				int result = dao.write(writer, title, contents);

				int seq = dao.seqByWirter(writer);
				
				Enumeration<String> names = multi.getFileNames();
				while(names.hasMoreElements()) {
					String name = names.nextElement();
					String oriname = multi.getOriginalFileName(name);
					String sysname = multi.getFilesystemName(name);
					System.out.println(name);
					
					if(oriname != null) {
						filesDAO.insert(new FilesDTO(0, oriname, sysname, seq));
					}
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
				
				List<BoardDTO> list =  dao.getListNtoM(
								cpage * BoardConfig.RECODE_COUNT_PER_PAGE - (BoardConfig.RECODE_COUNT_PER_PAGE - 1),
								cpage * BoardConfig.RECODE_COUNT_PER_PAGE);
				
				request.setAttribute("recode_total_count", dao.getRecordCount());
				request.setAttribute("cpage", cpage);
				request.setAttribute("recorde_count_per_page", BoardConfig.RECODE_COUNT_PER_PAGE);
				request.setAttribute("navi_count_per_page", BoardConfig.NAVI_COUNT_PER_PAGE);
				
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			}
			
		
			/** 게시글 디테일 **/
			else if(cmd.equals("/detail.board")) {
				int seq = Integer.parseInt(request.getParameter("id"));

				dao.viewCountUp(seq);
				BoardDTO dto = dao.boardDetail(seq);
				List<ReplyDTO> reply = replyDAO.replyList(seq);
				List<FilesDTO> files =  filesDAO.fileList(seq);
				
				request.setAttribute("dto", dto);
				request.setAttribute("reply", reply);
				request.setAttribute("files", files);
				request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
			}
			
			
			/** 게시물 검색 **/
			else if(cmd.equals("/search.board")) {
				String search = request.getParameter("search");
				
				List<BoardDTO> list = dao.searchList(search);
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			}
			
			
			/** 게시물 삭제 **/
			else if(cmd.equals("/delete.board")) {
				String idx = request.getParameter("idx");
				String writer = (String) request.getSession().getAttribute("loginID");
				
				int result  = dao.deleteContents(Integer.parseInt(idx), writer);
				
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
				
				int result = dao.updateContents(Integer.parseInt(seq), writer, title, contents);
				if(result > 0) {
					response.sendRedirect("/detail.board?id="+seq);
				} else {
					// 글 수정 실패
					response.sendRedirect("/detail.board?id="+seq);
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
