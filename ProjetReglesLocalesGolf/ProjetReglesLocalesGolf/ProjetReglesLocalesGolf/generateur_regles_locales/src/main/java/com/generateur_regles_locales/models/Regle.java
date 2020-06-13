package com.generateur_regles_locales.models;

import javax.persistence.*;

@Entity
public class Regle {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numordre;
    private String title;
    @Column(length = 20000)
    private String corpus;
    @ManyToOne
    private SousCategorie souscategorie;

    public Regle() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumordre() {
        return numordre;
    }

    public void setNumordre(Integer ordre) {
        this.numordre = ordre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public void setSouscategorie(SousCategorie souscategorie) {
        this.souscategorie = souscategorie;
    }

    public SousCategorie getSouscategorie(SousCategorie souscatego) {
        return souscategorie;
    }
}
