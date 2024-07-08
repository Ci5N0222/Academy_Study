package com.kedu.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.dto.FilesDTO;
import com.kedu.services.FilesService;

@Controller
@RequestMapping("/files")
public class FilesController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private FilesService filesService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<FilesDTO> list(int parentSeq) throws Exception {
		return filesService.filesList(parentSeq);
	}
	
	@RequestMapping("/download")
	public void filesDownload(String oriName, String sysName, HttpServletResponse res) throws Exception {
		String realPath = session.getServletContext().getRealPath("upload");
		File target = new File(realPath + "/" + sysName);
	
		oriName = new String(oriName.getBytes(), "ISO-8859-1");
		res.setHeader("content-Disposition", "attachment;filename=\"" + oriName + "\"");
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));	// 파일에서 내용 뽑아오
			DataOutputStream dos = new DataOutputStream(res.getOutputStream());){	// 네트워크 방향으로 출력하기
			byte[] fileContents = new byte[(int)target.length()];
			dis.readFully(fileContents);
			dos.write(fileContents);
			dos.flush();
		}		
	}
	
}
