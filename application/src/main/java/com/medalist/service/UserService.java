package com.medalist.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.medalist.entity.User;
import com.medalist.repository.UserJpaRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserJpaRepository userJpaRepository;

	public String getUserName() {
		final User user = userJpaRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
		System.out.println(user);
		return user.getName();
	}
}
