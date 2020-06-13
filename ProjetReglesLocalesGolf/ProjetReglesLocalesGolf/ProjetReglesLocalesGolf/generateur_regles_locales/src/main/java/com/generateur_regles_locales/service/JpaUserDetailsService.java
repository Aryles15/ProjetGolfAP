package com.generateur_regles_locales.service;

import com.generateur_regles_locales.models.Habilitation;
import com.generateur_regles_locales.models.HabilitationRepository;
import com.generateur_regles_locales.models.UserRepository;
import com.generateur_regles_locales.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    //websecurityconfig //table user/et /roles / template logging (AUtre nom possible), ne pas changez le mot password et email dans le form
//
    private UserRepository userRepository;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setUserDao(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        log.info("Recherche utilisateur: "+username);
        if(user == null){
            throw new UsernameNotFoundException("Utilisateur introuvable : |"+username+"|");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Habilitation habilitation: user.getHabilitation()){
            log.info("{username: "+username+"| habilitation: "+habilitation.getHabilitation());
            authorities.add(new SimpleGrantedAuthority(habilitation.getHabilitation()));
        }
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //log.info("Test pwd : "+encoder.encode("passe"));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                authorities);
    }
}

