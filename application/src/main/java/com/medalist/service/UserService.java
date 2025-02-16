package com.medalist.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public List<String> getUser() {
		return List.of("조동엽 1", "조동엽 2");
	}
}
