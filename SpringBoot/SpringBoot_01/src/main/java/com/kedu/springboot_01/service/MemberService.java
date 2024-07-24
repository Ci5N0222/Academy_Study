package com.kedu.springboot_01.service;

import com.kedu.springboot_01.dao.MemberDAO;
import com.kedu.springboot_01.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;

    public void insert(MemberDTO dto) {
        memberDAO.insert(dto);
    }

    public Boolean signIn(MemberDTO dto) {
        return memberDAO.signIn(dto);
    }

    public MemberDTO auth(MemberDTO dto) {
        return memberDAO.auth(dto);
    }

    public MemberDTO mypage(String id) {return memberDAO.mypage(id);}

    public void delete(String id){ memberDAO.delete(id); }

}
