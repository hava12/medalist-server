package com.medalist.competition.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.medalist.competition.dto.param.CompetitionParam;
import com.medalist.competition.repositiry.CompetitionJpaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompetitionService {

	private final CompetitionJpaRepository competitionJpaRepository;

	@Transactional
	public CompetitionParam getCompetitions() {
		return competitionJpaRepository.findAll();
	}
}
