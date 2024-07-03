package com.kedu.dto;

import org.springframework.stereotype.Component;

@Component
public class CafeDTO {
	private int seq;
	private String menu;
	private int price;
	
	
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getMenu() {
		return menu;
	}


	public void setMenu(String menu) {
		this.menu = menu;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public CafeDTO(int seq, String menu, int price) {
		super();
		this.seq = seq;
		this.menu = menu;
		this.price = price;
	}


	public CafeDTO() {}
	
}
