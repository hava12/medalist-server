package com.medalist.competition.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medalist.competition.dto.request.CompetitionRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/competition")
public class CompetitionController {

	@GetMapping
	public ResponseEntity<String> getCompetitionList() {

		return ResponseEntity
			.ok("");
	}

	@PostMapping
	public ResponseEntity<Void> createCompetition(@RequestBody CompetitionRequest request) {

		return ResponseEntity.ok(null);
	}
}
