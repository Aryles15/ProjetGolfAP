package com.generateur_regles_locales.service;


import com.generateur_regles_locales.models.Habilitation;
import com.generateur_regles_locales.models.HabilitationRepository;
import com.generateur_regles_locales.models.UserRepository;
import com.generateur_regles_locales.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class JpaUserService {
    private UserRepository userRepository;
    private HabilitationRepository habilitationRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserDao(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setHabilitationRepository(HabilitationRepository habilitationRepository){
        this.habilitationRepository = habilitationRepository;
    }

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setHabilitation(new HashSet<>(habilitationRepository.findAll()));
        userRepository.save(user);
    }

    public User findByUserName(String userName){
        return userRepository.findByName(userName);
    }

}


