package com.medalist.user.dto.request;

import com.medalist.user.dto.command.UserCreateCommand;
import lombok.Builder;

@Builder
public record UserCreateRequest(
	String email,
	String mobileNumber
) {
	public UserCreateCommand toCommand() {
		return UserCreateCommand.builder()
			.email(email)
			.mobileNumber(mobileNumber)
			.build();
	}
}
