package com.medalist.competition.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medalist.competition.entity.Registration;

public interface RegistrationJpaRepository extends JpaRepository<Registration, Long> {
}