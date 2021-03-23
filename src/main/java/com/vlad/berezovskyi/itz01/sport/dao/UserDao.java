package com.vlad.berezovskyi.itz01.sport.dao;

import com.vlad.berezovskyi.itz01.sport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
