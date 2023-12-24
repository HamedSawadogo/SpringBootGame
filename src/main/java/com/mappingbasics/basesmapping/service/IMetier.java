package com.mappingbasics.basesmapping.service;

import com.mappingbasics.basesmapping.model.Player;

import java.util.List;

public interface IMetier<E,T> {
    E addEntitie(E e);
    List<E>getEntities();
    E findEntitiesById(T id);
    void deleteEntitie(T id);
    E updateEntitie(E e,T id);
}
