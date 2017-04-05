package com.marketplace.spring.controllers;

import com.marketplace.spring.models.Criteria;
import com.marketplace.spring.models.User;
import com.marketplace.spring.views.entities.ViewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr_Vaniukov on 4/3/2017.
 */
@RestController
public class ShowItemsRestController {

    @Autowired
    HelperController helperController;

    @GetMapping("/items")
    List<ViewItem> getAllItems(HttpSession session){
        List<ViewItem>items=null;

        System.out.println(session.getAttribute("user"));

        if(session.getAttribute("searchParameters")!=null) {
            items = helperController.getViewItemsBySearchParameters((Criteria)session.getAttribute("searchParameters"));
        } else {
            items=helperController.getViewItems();
        }

        return items;
    }

    @GetMapping("/user")
    User getUser(HttpSession session){
        User user=(User)session.getAttribute("user");

        System.out.println(session.getAttribute("user"));

        return user;
    }

    @GetMapping("/criteria")
    Criteria getCriteria(HttpSession session){
        Criteria criteria=(Criteria)session.getAttribute("criteria");

        System.out.println(session.getAttribute("criteria"));

        return criteria;
    }
}
