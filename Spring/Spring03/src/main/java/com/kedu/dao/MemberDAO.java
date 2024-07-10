package com.kedu.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession mybatis;

	// id체크
	public boolean idExitst(String id) throws Exception {
		return mybatis.selectOne("Member.idExitst", id);
	}
	
	// Login
	public boolean isMember(MemberDTO dto) throws Exception {
		return mybatis.selectOne("Member.isMember", dto);
	}

	// id검색
	public MemberDTO searchById(String search) throws Exception {
		return mybatis.selectOne("Member.searchById", search);
	}

	// insert
	public int insert(MemberDTO dto) throws Exception {
		return mybatis.insert("Member.insert", dto);
	}

	// update
	public int update(String id, String name) throws Exception {
		return mybatis.update("Member.update", new MemberDTO(id, null, name));
	}
	
	// delete
	public int delete(String id) throws Exception {
		return mybatis.delete("Member.delete", id);
	}

}
