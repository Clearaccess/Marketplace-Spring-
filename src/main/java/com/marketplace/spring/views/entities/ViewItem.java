package com.marketplace.spring.views.entities;

import com.marketplace.spring.models.Bid;
import com.marketplace.spring.models.Item;
import com.marketplace.spring.models.User;

import java.sql.Date;
import java.util.Formatter;

/**
 * Created by Aleksandr_Vaniukov on 2/12/2017.
 */
public class ViewItem {

    private Item item;
    private User seller;
    private User bidder;
    private Bid bestBid;
    private Formatter fmt;
    private Date stopDate;

    public ViewItem(Item item, User seller, User bidder, Bid bestBid){
        this.item=item;
        this.seller=seller;
        this.bidder=bidder;
        this.bestBid=bestBid;
        this.fmt=new Formatter();
        this.stopDate=new Date(item.getStartBiddingDate().getTime()+item.getTimeLeft());
    }

    public long getItemId() {
        return item.getItemId();
    }

    public long getSellerId() {
        return item.getSellerId();
    }

    public String getTitle() {
        return item.getTitle();
    }

    // The method can return NULL
    public String getDescription() {
        return item.getDescription();
    }

    public String getFullNameSeller(){
        return seller.getFullName();
    }

    public double getStartPrice() {
        return item.getStartPrice();
    }

    //The method can return incorrect value, 0.0
    public double getBidIncrement() {
        return item.getBidIncrement();
    }

    public double getBestOffer(){
        return bestBid!=null?bestBid.getBid(): 0.0;
    }

    public String getFullNameBidder(){
        return bidder!=null? bidder.getFullName(): null;
    }

    public String getStopDate(){
        fmt.format("%td.%tm.%tY %tr",stopDate,stopDate,stopDate,stopDate);
        return fmt.toString();
    }

    public long getTimeLeft() {
        return item.getTimeLeft();
    }

    public Date getStartBiddingDate() {
        return item.getStartBiddingDate();
    }

    public boolean isBuyItNow() {
        return item.isBuyItNow();
    }
}
