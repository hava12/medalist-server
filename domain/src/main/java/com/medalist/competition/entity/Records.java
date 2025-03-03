package com.medalist.competition.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.medalist.user.entity.User;
import lombok.Getter;

@Entity(name = "records")
@Getter
public class Records {
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Competition competition;

	@Column
	private Integer ranking;

	@Column
	private Integer score;

	@Column
	private String comment;
}
