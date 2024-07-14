package com.kedu.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.MemberDAO;
import com.kedu.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	/** ID Check **/
	public boolean idExitst(String id) throws Exception {
		return memberDAO.idExitst(id);
	}
	
	/** Sign-Up **/
	public int memberInsert(MemberDTO dto) throws Exception {
		return memberDAO.insert(dto);
	}
	
	/** Sign-In **/
	public MemberDTO login(MemberDTO dto) throws Exception {
		return memberDAO.isMember(dto);
	}
	
	/** 회원 탈퇴 **/
	public int memberDelete(String id) throws Exception {
		return memberDAO.delete(id);
	}
	
	/** 회원 정보 수정 **/
	public int memberUpdate(String id, String name) throws Exception {
		return memberDAO.update(id, name);
	}
	
	/** 마이페이지 **/
	public MemberDTO mypage(String id) throws Exception {
		return memberDAO.searchById(id);
	}
}
