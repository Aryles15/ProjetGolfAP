package com.generateur_regles_locales.configuration;


import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


//permet de... rien du tout..... , utilisé dans les anciennes version de spring secu
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}

