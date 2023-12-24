package com.mappingbasics.basesmapping.dao;

import com.mappingbasics.basesmapping.model.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagDao extends JpaRepository<Bag,Integer> {
    Bag findByBagName(String name);
}
