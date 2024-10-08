package com.kedu.services;

import com.kedu.dao.MembersDAO;
import com.kedu.dto.MembersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MembersService implements UserDetailsService {

    @Autowired
    private MembersDAO membersDAO;

    /** Login **/
    public boolean login(MembersDTO dto) {
        MembersDTO member = membersDAO.login(dto);
        if(member.getName() != null) return true;
        else return false;
    }

    /** Spring Security에서 권장하는 방법 **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MembersDTO dto = membersDAO.getMembers(username);
        return new User(dto.getId(), dto.getPw(), AuthorityUtils.createAuthorityList(dto.getRole()));
    }
}
