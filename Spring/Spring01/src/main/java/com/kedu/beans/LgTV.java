package com.kedu.beans;

import com.kedu.interfaces.Tv;

public class LgTV implements Tv{

	private int channel;
	private int volume;
	
	
	
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public LgTV(int channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}

	public LgTV() {
		System.out.println("LG TV");
	}
	
	@Override
	public void channelUp() {
		
	}

	@Override
	public void channelDown() {
		
	}

	@Override
	public void volumeUp() {
		
	}

	@Override
	public void volumeDown() {
		
	}
	

}
