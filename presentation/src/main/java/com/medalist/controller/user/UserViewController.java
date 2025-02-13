package com.medalist.controller.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserViewController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<String>> getUserNames() {
		return ResponseEntity
			.ok()
			.body(List.of("조동엽", "조동엽1"));
	}
}