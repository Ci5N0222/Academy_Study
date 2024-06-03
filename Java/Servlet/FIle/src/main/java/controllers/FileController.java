package controllers;

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

import dao.FilesDAO;
import dto.FilesDTO;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getRequestURI();
		
		FilesDAO dao = FilesDAO.getInstance();
		
		try {
			if(cmd.equals("/upload.file")) {

				int maxSize = 1024 * 1024 * 10;
				String realPath = request.getServletContext().getRealPath("files");
				File uploadPath = new File(realPath);
				if(!uploadPath.exists()) {
					uploadPath.mkdir();
				}
				
				MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				
				Enumeration<String> names = multi.getFileNames();
				while(names.hasMoreElements()) {
					String name = names.nextElement();
					String oriname = multi.getOriginalFileName(name);
					String sysname = multi.getFilesystemName(name);
					System.out.println(name);
					
					if(oriname != null) {
						int result = dao.insert(new FilesDTO(0, oriname, sysname, 100));
					}
				}
				
//				String oriName = multi.getOriginalFileName("file");
//				String syaName = multi.getFilesystemName("file");
				
				

				response.sendRedirect("/index.jsp");
				
			}
			
			else if(cmd.equals("/list.file")) {
				System.out.println("/list.files");
				int parentSeq = 100;
				
				List<FilesDTO> list =  dao.fileList(parentSeq);
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
