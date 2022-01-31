package ru.voitel.telegram.db.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "sending")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String name;

    @Column(name = "iduser")
    private Integer idUser;

    @Column(name = "state_user")
    private Integer stateUser;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public int getStateUser() {
        return stateUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setStateUser(int stateUser) {
        this.stateUser = stateUser;
    }
}
