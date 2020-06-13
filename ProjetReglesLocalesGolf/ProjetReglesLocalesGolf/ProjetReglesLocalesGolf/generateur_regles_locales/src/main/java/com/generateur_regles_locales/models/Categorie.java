package com.generateur_regles_locales.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public List<SousCategorie> getSousCategories() {
        return souscategories;
    }

    public void setSousCategories(List<SousCategorie> souscategories) {
        this.souscategories = souscategories;
    }

    @OneToMany (mappedBy = "categorie")//id de la categorie corespond a id de sous_categ
    private List<SousCategorie> souscategories= new ArrayList<SousCategorie>();

    public Categorie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
