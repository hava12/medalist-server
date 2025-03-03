package com.medalist.competition.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.medalist.enums.CompetitionCategory;
import com.medalist.enums.CompetitionStatus;
import com.medalist.records.Location;
import lombok.Getter;

@Entity(name="competition")
@Getter
public class Competition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private CompetitionCategory category;

	@Column(name = "location")
	private String location;

	@Column(name = "start_date")
	private LocalDateTime startDatetime;

	@Column(name = "end_date")
	private LocalDateTime endDatetime;

	@Column(name = "registration_deadline")
	private LocalDateTime registrationDeadline;

	@Column(name = "min_participants")
	private Long minParticipants;

	@Column(name = "max_participants")
	private Long maxParticipants;

	@Column(name = "status")
	private CompetitionStatus status;
}
