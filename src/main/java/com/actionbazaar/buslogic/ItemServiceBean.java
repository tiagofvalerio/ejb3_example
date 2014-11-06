package com.actionbazaar.buslogic;

import com.actionbazaar.persistence.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ItemServiceBean implements ItemService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Item getItem(long itemId) {
		return entityManager.find(Item.class, itemId);
	}

	@Override
	public void createItem(Item item) {
		entityManager.persist(item);
	}

}
