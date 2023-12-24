package com.mappingbasics.basesmapping.dao;

import com.mappingbasics.basesmapping.model.Obj1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Obj1Dao  extends JpaRepository<Obj1,Integer> {
    Obj1 findObj1ByValue(String value);
}
