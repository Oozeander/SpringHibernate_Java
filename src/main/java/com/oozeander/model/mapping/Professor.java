package com.oozeander.model.mapping;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@EqualsAndHashCode(exclude = { "students" })
@Entity @Table(name = "teachers", schema = "default_schema",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"professor_id"})})
public class Professor {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @Column(name = "professor_id", unique = true,
		nullable = false) private Long id;
	@NonNull
	private String course;

	// Many to Many
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_teachers_join_table", schema = "default_schema",
		joinColumns = {@JoinColumn(name = "professor_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "student_id")})
	private Set<Student> students;
}