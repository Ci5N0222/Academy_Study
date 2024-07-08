package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.FilesDTO;

@Repository
public class FilesDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	/** 파일 업로드 **/
	public int filesUpload(FilesDTO dto) throws Exception {
		String sql = "insert into files values(files_seq.nextval, ?, ?, ?)";
		return jdbc.update(sql, dto.getOriname(), dto.getSysname(), dto.getParent_seq());
	}
	
	/** 파일 목록 **/
	public List<FilesDTO> filesList(int parentSeq) throws Exception {
		String sql = "select * from files where parent_seq = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(FilesDTO.class), parentSeq);
	}
}
