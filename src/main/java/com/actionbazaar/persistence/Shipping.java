package com.actionbazaar.persistence;

import java.io.Serializable;

public class Shipping implements Serializable {

	private static final long serialVersionUID = 8134562228864603701L;

	protected double cost;

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
}
