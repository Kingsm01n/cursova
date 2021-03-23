package com.vlad.berezovskyi.itz01.sport.controller;

import com.vlad.berezovskyi.itz01.sport.model.User;
import com.vlad.berezovskyi.itz01.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController{

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelAndView model){
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = "processRegistration", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
        return userService.registerUser(user);
    }

    @RequestMapping(value = "processLogin", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute("user") User user, BindingResult result, ModelMap model){
        return userService.login(user, session);
    }
}
