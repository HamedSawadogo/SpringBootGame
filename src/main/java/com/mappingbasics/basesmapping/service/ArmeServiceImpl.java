package com.mappingbasics.basesmapping.service;

import com.mappingbasics.basesmapping.dao.ArmeDao;
import com.mappingbasics.basesmapping.model.Arme;
import com.mappingbasics.basesmapping.model.Player;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class ArmeServiceImpl implements IMetier<Arme,Integer>{

    private ArmeDao armeDao;
    public ArmeServiceImpl(ArmeDao armeDao){
        this.armeDao=armeDao;
    }
    @Override
    public Arme addEntitie(Arme arme) {
        return this.armeDao.save(arme);
    }

    @Override
    public List<Arme> getEntities() {
        return this.armeDao.findAll();
    }

    @Override
    public Arme findEntitiesById(Integer id) {
        Optional<Arme>arme=armeDao.findById(id);
        return arme.orElse(null);
    }

    @Override
    public void deleteEntitie(Integer id) {

    }

    @Override
    public Arme updateEntitie(Arme arme, Integer id) {
        return null;
    }
}
