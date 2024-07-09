package com.kedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.FilesDAO;
import com.kedu.dto.FilesDTO;

@Service
public class FilesService {

	@Autowired
	private FilesDAO filesDAO;
	
	/** 파일 목록 **/
	public List<FilesDTO> filesList(int seq) throws Exception {
		return filesDAO.filesList(seq);
	}
}
