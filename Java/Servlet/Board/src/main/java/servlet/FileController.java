package servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import files.dao.FilesDAO;
import files.dto.FilesDTO;

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
			
			else if(cmd.equals("/download.file")) {
				
				String filePath = request.getServletContext().getRealPath("files");
				
				String oriName = request.getParameter("oriname");
				String sysName = request.getParameter("sysname");
				
				System.out.println("oriName === " + oriName);
				System.out.println("sysName === " + sysName);
				
				oriName = new String(oriName.getBytes("UTF8"), "ISO-8859-1");

				// response 기본 기능 초기화
				response.reset();
				response.setHeader("Content-Disposition", "attachment;filename="+oriName);
				
				// 위치와 이름을 결합하여 타겟 파일 인스턴스 생성
				File target = new File(filePath + "/" + sysName);
				
				// 하드디스크에서 뽑아낸 타겟 파일 내용을 젖아할 배열을 준비
				byte[] fileContents = new byte[(int)target.length()];
				
				
				try(// 타겟 파일에 스트림을 연결
					DataInputStream dis = new DataInputStream(new FileInputStream(target));
					// 클라이언트에게 데이터를 보낼 수 있는 스트림 개방
					ServletOutputStream sos = response.getOutputStream();){
					
					// 하드 디스크에서 타겟 파일 내용을 램으로 복사
					dis.readFully(fileContents);
					
					// 파일의 내용을 작성
					sos.write(fileContents);
					
					// 내용 전송
					sos.flush();
				}
				
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
