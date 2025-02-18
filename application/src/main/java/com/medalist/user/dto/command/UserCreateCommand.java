package com.medalist.user.dto.command;

import lombok.Builder;

@Builder
public record UserCreateCommand(
	String email,
	String mobileNumber
) {
}
