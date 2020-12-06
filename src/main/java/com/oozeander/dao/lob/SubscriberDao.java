package com.oozeander.dao.lob;

import com.oozeander.model.lob.Subscriber;

public interface SubscriberDao {
	Subscriber get(Long id);

	void save(Subscriber subscriber);

	void setAvatar(Long id, String path);
}