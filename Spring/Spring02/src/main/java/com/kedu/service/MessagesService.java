package com.kedu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;

@Service
public class MessagesService {

	@Autowired
	private MessagesDAO messagesDAO;
	
	public List<Map<String, Object>> output() {
		List<Map<String, Object>> list = messagesDAO.list();
		
		List<Map<String, Object>> newList = new ArrayList<>();
		
		for(Map<String, Object> map : list) {
            Map<String, Object> newMap = new HashMap<>();
            for(String key : map.keySet()) {
                newMap.put(key.toLowerCase(), map.get(key));
            }
            newList.add(newMap);
        }
		
		return newList;
	}
	
	public List<MessagesDTO> search(String column, String keyword) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("column", column);
		params.put("keyword", keyword);
		
		return messagesDAO.search(params);
	}
	
	public List<MessagesDTO> searchMulti(String writer, String message) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("column", writer);
		params.put("keyword", message);
		return messagesDAO.searchMulti(params);
	}
}
