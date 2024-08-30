package com.kedu.services;

import com.kedu.dao.MessageDAO;
import com.kedu.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDAO messageDAO;

    public List<MessageDTO> getMessages() {
        return messageDAO.getMessages();
    }

    public String delMessage(int seq) {
        int result = messageDAO.delMessage(seq);
        if(result > 0) return "ok";
        else return "fail";
    }

}
