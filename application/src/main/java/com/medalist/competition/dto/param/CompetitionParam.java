package com.medalist.competition.dto.param;

import java.time.LocalDateTime;
import com.medalist.enums.CompetitionCategory;
import com.medalist.enums.CompetitionStatus;

public record CompetitionParam (
	String name,
	CompetitionCategory category,
	String location,
	LocalDateTime startDatetime,
	LocalDateTime endDatetime,
	LocalDateTime registrationDeadLine,
	Long minParticipants,
	Long maxParticipants,
	CompetitionStatus status
) {
}
