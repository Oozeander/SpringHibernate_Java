package com.oozeander.dao.lob.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.lob.SubscriberDao;
import com.oozeander.model.lob.Avatar;
import com.oozeander.model.lob.Subscriber;

@Repository("subscriberDao")
public class SubscriberDaoImpl implements SubscriberDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Subscriber get(Long id) {
		return (Subscriber) sessionFactory.getCurrentSession().get(Subscriber.class, id);
	}

	@Override
	public void save(Subscriber subscriber) {
		sessionFactory.getCurrentSession().saveOrUpdate(subscriber);
	}

	@Override
	public void setAvatar(Long id, String path) {
		Avatar avatar = get(id).getAvatar();
		try {
			FileOutputStream outputStream = new FileOutputStream(new File(path + "\\" + avatar.getFileName()));
			outputStream.write(avatar.getFileData().getBytes(1L, (int) avatar.getFileData().length()));
			outputStream.close();
		} catch (IOException | SQLException ex) {
			System.out.println("Error in Avatar saving to file : " + ex.getLocalizedMessage());
		}
	}
}