package com.vlad.berezovskyi.itz01.sport.dao;

import com.vlad.berezovskyi.itz01.sport.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDao extends JpaRepository<Result, Long> {
}
