package com.vlad.berezovskyi.itz01.sport.controller;

import com.vlad.berezovskyi.itz01.sport.dao.TeamDao;
import com.vlad.berezovskyi.itz01.sport.dao.TournamentDao;
import com.vlad.berezovskyi.itz01.sport.dao.UserDao;
import com.vlad.berezovskyi.itz01.sport.model.Team;
import com.vlad.berezovskyi.itz01.sport.model.Tournament;
import com.vlad.berezovskyi.itz01.sport.model.enums.Role;
import com.vlad.berezovskyi.itz01.sport.service.TeamService;
import com.vlad.berezovskyi.itz01.sport.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    @Autowired
    private HttpSession session;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private TournamentDao tournamentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TeamDao teamDao;

    @RequestMapping(value = "/adminMain")
    public String main() {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            return "adminMain";
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/createTeam", method = RequestMethod.GET)
    public String createTeam(Model model) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            model.addAttribute("users", userDao.findAll().stream().filter(user -> user.getRole().equals(Role.USER)).collect(Collectors.toList()));
            return "createTeam";
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/teamCreatedProcess", method = RequestMethod.POST)
    public String createTeamProcess(@ModelAttribute("team") Team team, HttpServletRequest request) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            return teamService.createTeam(team, request.getParameterValues("userId"));
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/createTournament", method = RequestMethod.GET)
    public String createTournament(Model model){
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            model.addAttribute("teams", teamDao.findAll());
            return "createTournament";
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/tournamentCreatedProcess", method = RequestMethod.POST)
    public String tournamentCreatedProcess(@ModelAttribute("tournament")Tournament tournament, HttpServletRequest request) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            return tournamentService.createTournament(tournament, request.getParameterValues("teamId"));
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/editTournaments", method = RequestMethod.GET)
    public String editTournaments(Model model){
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            model.addAttribute("tournaments", tournamentDao.findAll());
            return "editTournaments";
        } else {
            return "unauthorized";
        }
    }
    @RequestMapping(value = "/tournamentDelete/{tournamentId}", method = RequestMethod.DELETE)
    public String deleteTournament(@PathVariable("tournamentId") String id){
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            return tournamentService.delete(Long.valueOf(id));
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/tournamentEdit/{tournamentId}", method = RequestMethod.GET)
    public String editTournament(Model model, @PathVariable("tournamentId") String id){
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            if(tournamentDao.findById(Long.valueOf(id)).isPresent()) {
                Tournament tournament = tournamentDao.findById(Long.valueOf(id)).get();
                model.addAttribute("tournament", tournament);
                if(tournament.getResult() == null) {
                    model.addAttribute("teams", tournament.getTeams());
                } else {
                    model.addAttribute(
                            "teams",
                            tournament.getTeams()
                                    .stream()
                                    .filter(team -> !tournament.getResult().getWinner().equals(team))
                                    .collect(Collectors.toList())
                    );
                }
            } else {
                return "error";
            }
            return "editTournament";
        } else {
            return "unauthorized";
        }
    }

    @RequestMapping(value = "/editTournamentProcess", method = RequestMethod.POST)
    public String editTournamentProcess(@ModelAttribute("tournament")Tournament tournament, HttpServletRequest request) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            return tournamentService.update(tournament, request.getParameter("resultTeam"), request.getParameterValues("teamIds"));
        } else {
            return "unauthorized";
        }
    }
}
