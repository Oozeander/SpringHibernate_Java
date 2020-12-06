package com.oozeander.dao.embedded_attributeOverrides;

import com.oozeander.model.embedded_attributeOverrides.Gamer;
import com.oozeander.model.embedded_attributeOverrides.GamerId;

public interface GamerDao {
	Gamer get(GamerId gamerId);

	void save(Gamer gamer);
}