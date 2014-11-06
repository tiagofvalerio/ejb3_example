package com.actionbazaar.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "BIDS")
public class Bid {

	private Date bidDate;

	private Long bidId;

	private Double bidPrice;

	private Item item;

	private Bidder bidder;

	public Bid() {
	}

	public Bid(Bidder bidder, Item item, Double bidPrice) {
		this.item = item;
		this.bidder = bidder;
		this.bidPrice = bidPrice;
	}

	@Id
	@GeneratedValue
	@Column(name = "BID_ID")
	public Long getBidId() {
		return bidId;
	}

	@Temporal(javax.persistence.TemporalType.DATE)
	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public Double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne
	@JoinColumn(name = "BIDDER_ID", referencedColumnName = "USER_ID")
	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
}
