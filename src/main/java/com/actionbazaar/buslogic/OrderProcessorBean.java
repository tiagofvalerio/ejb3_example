package com.actionbazaar.buslogic;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.actionbazaar.persistence.Bidder;
import com.actionbazaar.persistence.Billing;
import com.actionbazaar.persistence.Item;
import com.actionbazaar.persistence.Order;
import com.actionbazaar.persistence.OrderStatus;
import com.actionbazaar.persistence.Shipping;

@Stateful
public class OrderProcessorBean implements OrderProcessor {

	private Bidder bidder;

	private Item item;

	private Shipping shipping;

	private List<Shipping> shippingChoices = new LinkedList<Shipping>();

	private Billing billing;

	private List<Billing> billingChoices = new LinkedList<Billing>();

	public OrderProcessorBean() {
		billingChoices.add(new Billing());
		shippingChoices.add(new Shipping());
	}

	@Override
	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
		this.shippingChoices = getShippingHistory(bidder);
		this.billingChoices = getBillingHistory(bidder);
	}

	@Override
	public void setItem(Item item) {
		this.item = item;
		this.shippingChoices = filterShippingChoices(shippingChoices, item);
		this.billingChoices = filterBillingChoices(billingChoices, item);
	}

	@Override
	public List<Shipping> getShippingChoices() {
		return shippingChoices;
	}

	@Override
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
		updateShippingHistory(bidder, shipping);
		shipping.setCost(calculateShippingCost(shipping, item));
	}

	@Override
	public Shipping getShipping() {
		return shipping;
	}

	@Override
	public List<Billing> getBillingChoices() {
		return billingChoices;
	}

	@Override
	public void setBilling(Billing billing) {
		this.billing = billing;
		updateBillingHistory(bidder, billing);
	}

	@Asynchronous
	@Remove
	@Override
	public void placeOrder() {
		Order order = new Order();
		order.setBidder(bidder);
		order.setItem(item);
		order.setShipping(shipping);
		order.setBilling(billing);
		try {
			bill(order);
			notifyBillingSuccess(order);
			order.setStatus(OrderStatus.COMPLETE);
		} catch (BillingException be) {
			notifyBillingFailure(be, order);
			order.setStatus(OrderStatus.BILLING_FAILED);
		} finally {
			saveOrder(order);
		}
	}

	@Override
	public List<Shipping> getShippingHistory(Bidder bidder) {
		List<Shipping> shippingHistory = new LinkedList<Shipping>();
		shippingHistory.add(new Shipping());
		return shippingHistory;
	}

	@Override
	public List<Billing> getBillingHistory(Bidder bidder) {
		List<Billing> history = new LinkedList<Billing>();
		history.add(new Billing());
		return history;
	}

	@Override
	public void updateBillingHistory(Bidder bidder, Billing billing) {
	}

	@Override
	public void bill(Order order) throws BillingException {
		throw new BillingException();
	}

	@Override
	public void notifyBillingSuccess(Order order) {
	}

	@Override
	public void saveOrder(Order order) {
	}

	@Override
	public void notifyBillingFailure(BillingException be, Order order) {
	}

	@Override
	public void updateShippingHistory(Bidder bidder, Shipping shipping) {
	}

	@Override
	public double calculateShippingCost(Shipping shipping, Item item) {
		return 0;
	}

	@Override
	public List<Shipping> filterShippingChoices(List<Shipping> shippingChoices,
			Item item) {
		return shippingChoices;
	}

	@Override
	public List<Billing> filterBillingChoices(List<Billing> billingChoices,
			Item item) {
		return billingChoices;
	}

	@Override
	public Bidder getBidder() {
		return bidder;
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public void setShippingChoices(List<Shipping> shippingChoices) {
		this.shippingChoices = shippingChoices;
	}

	@Override
	public void setBillingChoices(List<Billing> billingChoices) {
		this.billingChoices = billingChoices;
	}

	@Override
	public Billing getBilling() {
		return billing;
	}
}
