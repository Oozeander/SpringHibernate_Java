package com.oozeander.model.mapping;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "teachers")
@Entity @Table(name = "students", schema = "default_schema",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id"})})
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @Column(name = "student_id", 
		unique = true) private Long id;

	// One To One Unidirectional
	@NonNull
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,
		mappedBy = "student") private Identity identity;
	// One To Many
	@NonNull
	@ToString.Exclude
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,
		mappedBy = "student")
	private List<Skill> skills;
	// Many To Many
	@NonNull
	@ToString.Exclude
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,
		mappedBy = "students")
	private Set<Professor> teachers;
}