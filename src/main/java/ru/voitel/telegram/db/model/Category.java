package ru.voitel.telegram.db.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "category")
@DynamicUpdate
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "id_user")
    public BigInteger idUser;

    @Column(name = "name_category")
    public String nameCategory;

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public String getNameCategory() {
        return nameCategory;
    }
}
