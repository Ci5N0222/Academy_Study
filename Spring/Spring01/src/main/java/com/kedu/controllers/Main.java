package com.kedu.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kedu.interfaces.Tv;

public class Main {
	public static void main(String[] args) {

		/**
		 * IOC ( Inversion of control ): 
		 * 	- 인스턴스의 생성 및 관리를 개발자가 아닌 Spring Container가 담당하는 기법 
		 *  - 개발 분량 및 관리 부담을 줄여줄 수 있음
		 * 
		 * Spring에 의해 관리되는 인스턴스를 개발자가 사용하기 위한 두가지 기법
		 *  1. Dependency Lookup ( DL )
		 *  	- getBean();
		 *  2. Dependency injection ( DI )
		*/
		
		// Spring Container instance
		// 1. Dependency Lookup
		ApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		Tv tv = ctx.getBean(Tv.class);
		System.out.println(tv.getChannel() + " : " + tv.getVolume());
		
		
		
		
	}

}
