package com.oozeander.model.lob;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "subscribers", schema = "default_schema",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"subscriber_id"})})
public class Subscriber {
	@Id@Column(name = "subscriber_id", unique = true,
		nullable = false) private Long id;
	
	private String firstname, lastname;
	@Embedded
	private Avatar avatar;
}