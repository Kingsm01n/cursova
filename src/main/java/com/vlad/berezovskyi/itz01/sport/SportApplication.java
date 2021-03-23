package com.vlad.berezovskyi.itz01.sport;

import com.vlad.berezovskyi.itz01.sport.dao.UserDao;
import com.vlad.berezovskyi.itz01.sport.model.User;
import com.vlad.berezovskyi.itz01.sport.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportApplication {

//	@Autowired
//	private static UserDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SportApplication.class, args);

//		if(dao.findByLogin("admin") == null) {
//			User user = new User();
//			user.setId(1L);
//			user.setLogin("admin");
//			user.setPassword("admin");
//			user.setRole(Role.ADMIN);
//			dao.save(user);
//		}
	}

}
