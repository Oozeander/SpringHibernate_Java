package com.oozeander.model.embedded_attributeOverrides;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "gamers", schema = "default_schema")
public class Gamer {
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "gamer_id")),
		@AttributeOverride(name = "username", column = @Column(name = "gamer_username")),
		@AttributeOverride(name = "password", column = @Column(name = "gamer_password"))
	}) private GamerId id;
	@Embedded
	private GamerInformation information;
}