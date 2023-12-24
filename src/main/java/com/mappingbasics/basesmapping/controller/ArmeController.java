package com.mappingbasics.basesmapping.controller;

import com.mappingbasics.basesmapping.controller.api.ApiConfig;
import com.mappingbasics.basesmapping.model.Arme;
import com.mappingbasics.basesmapping.service.ArmeServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = ApiConfig.APP_ROUTE)
public class ArmeController {

    @Autowired
    private ArmeServiceImpl armeService;

    @GetMapping("/armes")
   public ResponseEntity<List<Arme>> getAlls(){
        return  ResponseEntity.ok().body(armeService.getEntities());
    }
}
