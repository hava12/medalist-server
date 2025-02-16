package com.medalist.controller.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.medalist.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserViewController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<String>> getUserNames() {
		return ResponseEntity
			.ok()
			.body(userService.getUser());
	}
}