package com.vlad.berezovskyi.itz01.sport.service;

import com.vlad.berezovskyi.itz01.sport.model.Team;
import org.springframework.stereotype.Service;

@Service
public interface TeamService {

    String createTeam(Team team, String[] ids);

}
