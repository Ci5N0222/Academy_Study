package com.kedu.messages.service;

import com.kedu.messages.domain.entity.Messages;
import com.kedu.messages.domain.mappers.MessagesMapper;
import com.kedu.messages.domain.repository.MessagesRepository;
import com.kedu.messages.dto.MessagesDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private MessagesMapper messagesMapper;

    /** Message list 조회 **/
    public List<MessagesDTO> getAllMessages() {
        List<Messages> list = messagesRepository.findAll();

        // Entity List를 DTO List로 전환하는 작업
        // 1. Client에게 전달될 필요 없는 컬럼 제거
        // 2. 적절한 데이터 가공 작업

//        List<MessagesDTO> newList = new ArrayList<>();
//        for(Messages entity : list) {
//            MessagesDTO dto = new MessagesDTO();
//            dto.setSeq(entity.getSeq());
//            dto.setMessage(entity.getMessage());
//            dto.setWriter(entity.getWriter());
//            dto.setWriteDate(entity.getWriteDate());
//            newList.add(dto);
//        }
//        return newList;

        // Map Struct library를 이용한 자동 변환 ( Entity --> DTO )
        return messagesMapper.toDTOList(list);
    }

    /** 신규 message 저장 **/
    public void saveMessages(MessagesDTO messagesDTO) {
//        Messages entity = new Messages();
//        entity.setSeq(messagesDTO.getSeq());
//        entity.setMessage(messagesDTO.getMessage());
//        entity.setWriter(messagesDTO.getWriter());
//        entity.setWriteDate(messagesDTO.getWriteDate());
//        messagesRepository.save(entity);

        // Map Struct library를 이용한 자동 변환 ( DTO --> Entity )
        messagesRepository.save(messagesMapper.toEntity(messagesDTO));
    }

    /** Message 수정 **/
    public void updateMessages(MessagesDTO messagesDTO){
        Messages message = messagesRepository.findById(messagesDTO.getSeq()).orElseThrow(() -> new EntityNotFoundException("Message Not Found"));
        message.setWriter(messagesDTO.getWriter());
        message.setMessage(messagesDTO.getMessage());
        message.setWriteDate(new Timestamp(System.currentTimeMillis()));

        messagesRepository.save(message);
    }
    
    /** Message 삭제 **/
    public void deleteMessages(Long seq){
        messagesRepository.deleteById(seq);
    }

}
