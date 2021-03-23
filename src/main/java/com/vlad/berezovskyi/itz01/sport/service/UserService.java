package com.vlad.berezovskyi.itz01.sport.service;

import com.vlad.berezovskyi.itz01.sport.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface UserService {
    String registerUser(User user);

    String login(User user, HttpSession session);
}
