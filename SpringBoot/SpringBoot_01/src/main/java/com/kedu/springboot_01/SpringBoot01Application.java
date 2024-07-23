package com.kedu.springboot_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot01Application {
	/**
	 * 	스프링 레거시 <-> 스프링 부튼
	 *
	 *  WebSicket EndPoing 코드 변경
	 *  Interceptor 등록 방법 변경
	 *  Third Party : 외부 라이브러리 인스턴스 생성
	 *
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

}
