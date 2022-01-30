package ru.voitel.telegram.db.model;

import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@Entity
@Table(name = "SENDING")
@DynamicUpdate
public class Sending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    @Column(name = "user_id")
    public Long UserId;

    @Column(name = "rate")
    public double rate;

    @Column(name = "id_category")
    public Long idCategory;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

}
