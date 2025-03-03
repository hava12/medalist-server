package com.medalist.competition.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medalist.competition.entity.Competition;

public interface CompetitionJpaRepository extends JpaRepository<Competition, Long> {
}
