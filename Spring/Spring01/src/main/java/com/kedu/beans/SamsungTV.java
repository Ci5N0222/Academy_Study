package com.kedu.beans;

import com.kedu.interfaces.Tv;

public class SamsungTV implements Tv{

	private int channel;
	private int volume;
	
	public SamsungTV(int channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}
	
	public SamsungTV() {
		System.out.println("Samsung TV");
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

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;	
		
	}
	
	
}
