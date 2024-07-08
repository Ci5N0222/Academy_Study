package com.kedu.services;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.FilesDAO;

@Service
public class FilesService {

	@Autowired
	private FilesDAO dao;
	
	/**
	 * 파일 이름 지정 및, 파일 전송 로직
	 * @param realPath
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public void uploadFile(String realPath, MultipartFile[] files) throws Exception {

		/* 해당 경로에 폴더가 없을 경우 폴더 생성 */
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) realPathFile.mkdir();
		
		for(MultipartFile file : files) {
			/* 파일이 없을 경우 걸러내는 작업 */
			if(file.getSize() == 0) continue;
			
			String oriName = file.getOriginalFilename();
			String sysName = UUID.randomUUID() + "_" + oriName;
			
			/* 해당 경로로 파일 이동시키는 작업 ( 이 작업을 하지 않을 경우 파일 날라감 ) */
			file.transferTo(new File(realPathFile + "/" + sysName));
			
			dao.insert(oriName, sysName, 0);
		}

	}
}
