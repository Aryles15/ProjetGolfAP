package com.generateur_regles_locales.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Projet thyme-security
 * Pour LAERCE SAS
 * <p>
 * Créé le  21/03/2017.
 *
 * @author fred
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    private String name;
    private String password;
    private boolean active;
    private String mail;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="USER_HABILITATION",
            joinColumns =@JoinColumn(name = "ID_USER", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_HABILITATION", referencedColumnName = "ID"))
    private Set<Habilitation> habilitation;

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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public Set<Habilitation> getHabilitation() {
        return habilitation;
    }

    public void setHabilitation(Set<Habilitation> groups) {
        this.habilitation = habilitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, active, mail);
    }

}

