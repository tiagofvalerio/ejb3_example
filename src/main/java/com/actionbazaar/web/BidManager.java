package com.actionbazaar.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.actionbazaar.buslogic.BidService;
import com.actionbazaar.persistence.Bid;
import com.actionbazaar.persistence.Bidder;
import com.actionbazaar.persistence.Item;

@Named
@RequestScoped
public class BidManager {

    @Inject
    private BidService bidService;

    @Inject
    private Bidder user;

    @Inject
    private Item item;
    
    private Bid bid = new Bid();

    @Produces
    @Named
    @RequestScoped
    public Bid getBid() {
        return bid;
    }

    public String placeBid() {
        bid.setBidder(user);
        bid.setItem(item);
        return "confirm.xhtml";
    }
}
