package com.mappingbasics.basesmapping.dao;

import com.mappingbasics.basesmapping.model.Obj1;
import com.mappingbasics.basesmapping.model.Obj2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Obj2Dao extends JpaRepository<Obj2,Integer> {
    Obj2 findObj2ByValue(String value);
}
