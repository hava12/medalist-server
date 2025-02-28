package controller;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import com.medalist.ChatAppApplication;
import com.medalist.chat.controller.ChatController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = ChatAppApplication.class)
public class WebSocketIntegrationTest {

	@LocalServerPort
	private int port;

	private WebSocketStompClient stompClient;
	private StompSession stompSession;

	@BeforeEach
	public void setUp() throws Exception {
		StandardWebSocketClient client = new StandardWebSocketClient();
		List<Transport> transports = List.of(new WebSocketTransport(client));
		SockJsClient sockJsClient = new SockJsClient(transports);

		stompClient = new WebSocketStompClient(sockJsClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());

		String url = "ws://localhost:" + port + "/ws-stomp";
		stompSession = stompClient
			.connectAsync(url, new StompSessionHandlerAdapter() {})
			.get(1, TimeUnit.SECONDS);
	}

	@Test
	public void testWebSocketCommunication() throws Exception {
		CountDownLatch latch = new CountDownLatch(1);
		stompSession.subscribe("/topic/greetings", new StompFrameHandler() {
			@Override
			public Type getPayloadType(StompHeaders headers) {
				return ChatController.GreetingMessage.class;
			}
			@Override
			public void handleFrame(StompHeaders headers, Object payload) {
				ChatController.GreetingMessage message = (ChatController.GreetingMessage) payload;
				System.out.println("Received: " + message.getContent());
				latch.countDown();
			}
		});

		// /app/hello로 메시지 전송
		stompSession.send("/app/hello", new ChatController.HelloMessage("TestUser"));

		// 메시지가 수신될 때까지 대기
		assertTrue(latch.await(5, TimeUnit.SECONDS));
	}
}
