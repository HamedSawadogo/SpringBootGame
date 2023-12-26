package com.mappingbasics.basesmapping.controller;
import com.mappingbasics.basesmapping.controller.api.ApiConfig;
import com.mappingbasics.basesmapping.model.Player;
import com.mappingbasics.basesmapping.service.PlayerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Api(value = "API crud sur les opérations de Players",
        tags = "le controlleur qui permet de gerer les Joueurs")
@RequestMapping(value = ApiConfig.APP_ROUTE)
public class PlayerController {

    private final PlayerServiceImpl playerService;
    public  PlayerController(PlayerServiceImpl playerService){
        this.playerService=playerService;
    }

    @GetMapping("/admin")
    public StringBuilder adminPage(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("<h2>Welcomme!  Our Admin you</h2>");
        stringBuilder.append("<h3>You can make:  </h3>");
        stringBuilder.append("<ul>");
        stringBuilder.append("<li>add Player</li>");
        stringBuilder.append("<li>Delete Player</li>");
        stringBuilder.append("</ul>");
        return  stringBuilder;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public  ResponseEntity<?>  updatePlayer(@PathVariable("id")Integer id,@RequestBody Player player){
        try {
            Player player1=this.playerService.updateEntitie(player,id);
            return ResponseEntity.status(HttpStatus.OK).body(player1);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @RequestMapping(value ="/player/{id}",method =RequestMethod.GET)
    public Player findPlayerById(@PathVariable("id")Integer id){
        return this.playerService.findEntitiesById(id);
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public  ResponseEntity<String>deletePlaye(@PathVariable("id")Integer id){
        this.playerService.deleteEntitie(id);
        return ResponseEntity.status(HttpStatus.OK).body("Player supprimé avec success");
    }

    @ApiOperation(value = "Enregistrer un Joueur dans la base de donnée")
    @RequestMapping(value = "/saveplayer",method = RequestMethod.POST)
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player){
        Player player1=this.playerService.addEntitie(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(player1);
    }
    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public List<Player> getPlayers(){
       return this.playerService.getEntities();
    }
}
