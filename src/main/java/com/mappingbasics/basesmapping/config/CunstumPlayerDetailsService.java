package com.mappingbasics.basesmapping.config;

import com.mappingbasics.basesmapping.dao.PlayerDao;
import com.mappingbasics.basesmapping.model.Player;
import com.mappingbasics.basesmapping.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CunstumPlayerDetailsService implements UserDetailsService {
    @Autowired
    private PlayerDao playerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player=playerDao.findByPlayerName(username);
        log.error("Nom de l'utlisateur trouvé en base de donnée!  "+player.getPlayerName());
         return  new User(player.getUsername(),player.getPassword(),authorities(player.getRoles()));
    }
    public List<GrantedAuthority>authorities(List<Role> roles){
        List<GrantedAuthority>authorities=new ArrayList<>();
        roles.forEach(role->authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));
        return  authorities;
    }
}
