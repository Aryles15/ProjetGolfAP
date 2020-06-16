package com.generateur_regles_locales.configuration;

import com.generateur_regles_locales.service.JpaUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private JpaUserDetailsService jpaUserDetailsService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setUserDetailsService(JpaUserDetailsService jpaUserDetailsService){
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //important , chiffre le mot de asse dans la bdd obligatoire
    ///////////////////////////////////////////////////////
    //il est crypté dans un sens il hash le mp mais avec le hash on peu pas avoir le mp pour les haker
    //mp= mp user +sel

    // prend mp user ce mp user on rajoute le sel associe au mp aché on reaache
    // le sel + mp et on verifie si le resultat = resultat dans le bdd aché.

//AJOUTER JUSTE UN PAKAGE CONFIGURATION LE RESTE LIBRE


    @Override //ici on securise les routes
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()//on autorise certaine requette
                .antMatchers("/", "/categories","/home","/login","/regleselect").permitAll()//on autorise l uri /home a tout le monde .permitAll()==permis a tous
                //.antMatchers("/admin/**").hasAuthority("ADMIN") //** = nimporte quelle chemin a partir de /admin
                //quand on recise voir sa comme une exclusion d'uri, la on autorise tout a part /admin/**
                .antMatchers("/Admin/**").hasAuthority("ADMIN")
                .antMatchers("/Gestionnaire/**").hasAnyAuthority("GESTIONNAIRE","ADMIN")
                .antMatchers("/Editeur/**").hasAnyAuthority("EDITEUR","GESTIONNAIRE","ADMIN")

                //.antMatchers("/gestionnaire/**").hasAnyAuthority("ADMIN","GESTIONNAIRE")
                .anyRequest().permitAll()
                //.anyRequest().authenticated()//la on precise que quelque soit la requette on doit obligatoirement etre autentifié
                // au dessus on specifie des requette autorisé  .hasAuthority("ADMIN") et permitAll() a partir du moment quil y a /home
                .and()
                .formLogin()//le formulaire de login est diponible a l uri /login qui corespond a l'action dans le formulaire login dans le template
                .loginPage("/connexion")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/categories",true)
                .permitAll()//permet a tout le monde de se log .permitAll()= full autorisation , permit a tous
                .and()
                .logout()
                .logoutUrl("/deconnexion")
                .logoutSuccessUrl("/categories")
                .permitAll();//permet a tous de de logout sortie de co .
        //au moment de valider la co pour un user ===> en Php un atrribut dans le controleur userdateils
    }


    //imporant!!endessous
    //permet de parametre l objet qui va permettre de construire le sytseme dautentification
    //ici
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("a")
                .password(bCryptPasswordEncoder().encode("a"))
                .authorities("EDITEUR","HABILITATION_EDITEUR")
        ;////entre comentaire au dessus est la juste pour la partie dev, cette partie doit etre supprimer lorsquon livre lapplication.
        //jamais fournir en production ce genre de methode qui donne un acces facile au donnée .


        //auth.userDetailsService(jpaUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
        System.out.println("Password : "+bCryptPasswordEncoder().encode("passe"));
    }*/

}

