package com.oozeander.model.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "student")
@Entity @Table(name = "skills", schema = "default_schema",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"skill_id"})})
public class Skill {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @Column(name = "skill_id", unique = true,
		nullable = false) private Long id;
	@NonNull
	private String name;
	@NonNull
	private Integer mark;

	// Many To One
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Student student;
}