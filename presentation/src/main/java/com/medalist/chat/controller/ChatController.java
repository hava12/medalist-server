package com.medalist.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public GreetingMessage greeting(HelloMessage message) {
		return new GreetingMessage("Hello," + message.getName() + "!");
	}

	// DTO 클래스들
	public static class HelloMessage {
		private String name;
		// 기본 생성자, getter, setter
		public HelloMessage() {}
		public HelloMessage(String name) { this.name = name; }
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
	}

	public static class GreetingMessage {
		private String content;
		public GreetingMessage() {}
		public GreetingMessage(String content) { this.content = content; }
		public String getContent() { return content; }
		public void setContent(String content) { this.content = content; }
	}
}
