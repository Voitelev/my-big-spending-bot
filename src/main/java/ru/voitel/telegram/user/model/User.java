package ru.voitel.telegram.user.model;

/**
 * Модель пользователя
 */
public class User {
    
    private int id;

    private String name;

    private Long idUser;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
