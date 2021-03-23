package com.vlad.berezovskyi.itz01.sport.service;

import com.vlad.berezovskyi.itz01.sport.model.Tournament;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {

    String createTournament(Tournament tournament, String[] teamIds);

    String delete(Long id);

    String update(Tournament tournament, String resultTeam, String[] teamIds);
}
