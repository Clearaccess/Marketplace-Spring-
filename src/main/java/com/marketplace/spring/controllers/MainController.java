package com.marketplace.spring.controllers;

import com.marketplace.spring.models.Item;
import com.marketplace.spring.models.User;
import com.marketplace.spring.views.entities.ViewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 3/13/2017.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    HelperController helperController;

    @RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/editItem", method = RequestMethod.GET)
    public String getEditItemPage(Model model, HttpServletRequest req) {
        Item item = helperController.getItemById(req);
        if (item != null) {
            model.addAttribute("item",item);
        }

        return "editItem";
    }

    @RequestMapping(value = "/showItems", method = RequestMethod.GET)
    public String getShowItemsPage(Model model, HttpServletRequest request) {
        ArrayList<ViewItem>items=helperController.getViewItems();
        System.out.println(items.size());
        model.addAttribute("items",items);
        return "showItems";
    }

    @RequestMapping(value = "/showMyItems", method = RequestMethod.GET)
    public String getShowMyItemsPage(Model model) {
        return "showMyItems";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getItemsBySearchPage(Model model, HttpServletRequest req) {
        ArrayList<ViewItem>items=helperController.getViewItemsBySubstr(req);
        model.addAttribute("items", items);
        return "showItems";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model) {
        return "showItems";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        if(helperController.isLogin(req)){
            model.addAttribute("error","Such login already exist");
            return "registration";
        } else {
            User user=helperController.register(req,resp);
            session.setAttribute("user",user);
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, HttpServletRequest req, HttpSession session) {
        if(req.getParameter("itemId").isEmpty()){
            helperController.createItem(req,session);
        } else {
            helperController.updateItem(req,session);
        }

        return "redirect:showItems";
    }

    @RequestMapping(value = "/makeBid", method = RequestMethod.POST)
    public String setBid(Model model, HttpServletRequest req, HttpSession session) {
        helperController.makeBid(req,session);
        return "redirect:showItems";
    }

    @RequestMapping(value = "/buyItem", method = RequestMethod.POST)
    public String buyItem(Model model, HttpServletRequest req, HttpSession session) {
        helperController.buyItem(req,session);
        return "redirect:showItems";
    }
}
