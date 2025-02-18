package com.medalist.user.service;

import org.springframework.stereotype.Service;
import com.medalist.entity.User;
import com.medalist.repository.UserJpaRepository;
import com.medalist.user.dto.command.UserCreateCommand;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserJpaRepository userJpaRepository;

	public String getUserName() {
		final User user = userJpaRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
		return user.getName();
	}

	public Void saveUser(UserCreateCommand command) {
		return null;
	}
}
