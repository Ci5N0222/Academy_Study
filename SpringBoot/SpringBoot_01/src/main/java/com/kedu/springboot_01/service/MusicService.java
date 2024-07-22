package com.kedu.springboot_01.service;

import com.kedu.springboot_01.dao.MusicDAO;
import com.kedu.springboot_01.dto.MusicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicDAO musicDAO;

    public void post(MusicDTO dto) {
        musicDAO.insert(dto);
    }

    public List<MusicDTO> getAllData() {
        return musicDAO.getAllData();
    }

    public MusicDTO getOneData(int id) {
        return musicDAO.getOneData(id);
    }

    public void delete(int id) {
        musicDAO.delete(id);
    }

    public void update(MusicDTO dto) {
        musicDAO.update(dto);
    }
}
