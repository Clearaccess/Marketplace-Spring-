package com.marketplace.spring.controllers;

import com.marketplace.spring.dao.BidDAO;
import com.marketplace.spring.dao.ItemDAO;
import com.marketplace.spring.dao.UserDAO;
import com.marketplace.spring.dao.oracleDAO.OracleBidDAO;
import com.marketplace.spring.dao.oracleDAO.OracleItemDAO;
import com.marketplace.spring.dao.oracleDAO.OracleUserDAO;
import com.marketplace.spring.models.Bid;
import com.marketplace.spring.models.Item;
import com.marketplace.spring.models.User;
import com.marketplace.spring.views.entities.ViewItem;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 2/10/2017.
 */

@Component
public class HelperController {
    private static UserDAO userDAO;
    private static ItemDAO itemDAO;
    private static BidDAO bidDAO;
    private static MainController mainController;

    private HelperController() {
        userDAO = new OracleUserDAO();
        itemDAO = new OracleItemDAO();
        bidDAO = new OracleBidDAO();
    }

    public synchronized static MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }

        return mainController;
    }

    public ArrayList<ViewItem> getViewItems() {
        ArrayList<ViewItem> viewItems = new ArrayList<ViewItem>();
        ArrayList<Item> items = itemDAO.getAll();

        for (Item item : items) {
            User seller = userDAO.getById(item.getSellerId());
            Bid bestBid = bidDAO.getBestBidByItemId(item.getItemId());
            User bidder = userDAO.getById(bestBid.getBidderId());
            ViewItem temp = new ViewItem(item, seller, bidder, bestBid);
            if (!isSellItem(temp)) {
                viewItems.add(temp);
            }
        }

        return viewItems;
    }

    public ArrayList<ViewItem> getViewItemsBySubstr(HttpServletRequest request) {

        int field = Integer.parseInt(request.getParameter("field"));
        String keyWord = request.getParameter("keyWord");
        ArrayList<ViewItem> viewItems = new ArrayList<ViewItem>();
        ArrayList<Item> items = itemDAO.getItemsBySubstr(field, keyWord);

        for (Item item : items) {
            User seller = userDAO.getById(item.getSellerId());
            Bid bestBid = bidDAO.getBestBidByItemId(item.getItemId());
            User bidder = userDAO.getById(bestBid.getBidderId());
            ViewItem temp = new ViewItem(item, seller, bidder, bestBid);
            if (!isSellItem(temp)) {
                viewItems.add(temp);
            }
        }


        return viewItems;
    }

    public boolean isLogin(HttpServletRequest request) {
        String login = request.getParameter("login").toLowerCase();
        return userDAO.getByLogin(login) != null;
    }

    public boolean isRegister(String login, String password) {
        User user = userDAO.getByLogin(login);
        return user.getPassword().equals(password);
    }

    public User getUserByLogin(String login) {
        return userDAO.getByLogin(login.toLowerCase());
    }

    public User register(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String billingAddress = request.getParameter("billingAddress");

        User newUser = new User();
        newUser.setLogin(login.toLowerCase());
        newUser.setPassword(password.toLowerCase());
        newUser.setFullName(fullName);
        newUser.setBillingAddress(billingAddress);

        long userId = userDAO.insert(newUser);

        newUser.setUserId(userId);

        return newUser;
    }

    public Item getItemById(HttpServletRequest request) {
        if (request.getParameter("itemId") == null || request.getParameter("itemId").isEmpty()) {
            return null;
        }
        long itemId = Long.parseLong(request.getParameter("itemId"));
        return itemDAO.getById(itemId);
    }

    public void createItem(HttpServletRequest request, HttpSession session) {
        Item item = fillItem(request, session);
        itemDAO.insert(item);
    }

    public void updateItem(HttpServletRequest request, HttpSession session) {
        Item item = fillItem(request, session);
        itemDAO.update(item);
    }

    public void makeBid(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");

        double bid = Double.parseDouble(request.getParameter("bid"));
        long itemId = Long.parseLong(request.getParameter("itemId"));
        long bidderId = user.getUserId();

        Bid newBid = new Bid();
        newBid.setBid(bid);
        newBid.setItemId(itemId);
        newBid.setBidderId(bidderId);

        bidDAO.insert(newBid);
    }

    public void buyItem(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        long itemId = Long.parseLong(request.getParameter("itemId"));
        Item item = itemDAO.getById(itemId);
        long bidderId = user.getUserId();

        Bid newBid = new Bid();
        newBid.setBid(item.getStartPrice());
        newBid.setItemId(itemId);
        newBid.setBidderId(bidderId);

        bidDAO.insert(newBid);
    }

    private Item fillItem(HttpServletRequest request, HttpSession session) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double startPrice = Double.parseDouble(request.getParameter("startPrice"));
        Item newItem = new Item();

        newItem.setTitle(title);
        if (description != null) {
            newItem.setDescription(description);
        }
        newItem.setStartPrice(startPrice);

        if (request.getParameter("buy") == null) {
            double bidIncrement = Double.parseDouble(request.getParameter("bidIncrement"));
            String[] hhAndM = request.getParameter("time").split(":");
            long time = Long.parseLong(hhAndM[0]) * 1000 * 60 * 60 + Long.parseLong(hhAndM[1]) * 1000 * 60;
            newItem.setBidIncrement(bidIncrement);
            newItem.setTimeLeft(time);
        } else {
            newItem.setBuyItNow(true);
        }

        if (!request.getParameter("itemId").isEmpty()) {
            long itemId = Long.parseLong(request.getParameter("itemId"));
            newItem.setItemId(itemId);
        }

        User user = (User) session.getAttribute("user");
        newItem.setSellerId(user.getUserId());
        newItem.setStartBiddingDate(new Date(System.currentTimeMillis()));

        return newItem;
    }

    private boolean isSellItem(ViewItem item) {
        return item.isBuyItNow() && item.getFullNameBidder() != null;
    }
}
