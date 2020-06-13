package com.generateur_regles_locales.models;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long> {
    List<SousCategorie> findAllByCategorie(Categorie categorie);
}
