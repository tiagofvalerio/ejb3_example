package com.actionbazaar.persistence;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -6106444000526253345L;

	private Bidder bidder;

	private Item item;

	private Shipping shipping;

	private Billing billing;

	private OrderStatus orderStatus;

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public void setStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderStatus getStatus() {
		return orderStatus;
	}
}
