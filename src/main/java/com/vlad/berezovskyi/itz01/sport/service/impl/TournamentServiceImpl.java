package com.vlad.berezovskyi.itz01.sport.service.impl;

import com.vlad.berezovskyi.itz01.sport.dao.ResultDao;
import com.vlad.berezovskyi.itz01.sport.dao.TeamDao;
import com.vlad.berezovskyi.itz01.sport.dao.TournamentDao;
import com.vlad.berezovskyi.itz01.sport.model.Result;
import com.vlad.berezovskyi.itz01.sport.model.Team;
import com.vlad.berezovskyi.itz01.sport.model.Tournament;
import com.vlad.berezovskyi.itz01.sport.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentDao tournamentDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private ResultDao resultDao;

    @Override
    public String createTournament(Tournament tournament, String[] teamIds) {
        Tournament tournamentFromDb = tournamentDao.findByName(tournament.getName());

        if(tournamentFromDb == null) {
            List<Team> teams = new ArrayList<>();
            for (String teamId : teamIds) {
                teamDao.findById(Long.valueOf(teamId)).ifPresent(teams::add);
            }

            tournament.setTeams(teams);
            tournamentDao.save(tournament);
            return "tournamentCreated";
        } else {
            return "tournamentAlreadyCreated";
        }
    }

    @Override
    public String delete(Long id) {
        try {
            tournamentDao.delete(tournamentDao.findById(id).get());
            return "editTournaments";
        } catch (Exception e) {
            return "error";
        }
    }

    @Override
    public String update(Tournament tournament, String resultTeam, String[] teamIds) {
        try {
            List<Team> teams = new ArrayList<>();
            for (String teamId : teamIds) {
                teamDao.findById(Long.valueOf(teamId)).ifPresent(teams::add);
            }
            tournament.setTeams(teams);
            if (!resultTeam.isEmpty()) {
                teamDao.findById(Long.valueOf(resultTeam)).ifPresent(team -> {
                    Result result = new Result();
                    result.setTournament(tournament);
                    result.setWinner(team);
                    resultDao.save(result);
                    tournament.setResult(result);
                });
            }
            tournamentDao.save(tournament);
            return "edited";
        } catch (Exception e) {
            return "adminMain";
        }
    }
}
