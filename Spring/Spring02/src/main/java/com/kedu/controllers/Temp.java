package com.kedu.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Temp {

	public static void main(String[] args) {
		// Java의 Map == DTO == JavaScript JSON
		
		Map<String, String> map1 = new TreeMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		
		// TreeMap : 자동 정렬, 트리형태 알고리즘, HashMap에 비해 덜 사용 됨
		// HashMap : 정렬 없음, 성능, 범용성 면에서 좋다.
		
		map2.put("key1", "value1");
		map2.put("key2", "value2");
		
		for(String key: map2.keySet()) {
			System.out.println("key === " + key);
		}
		
		// Mapper.xml 에서 resultType에 DTO를 쓰냐 HashMap을 쓰냐
		// DTO : 필드가 고정됨
		// HashMap : 동적으로 생성된 컬럼을 키값으로 필드값이 매핑 됨
		
		
	}
	
}
