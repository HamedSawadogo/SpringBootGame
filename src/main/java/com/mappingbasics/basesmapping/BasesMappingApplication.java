package com.mappingbasics.basesmapping;
import com.mappingbasics.basesmapping.dao.Obj1Dao;
import com.mappingbasics.basesmapping.dao.Obj2Dao;
import com.mappingbasics.basesmapping.model.Obj1;
import com.mappingbasics.basesmapping.model.Obj2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;


@SpringBootApplication
public class BasesMappingApplication{
    public static void main(String[] args) {
        SpringApplication.run(BasesMappingApplication.class, args);
    }
    @Transactional
    @Bean
    CommandLineRunner start(Obj1Dao obj1Dao, Obj2Dao obj2Dao){
        return args -> {
          /*
            Supprimer les elements associés
           Obj1 obj1=obj1Dao.findObj1ByValue("one");
            obj1Dao.deleteById(2);*/
          /*  Stream.of("one","two","three","for","five","six","seven","height","nine","ten")
                    .forEach(s -> {
                        Obj2 obj1=new Obj2();
                        obj1.setValue("**"+s);

                        obj2Dao.save(obj1);
                    });*/
        };
    }
}
