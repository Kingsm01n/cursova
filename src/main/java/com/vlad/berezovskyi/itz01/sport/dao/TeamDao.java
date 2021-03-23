package com.vlad.berezovskyi.itz01.sport.dao;

import com.vlad.berezovskyi.itz01.sport.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Team, Long> {

    Team findByName(String name);

}
