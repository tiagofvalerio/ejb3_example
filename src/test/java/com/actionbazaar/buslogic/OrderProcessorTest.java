package com.actionbazaar.buslogic;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.api.Run;
import org.jboss.arquillian.api.RunModeType;
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
import com.actionbazaar.persistence.OrderStatus;
import com.actionbazaar.persistence.Shipping;
import com.actionbazaar.persistence.User;

@RunWith(Arquillian.class)
@Run(RunModeType.IN_CONTAINER)
public class OrderProcessorTest {

	@EJB
	private OrderProcessor orderProcessor;

	@EJB
	private ItemService itemService;

	@EJB
	private UserService userService;

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
						UserService.class, UserServiceBean.class, OrderStatus.class);
	}

	@Test
	public void testOrderProcessor() {
		Item item = new Item("Apple IIGS", new Date(), new Date(), 45.0f);
		itemService.createItem(item);
		Bidder bidder = new Bidder("John", "Wesley Powell", 1869l);
		userService.createUser(bidder);
		Long itemId = item.getItemId();
		Long userId = bidder.getBidderId();

		bidder = (Bidder) userService.getUser(userId);

		item = itemService.getItem(itemId);

		orderProcessor.setBidder(bidder);
		orderProcessor.setItem(item);

		List<Shipping> shippingChoices = orderProcessor.getShippingChoices();
		Assert.assertNotNull(shippingChoices);

		orderProcessor.setShipping(shippingChoices.get(0));

		List<Billing> billingChoices = orderProcessor.getBillingChoices();

		orderProcessor.setBilling(billingChoices.get(0));

		orderProcessor.placeOrder();
	}
}
