package com.kedu.services;

import com.kedu.dao.MembersDAO;
import com.kedu.dto.MembersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

    @Autowired
    private MembersDAO membersDAO;

    public boolean login(MembersDTO dto) {
        MembersDTO member = membersDAO.login(dto);

        if(member.getName() != null) return true;
        else return false;
    }

}
