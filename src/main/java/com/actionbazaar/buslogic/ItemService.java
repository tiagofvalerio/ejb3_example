package com.actionbazaar.buslogic;

import com.actionbazaar.persistence.Item;
import javax.ejb.Local;

@Local
public interface ItemService {

	Item getItem(long itemId);

	public void createItem(Item item);
}
