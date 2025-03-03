package com.medalist.competition.dto.request;

import java.time.LocalDateTime;
import com.medalist.enums.CompetitionCategory;
import com.medalist.enums.CompetitionStatus;

public record CompetitionRequest(
	String name,
	CompetitionCategory category,
	String location,
	LocalDateTime startDateTime,
	LocalDateTime endDateTime,
	LocalDateTime registrationDeadline,
	Long minParticipants,
	Long maxParticipants,
	CompetitionStatus status
) {
}
