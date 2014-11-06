package com.actionbazaar.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {

	private static final long serialVersionUID = 1625715670889251335L;

	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long itemId;

	private String itemName;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date bidEndDate;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date bidStartDate;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;

	private Double initialPrice;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<Bid> bids;

	public Item() {
	}

	public Item(Long itemId) {
		this.itemId = itemId;
	}

	public Item(String itemName, Date bidStartDate, Date createdDate,
			double initialPrice) {
		this.itemName = itemName;
		this.bidStartDate = bidStartDate;
		this.initialPrice = initialPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		return bid;
	}
}
