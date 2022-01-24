package ru.voitel.telegram.db.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER", schema = "sending")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String name;

    @Column(name = "iduser")
    private Integer idUser;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getIdUser() {
        return idUser;
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
}
