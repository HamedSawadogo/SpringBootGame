package com.mappingbasics.basesmapping.service;

import com.mappingbasics.basesmapping.dao.BagDao;
import com.mappingbasics.basesmapping.model.Bag;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BagImpl implements IMetier<Bag,Integer>{

    private BagDao bagDao;

    public BagImpl(BagDao bagDao){
        this.bagDao=bagDao;
    }
    @Override
    public Bag addEntitie(Bag bag) {
        return this.bagDao.save(bag);
    }
    @Override
    public List<Bag> getEntities() {
        return this.bagDao.findAll();
    }
    
    @Override
    public Bag findEntitiesById(Integer id) {
        return this.bagDao.findById(id).orElseThrow(()->new RuntimeException("le sac est invalide"));
    }

    @Override
    public void deleteEntitie(Integer id) {

    }

    @Override
    public Bag updateEntitie(Bag bag, Integer id) {
        return null;
    }
}
