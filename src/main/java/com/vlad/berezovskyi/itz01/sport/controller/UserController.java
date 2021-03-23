package com.vlad.berezovskyi.itz01.sport.controller;

import com.vlad.berezovskyi.itz01.sport.dao.TeamDao;
import com.vlad.berezovskyi.itz01.sport.dao.TournamentDao;
import com.vlad.berezovskyi.itz01.sport.model.Team;
import com.vlad.berezovskyi.itz01.sport.model.Tournament;
import com.vlad.berezovskyi.itz01.sport.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private HttpSession session;
    @Autowired
    private TournamentDao tournamentDao;
    @Autowired
    private TeamDao teamDao;

    @RequestMapping(value = "userMain", method = RequestMethod.GET)
    public String userMain(){
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            return "userMain";
        } else {
            return "unauthorized";
        }
    }
    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public String main(Model model) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            model.addAttribute("tournaments", tournamentDao.findAll());
            return "tournaments";
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/tournament/{id}", method = RequestMethod.GET)
    public String tournament(@PathVariable("id") Long id, Model model) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            Optional<Tournament> tournamentOpt = tournamentDao.findById(id);
            if (tournamentOpt.isPresent()) {
                Tournament tournament = tournamentOpt.get();
                model.addAttribute("tournament", tournament);
                model.addAttribute("teams", tournament.getTeams());
            } else {
                return "error";
            }
            return "tournament";
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/tournamentsByTeam", method = RequestMethod.GET)
    public String tournamentsByTeamName(@ModelAttribute("teamName") @RequestParam("teamName") String teamName, Model model) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            if (teamName.isEmpty()) {
                model.addAttribute("tournaments", tournamentDao.findAll());
                return "tournaments";
            } else {
                Team team = teamDao.findByName(teamName);
                List<Tournament> tournaments = tournamentDao.findAll()
                        .stream()
                        .filter(tournament -> tournament.getTeams().contains(team))
                        .collect(Collectors.toList());
                model.addAttribute("tournaments", tournaments);
                return "tournaments";
            }
        } else {
            return "unauthorized";
        }
    }
}
