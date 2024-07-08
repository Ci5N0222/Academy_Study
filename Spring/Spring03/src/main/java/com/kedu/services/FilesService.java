package com.kedu.services;


import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.FilesDAO;
import com.kedu.dto.FilesDTO;

@Service
public class FilesService {

	@Autowired
	private FilesDAO filesDAO;
	
	/** 파일 업로드 **/
	public int filesUpload(String realPath, MultipartFile[] files, int seq) throws Exception {
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) realPathFile.mkdir();
		int count = 0;
		
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
			if(file.getSize() == 0) continue;
			
			String oriName = file.getOriginalFilename();
			String sysName = UUID.randomUUID() + "_" + oriName;
			
			file.transferTo(new File(realPathFile + "/" + sysName));
			
			filesDAO.filesUpload(new FilesDTO(0, oriName, sysName, seq));
			count++;
		}
		
		return count;
	}
	
	/** 파일 목록 **/
	public List<FilesDTO> filesList(int seq) throws Exception {
		return filesDAO.filesList(seq);
	}
}
