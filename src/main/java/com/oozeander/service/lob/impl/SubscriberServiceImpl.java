package com.oozeander.service.lob.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.lob.SubscriberDao;
import com.oozeander.model.lob.Subscriber;
import com.oozeander.service.lob.SubscriberService;

@Service("subscriberService")
@Transactional
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private SubscriberDao subscriberDao;

	@Override
	public Subscriber get(Long id) {
		return subscriberDao.get(id);
	}

	@Override
	public void save(Subscriber subscriber) {
		subscriberDao.save(subscriber);
	}

	@Override
	public void setAvatar(Long id, String path) {
		subscriberDao.setAvatar(id, path);
	}
}