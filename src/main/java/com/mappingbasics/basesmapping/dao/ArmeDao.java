package com.mappingbasics.basesmapping.dao;

import com.mappingbasics.basesmapping.model.Arme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmeDao extends JpaRepository<Arme,Integer> {
    Arme findByArmName(String name);
}
