package com.marketplace.spring.controllers;

import com.marketplace.spring.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Aleksandr_Vaniukov on 3/13/2017.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {
    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */
    @RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/editItem", method = RequestMethod.GET)
    public String getEditItemPage(Model model) {
        return "editItem";
    }

    @RequestMapping(value = "/showItems", method = RequestMethod.GET)
    public String getShowItemsPage(Model model) {
        return "showItems";
    }

    @RequestMapping(value = "/showMyItems", method = RequestMethod.GET)
    public String getShowMyItemsPage(Model model) {
        return "showMyItems";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model) {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model) {
        return "register";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model) {
        return "showItems";
    }

    @RequestMapping(value = "/makeBind", method = RequestMethod.POST)
    public String setBid(Model model) {
        return "showItems";
    }

    @RequestMapping(value = "/buyItem", method = RequestMethod.POST)
    public String buyItem(Model model) {
        return "showItems";
    }

    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */

    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}
