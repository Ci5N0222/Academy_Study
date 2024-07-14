package com.kedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.FilesDTO;

@Repository
public class FilesDAO {

	@Autowired
	private SqlSession mybatis;
	
	/** 파일 업로드 **/
	public int filesUpload(FilesDTO dto) throws Exception {
		return mybatis.insert("Files.upload");
	}
	
	/** 파일 목록 **/
	public List<FilesDTO> filesList(int parentSeq) throws Exception {
		return mybatis.selectList("Files.list", parentSeq);
	}
}
