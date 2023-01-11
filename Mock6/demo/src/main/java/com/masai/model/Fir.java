package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fir {

	private String crimeDetail;
	private LocalDateTime localDateTime;
	private String policeStation;
	
	@OneToMany
	@JoinColumn(name="id")
	private User user;
}
