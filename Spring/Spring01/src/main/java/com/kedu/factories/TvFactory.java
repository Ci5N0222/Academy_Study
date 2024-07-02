package com.kedu.factories;

import com.kedu.beans.LgTV;
import com.kedu.beans.SamsungTV;
import com.kedu.interfaces.Tv;

public class TvFactory {
	
	public static Tv getTv(String type) {
		if(type.equals("samsung")) {
			return new SamsungTV();
		} else if (type.equals("lg")) {
			return new LgTV();
		} else {
			return null;
		}
	}
}
