package com.mappingbasics.basesmapping.dao;

import com.mappingbasics.basesmapping.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player,Integer> {
    Player findByPlayerName(String name);

    @Query(value = "select p from Player  p where p.vie>:vie",nativeQuery = true)
    Player findPlayerByVies(@Param("vie")Integer vie);
}
