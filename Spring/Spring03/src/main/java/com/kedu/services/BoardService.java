package com.kedu.services;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.BoardDAO;
import com.kedu.dao.FilesDAO;
import com.kedu.dto.BoardDTO;
import com.kedu.dto.FilesDTO;

import commons.page.PageConfig;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private FilesDAO filesDAO;
	
	/** 게시글 목록 **/
	public List<BoardDTO> boardList(Integer cpage) throws Exception {
		if(cpage == null) cpage = 1;
		Map<String, Integer> map = new HashMap<>();
		map.put("start", cpage * PageConfig.BOARD_RECORD_PAGE - (PageConfig.BOARD_RECORD_PAGE - 1));
		map.put("end", cpage * PageConfig.BOARD_RECORD_PAGE);
		return boardDAO.boardList(map);
	}
	
	/** 검색된 게시글 목록 **/
	public List<BoardDTO> boardSearchList(String select, String search, Integer cpage) throws Exception {
		if(cpage == null) cpage = 1;
		Map<String, Object> map = new HashMap<>();
		map.put("start", cpage * PageConfig.BOARD_RECORD_PAGE - (PageConfig.BOARD_RECORD_PAGE - 1));
		map.put("end", cpage * PageConfig.BOARD_RECORD_PAGE);
		map.put("select", select);
		map.put("search", search);
		return boardDAO.boardSearchList(map);
	}
	
	/** 게시글 작성 및 파일 업로드 **/
	@Transactional
	public int boardAndFilesInsert(BoardDTO dto, MultipartFile[] files, String realPath) throws Exception {
		
		int seq = boardDAO.boardInsert(dto);
		
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
		
		System.out.println(count + "개의 파일이 업로드 됨");
		
		return seq;
	}
	
	/** 게시글 디테일 **/
	public BoardDTO boardDetail(int seq) throws Exception {
		return boardDAO.boardDetail(seq);
	}
	
	/** 게시글 업데이트 **/
	public int boardUpdate(BoardDTO dto) throws Exception {
		return boardDAO.boardUpdate(dto);
	}
	
	/** 게시글 삭제 **/
	public int boardDelete(int seq) throws Exception {
		return boardDAO.boardDelete(seq);
	}
	
}
