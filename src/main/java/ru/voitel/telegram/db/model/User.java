package ru.voitel.telegram.db.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "USER", schema = "sending")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "chatid")
    public Long chatId;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getChatId() {
        return chatId;
    }
}
