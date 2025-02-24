package com.medalist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	/**
	 * 메세지 브로커 구성
	 * /topic, /queue 등 엔드포인트로 메시지를 받아보려면 enableSimpleBroker()로 등록
	 * 클라이언트 → 서버로 보낼 때는 /app/... 로 시작
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// /topic/... 으로 시작하는 경로를 메모리 기반의 SimpleBroker 로 처리
		config.enableSimpleBroker("/topic");

		// 클라이언트에서 보낼 메시지 앞에 /app/... 를 붙이도록 설정
		config.setApplicationDestinationPrefixes("/app");
	}

	/**
	 * STOMP endpoint 등록
	 * 웹소켓 연결 endpoint: /ws-stomp
	 * SockJS fallback 지원
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// JavaScript에서 new SockJS("/ws-stomp") 로 연결
		registry.addEndpoint("/ws-stomp")
			.setAllowedOrigins("*")   // CORS 허용 범위 설정
			.withSockJS();
	}
}
