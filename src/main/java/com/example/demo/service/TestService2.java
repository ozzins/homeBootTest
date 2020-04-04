package com.example.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class TestService2 implements InitializingBean, DisposableBean {
	
	/**
	 * 위의 애노테이션은 해당 컴포넌트가 완전히 생성된 후(주입된 후)에 한 번 실행해야할 일들을 코딩한 메소드에 붙이는 것이다.
		즉, 해당 Bean이 완전히 생성된 후 무언가 작동하므로 NullPointerException이 일어나지 않는다.
		물론 생성자에 붙이는 것은 여지없이 에러가 난다.
	 */
	@PostConstruct
	private void init() {
		System.err.println("PostConstruct annotation으로 Test2Service빈이 완전히 생성된 후에 한 번 수행될 메서드에 붙입니다.");
	}

	/**
	 * InitializingBean은 스프링 빈(Bean)이 생성될 때 호출된다. (afterPropertiesSet 메서드)
		위의 예제에서는 @Service로 등록된 Bean인 TestService가 생성될 때 호출될 것이다.
		참고로 Bean이 생성됐다가 삭제되는 것이 반복적으로 일어나면 얼마든지 반복적으로 호출될 수 있다.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("InitializingBean 인터페이스 구현 메서드입니다. Test2Service 'Bean'이 생성될 때 마다 호출되는 메서드 입니다.");
	}

	/**
	 * DisposableBean은 스프링 빈(Bean)이 삭제될 때 호출된다. (destroy 메서드)
		마찬가지로 TestService가 ApplicationContext에서 제거될 때 호출된다.
		이 역시도 Bean이 제거될 때마다 메서드가 호출될 수 있다.
	 */
	@Override
	public void destroy() throws Exception {
		System.err.println("DisposableBean 인터페이스 구현 메서드입니다. Test2Service 'Bean'이 소멸될 때 마다 호출되는 메서드입니다");
	}

}
