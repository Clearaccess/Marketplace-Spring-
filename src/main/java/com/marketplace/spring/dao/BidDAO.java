package com.marketplace.spring.dao;

import com.marketplace.spring.models.Bid;

import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public interface BidDAO {
    long insert(Bid bid);
    void update(Bid bid);
    void delete(Bid bid);
    void deleteByItemID(long id);
    Bid getById(long id);
    ArrayList<Bid> getAll();
    ArrayList<Bid> getAllByItemId(long id);
    public Bid getBestBidByItemId(long id);
}
