package com.medalist.competition.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medalist.competition.entity.Records;

public interface RecordsJpaRepository extends JpaRepository<Records, Long> {
}
