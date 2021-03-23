package com.vlad.berezovskyi.itz01.sport.dao;

import com.vlad.berezovskyi.itz01.sport.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentDao extends JpaRepository<Tournament, Long> {

    Tournament findByName(String name);

}
