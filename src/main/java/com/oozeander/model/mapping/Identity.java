package com.oozeander.model.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@EqualsAndHashCode(exclude = { "student" })
@Entity @Table(name = "identities", schema = "default_schema", 
	uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_id"})})
public class Identity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @Column(name = "identity_id", unique = true,
		nullable = false) private Long id;
	@NonNull
	private String firstname, lastname;
	@NonNull
	private Integer age;

	// One To One
	@ToString.Exclude
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Student student;
}