package com.kedu.service;

import com.kedu.dao.MusicDAO;
import com.kedu.dto.MusicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    private MusicDAO musicDAO;

    public void post(MusicDTO dto) {
        musicDAO.insert(dto);
    }
}
