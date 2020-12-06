package com.oozeander.service.embedded_attributeOverrides;

import com.oozeander.model.embedded_attributeOverrides.Gamer;
import com.oozeander.model.embedded_attributeOverrides.GamerId;

public interface GamerService {
	Gamer get(GamerId gamerId);

	void save(Gamer gamer);
}