package com.mappingbasics.basesmapping.dao;

import com.mappingbasics.basesmapping.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player,Integer> {
    Player findByPlayerName(String name);
}
