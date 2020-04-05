package com.example.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;

@Service
public class TestService1 implements  ApplicationListener<ContextClosedEvent>, CommandLineRunner
{
	
	/**
	 *	CommandLineRunner는 main 메서드와 거의 같다고 이해하면 된다. (run 메서드)
		"스프링 애플리케이션"이 시작할 때 "1회"만 호출되는 점이 똑같고 다른 점은 static이 아니라는 점에서 이득을 가져갈 수 있는 부분이 있다. argument도 main에 들어오는 것과 똑같다!
		애플리케이션이 시작되었을 때 하고 싶은 초기 작업이 있다면 이 인터페이스를 구현하도록 하자.
	 */
	@Override
	public void run(String... args) throws Exception {
		System.err.println("commandLineRunner 인터페이스 구현 메서드입니다. '애플리케이션'이 실행될 때 '한 번' 실행됩니다.");
	}

	/**
	 * ApplicationListener는 이벤트와 관련이 있다. (onApplicationEvent 메서드)
		ApplicationEvent(추상클래스)를 상속받은 모든 이벤트들을 넣을 수 있다.
		따라서 내가 ApplicationEvent를 상속받은 클래스를 만들어서 내가 만든 이벤트가 발생했을 때 호출될 메서드를 만들 수도 있는 것이다.
		위의 예제에서는 ContextClosedEvent를 감지하는 인터페이스를 구현했기 때문에, 애플리케이션이 종료되기 직전에 1회만 호출된다.
		실무에서 graceful shutdown이 필요할 때 이 메서드를 구현하도록 하자.
		applicationListener에 ApplicationReadyEvent를 감지하도록 하면 애플리케이션이 온전히 실행되고 나서 1회만 호출하도록 할 수 있다.
	 */
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.err.println("ApplicationListener<ContextClosedEvent> 인터페이스 구현 메서드 입니다. '애플리케이션'이 죽었을 때 '한 번' 실행됩니다.");
		System.err.println("이벤트 발생 시간(timestamp) : " + event.getTimestamp());
	}


	/**
	 * 위의 애노테이션은 해당 컴포넌트가 완전히 생성된 후(주입된 후)에 한 번 실행해야할 일들을 코딩한 메소드에 붙이는 것이다.
		즉, 해당 Bean이 완전히 생성된 후 무언가 작동하므로 NullPointerException이 일어나지 않는다.
		물론 생성자에 붙이는 것은 여지없이 에러가 난다.
	 */
	@PostConstruct
	private void init() {
		System.err.println("PostConstruct annotation으로 Test1Service빈이 완전히 생성된 후에 한 번 수행될 메서드에 붙입니다.");
	}

}
