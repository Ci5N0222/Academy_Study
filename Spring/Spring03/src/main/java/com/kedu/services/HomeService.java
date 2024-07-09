package com.kedu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kedu.dao.BoardDAO;

import commons.page.PageConfig;
import commons.page.PageDTO;

@Service
public class HomeService {

//	@Autowired
//	private Gson gson;
//	
//	@Autowired
//	private BoardDAO boardDAO;
//	
//	/** 타겟에 따라 네이게이터 반환 **/
//	public String navigator(String target, int cpage) {
//		String str = "{\"result\": \"fail\"}";
//		
//		try {
//			int totalCount = 0;
//			int recordPage = PageConfig.BOARD_RECORD_PAGE;
//			int naviPage = PageConfig.BOARD_NAVI_PAGE;
//			String url = PageConfig.BOARD_PAGE;
//			
//			switch(target) {
//				case "board" :
//					totalCount = boardDAO.boardCount();
//					break;
//			}
//			
//			PageDTO result = new PageDTO(cpage, totalCount, recordPage, naviPage, url);
//			str = "{\"result\": \"ok\", \"data\": "+ gson.toJson(result) +"}";
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return str;
//	}
}
