package com.actionbazaar.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIDDERS")
public class Bidder extends User implements Serializable {

	private static final long serialVersionUID = 4042252616574798962L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long bidderId;

	private Long creditRating;

	public Bidder() {
	}

	public Bidder(String firstName, String lastName, Long creditRating) {
		super(firstName, lastName);
		this.creditRating = creditRating;
	}

	public Bidder(Long creditRating) {
		this.creditRating = creditRating;
	}

	public Long getBidderId() {
		return bidderId;
	}

	public Long getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Long creditRating) {
		this.creditRating = creditRating;
	}
}
