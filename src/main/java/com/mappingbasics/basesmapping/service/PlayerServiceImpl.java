package com.mappingbasics.basesmapping.service;

import com.mappingbasics.basesmapping.dao.ArmeDao;
import com.mappingbasics.basesmapping.dao.BagDao;
import com.mappingbasics.basesmapping.dao.PlayerDao;
import com.mappingbasics.basesmapping.exceptions.PlayerNotFoundExceprion;
import com.mappingbasics.basesmapping.model.Arme;
import com.mappingbasics.basesmapping.model.Bag;
import com.mappingbasics.basesmapping.model.Player;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Transactional
@Service
public class PlayerServiceImpl implements IMetier<Player,Integer> {

    private final PlayerDao playerDao;
    private final ArmeDao armeDao;
    private  final BagDao bagDao;

    public PlayerServiceImpl(PlayerDao playerDao, ArmeDao armeDao,BagDao bagDao){
        this.playerDao=playerDao;
        this.armeDao=armeDao;
        this.bagDao=bagDao;
    }
    /**
     * Ajouter un utilisateur de la base de donnée
     * @param player
     * @return
     */
    @Override
    public Player addEntitie(Player player) {
        return this.playerDao.save(player);
    }

    public  void addBagToPlayer(String bagName,String playerName){
        Bag bag=this.bagDao.findByBagName(bagName);
        Player player=playerDao.findByPlayerName(playerName);
        player.getBags().add(bag);
    }
    @Override
    public List<Player> getEntities() {
        return this.playerDao.findAll();
    }
    @Override
    public Player findEntitiesById(Integer playerId) {
        Optional<Player>optionalPlayer=playerDao.findById(playerId);
        return  optionalPlayer.orElse(null);
        //return this.playerDao.findById(playerId).orElseThrow(()->new NoSuchElementException("Ce player n'existe pas"));
    }
    @ApiOperation(value = "Supprimer un player")
    @Override
    public void deleteEntitie(Integer id) {
        Optional<Player>player=this.playerDao.findById(id);
        if(player.isEmpty())throw new PlayerNotFoundExceprion("Ce player est introuvable!!!!");
        this.playerDao.delete(player.get());
    }

    @Override
    public Player updateEntitie(Player player, Integer id) {
        Optional<Player>player1=this.playerDao.findById(id);
        if(player1.isEmpty())throw new PlayerNotFoundExceprion("ce player est invalide!!!");
        Player player2=player1.get();
        player2.setPlayerName(player.getPlayerName());
        player2.setVie(player.getVie());
        return this.playerDao.save(player2);
    }
}
