package com.generateur_regles_locales.models;

import com.generateur_regles_locales.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}

