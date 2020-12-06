package com.oozeander.model.collection_enum_map;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.oozeander.model.mapping.Skill;

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
@EqualsAndHashCode(exclude = { "skills" })
@Entity @Table(name = "users", schema = "default_schema",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @Column(name = "user_id", unique = true,
		nullable = false) private Long id;
	
	@NonNull
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_emails", schema = "default_schema")
	private List<String> emails;

	@NonNull
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "skills")
	private List<Skill> skills;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NonNull
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "skill_and_marks", schema = "default_schema")
	@MapKeyColumn(name = "skill_name", length = 16)
	@Column(name = "skill_mark")
	private Map<String, Integer> skillAndMark;
}