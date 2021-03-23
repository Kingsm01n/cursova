package com.vlad.berezovskyi.itz01.sport.service.impl;

import com.vlad.berezovskyi.itz01.sport.controller.UserController;
import com.vlad.berezovskyi.itz01.sport.dao.UserDao;
import com.vlad.berezovskyi.itz01.sport.model.User;
import com.vlad.berezovskyi.itz01.sport.model.enums.Role;
import com.vlad.berezovskyi.itz01.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public String registerUser(User user) {
        if(dao.findByLogin(user.getLogin()) != null) {
            return "errorRegistration";
        } else {
            dao.save(user);
            return "successRegistration";
        }
    }

    @Override
    public String login(User user, HttpSession session) {
        User registeredUser = dao.findByLogin(user.getLogin());

        if(registeredUser == null){
            return "unregistered";
        }

        if (registeredUser.getPassword().equals(user.getPassword())){
            if(registeredUser.getRole().equals(Role.ADMIN)){
                session.setMaxInactiveInterval(600);
                session.setAttribute("role", Role.ADMIN);
                return "adminMain";
            } else {
                session.setMaxInactiveInterval(600);
                session.setAttribute("role", Role.USER);
                return "userMain";
            }
        } else {
            return "errorPassword";
        }
    }
}
