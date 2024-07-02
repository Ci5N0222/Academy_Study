package com.kedu.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kedu.interfaces.Tv;

public class Main {
	public static void main(String[] args) {

		/**
		 * IOC ( Inversion of control ): 
		 * 	- �ν��Ͻ��� ���� �� ������ �����ڰ� �ƴ� Spring Container�� ����ϴ� ��� 
		 *  - ���� �з� �� ���� �δ��� �ٿ��� �� ����
		 * 
		 * Spring�� ���� �����Ǵ� �ν��Ͻ��� �����ڰ� ����ϱ� ���� �ΰ��� ���
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
