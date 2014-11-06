package com.actionbazaar.buslogic;

import com.actionbazaar.persistence.Bidder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserServiceBean implements UserService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Bidder getUser(long userId) {
		return entityManager.find(Bidder.class, userId);
	}

	@Override
	public void createUser(Bidder bidder) {
		entityManager.persist(bidder);
	}
}
