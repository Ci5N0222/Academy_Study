package com.kedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.HomeDAO;

@Service
public class HomeService {

	@Autowired
	private HomeDAO homeDAO;
}
