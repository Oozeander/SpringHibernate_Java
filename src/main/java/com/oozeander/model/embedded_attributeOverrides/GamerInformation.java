package com.oozeander.model.embedded_attributeOverrides;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GamerInformation {
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "owned_games", schema = "default_schema")
	private Set<String> ownedGames;
}