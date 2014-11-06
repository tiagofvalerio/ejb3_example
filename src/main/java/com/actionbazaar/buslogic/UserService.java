package com.actionbazaar.buslogic;

import com.actionbazaar.persistence.Bidder;
import javax.ejb.Local;

@Local
public interface UserService {

	Bidder getUser(long userId);

	void createUser(Bidder bidder);

}
