package com.medalist.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.medalist.user.service.UserService;
import com.medalist.user.dto.request.UserCreateRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<String> getUserNames() {
		return ResponseEntity
			.ok(userService.getUserName());
	}

	@PostMapping
	public ResponseEntity<Void> postUser(@RequestBody UserCreateRequest request) {
		return ResponseEntity
			.ok(userService.saveUser(request.toCommand()));
	}
}