package com.vlad.berezovskyi.itz01.sport.service.impl;

import com.vlad.berezovskyi.itz01.sport.dao.TeamDao;
import com.vlad.berezovskyi.itz01.sport.dao.UserDao;
import com.vlad.berezovskyi.itz01.sport.model.Team;
import com.vlad.berezovskyi.itz01.sport.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao dao;
    @Autowired
    private UserDao userDao;

    @Override
    public String createTeam(Team team, String[] ids) {
        Team teamFromDb = dao.findByName(team.getName());

        if(teamFromDb != null) {
            return "teamAlreadyCreated";
        } else {
            dao.save(team);

            for (String id : ids) {
                userDao.findById(Long.valueOf(id)).ifPresent(user -> {
                    team.getUsers().add(user);
                    user.setTeam(team);
                    userDao.save(user);
                });
            }
            return "teamCreated";
        }
    }
}
