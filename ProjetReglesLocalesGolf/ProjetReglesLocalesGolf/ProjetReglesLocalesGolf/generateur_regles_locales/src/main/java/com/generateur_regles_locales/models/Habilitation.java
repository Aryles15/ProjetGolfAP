package com.generateur_regles_locales.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "HABILITATION")
public class Habilitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    private String name;
    private String habilitation;
    @ManyToMany(mappedBy = "habilitation")
    private Set<User> users;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getHabilitation() {
        return habilitation;
    }

    public void setHabilitation(String role) {
        this.habilitation = habilitation;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilitation habilitation = (Habilitation) o;
        return id == habilitation.id &&
                Objects.equals(name, habilitation.name) &&
                Objects.equals(habilitation, habilitation.habilitation);
    }



    //permet d'eviter les doublons ..en lien (de paire avec la methode juste au desssus "equals(Object o)")
    //comparer la clef primaire "id" suffit, unique donc suffisant
    @Override
    public int hashCode() {
        return Objects.hash(id, name, habilitation);
    }

 */

}

