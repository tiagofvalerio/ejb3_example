package com.actionbazaar.buslogic;

import javax.inject.Inject;

import org.jboss.arquillian.api.Run;
import org.jboss.arquillian.api.RunModeType;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.actionbazaar.persistence.Bid;
import com.actionbazaar.persistence.Bidder;
import com.actionbazaar.persistence.Billing;
import com.actionbazaar.persistence.Item;
import com.actionbazaar.persistence.Order;
import com.actionbazaar.persistence.Shipping;
import com.actionbazaar.persistence.User;

@RunWith(Arquillian.class)
@Run(RunModeType.IN_CONTAINER)
public class UserServiceTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml")
				.addClasses(OrderProcessor.class, OrderProcessorBean.class,
						ItemService.class, ItemServiceBean.class, Bid.class,
						Bidder.class, Item.class, BillingException.class,
						User.class, Shipping.class, Billing.class, Order.class,
						UserService.class, UserServiceBean.class);
	}

	@Inject
	private UserService userService;

	@Test
	public void testItemPersistence() {
		Bidder bidder = new Bidder("John", "Wesley Powell", 1869l);
		userService.createUser(bidder);
		Assert.assertNotNull(bidder.getBidderId());
		Assert.assertNotNull(userService.getUser(bidder.getBidderId()));
	}
}
