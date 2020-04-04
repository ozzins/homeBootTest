package com.example.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class TestService0 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.err.println("ApplicationRunner 인터페이스 구현 메서드입니다. '애플리케이션'이 실행될 때 '한 번' 실행됩니다.");
	}

	/**
	 * 위의 애노테이션은 해당 컴포넌트가 완전히 생성된 후(주입된 후)에 한 번 실행해야할 일들을 코딩한 메소드에 붙이는 것이다. 즉, 해당
	 * Bean이 완전히 생성된 후 무언가 작동하므로 NullPointerException이 일어나지 않는다. 물론 생성자에 붙이는 것은 여지없이
	 * 에러가 난다.
	 */
	@PostConstruct
	private void init() {
		System.err.println("PostConstruct annotation으로 Test0Service빈이 완전히 생성된 후에 한 번 수행될 메서드에 붙입니다.");
	}

}
