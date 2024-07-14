package com.kedu.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.BoardDAO;

import commons.page.PageConfig;
import commons.page.PageDTO;

@Service
public class HomeService {

	@Autowired
	private BoardDAO boardDAO;
	
	/** 타겟에 따라 네이게이터 반환 **/
	public Map<String, Object> navigator(String target, Map<String, Object> data) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "fail");
		
		try {
			int totalCount = 0;
			int recordPage = PageConfig.BOARD_RECORD_PAGE;
			int naviPage = PageConfig.BOARD_NAVI_PAGE;
			String url = PageConfig.BOARD_PAGE;
			
			switch(target) {
				case "board" :
					totalCount = boardDAO.boardCount();
					break;
				case "searchBoard" :
					totalCount = boardDAO.boardSearchCount(data);
			}
			Integer cpage = (Integer) data.get("cpage");
			if(cpage == null) cpage = 1;
			PageDTO result = new PageDTO(cpage, totalCount, recordPage, naviPage, url);
			map.put("result", "ok");
			map.put("data", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
