package com.kedu.messages.domain.mappers;

import com.kedu.messages.domain.entity.Messages;
import com.kedu.messages.dto.MessagesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessagesMapper {
    Messages toEntity(MessagesDTO messagesDTO);
    MessagesDTO toDTO(Messages messages);

    List<Messages> toEntityList(List<MessagesDTO> list);
    List<MessagesDTO> toDTOList(List<Messages> list);

}
