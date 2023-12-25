package com.mappingbasics.basesmapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BasesMappingApplication{
    public static void main(String[] args) {
        SpringApplication.run(BasesMappingApplication.class, args);
    }

    /*@Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start(PlayerDao playerDao, RoleDao roleDao){
        return args -> {

            //tout les mots de passe des utilisateurs est en 1234
            Stream.of("Ali","toe","jean","piere")
                    .forEach(playerName->{
                        Player player=new Player();
                        player.setVie(100);
                        player.setUsername(playerName);
                        player.setPassword(passwordEncoder().encode("1234"));
                        player.setPlayerName(playerName);
                        playerDao.save(player);
                    });

            List<Player>playerList=playerDao.findAll();
            playerList.forEach(player -> {
               String playerRole=Math.random()*100>10?"USER":"ADMIN";
                Role role=new Role();
                role.setRoleName(playerRole);
                Role role1=roleDao.save(role);
                player.getRoles().add(role1);
                playerDao.save(player);
            });
        };
    }*/

}
