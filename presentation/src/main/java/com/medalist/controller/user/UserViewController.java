package com.medalist.controller.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserViewController {

	@GetMapping
	public ResponseEntity<List<String>> getUserNames() {
		return ResponseEntity
			.ok()
			.body(List.of("조동엽", "조동엽1"));
	}
}