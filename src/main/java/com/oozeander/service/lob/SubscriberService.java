package com.oozeander.service.lob;

import com.oozeander.model.lob.Subscriber;

public interface SubscriberService {
	Subscriber get(Long id);

	void save(Subscriber subscriber);

	void setAvatar(Long id, String path);
}