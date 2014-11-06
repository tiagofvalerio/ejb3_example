package com.actionbazaar.buslogic;

import com.actionbazaar.persistence.Bidder;
import com.actionbazaar.persistence.Billing;
import com.actionbazaar.persistence.Item;
import com.actionbazaar.persistence.Order;
import com.actionbazaar.persistence.Shipping;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderProcessor {

	public void setBidder(Bidder bidder);

	public void setItem(Item item);

	public List<Shipping> getShippingChoices();

	public void setShipping(Shipping shipping);

	public Shipping getShipping();

	public List<Billing> getBillingChoices();

	public void setBilling(Billing billing);

	public void placeOrder();

	public List<Shipping> getShippingHistory(Bidder bidder);

	public List<Billing> getBillingHistory(Bidder bidder);

	public void updateBillingHistory(Bidder bidder, Billing billing);

	public void bill(Order order) throws BillingException;

	public void notifyBillingSuccess(Order order);

	public void saveOrder(Order order);

	public void notifyBillingFailure(BillingException be, Order order);

	public void updateShippingHistory(Bidder bidder, Shipping shipping);

	public double calculateShippingCost(Shipping shipping, Item item);

	public List<Shipping> filterShippingChoices(List<Shipping> shippingChoices,
			Item item);

	public List<Billing> filterBillingChoices(List<Billing> billingChoices,
			Item item);

	public Bidder getBidder();

	public Item getItem();

	public void setShippingChoices(List<Shipping> shippingChoices);

	public void setBillingChoices(List<Billing> billingChoices);

	public Billing getBilling();
}
