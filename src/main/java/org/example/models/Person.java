package org.example.models;

import jakarta.validation.constraints.*;

public class Person {

    private int id;


    @NotEmpty(message = "ФИО не может быть пустым")
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+", message = "Введите корректное ФИО (Иванов Иван Иванович")
    private String fullname;

    //@NotEmpty(message = "Введите год рождения")
    @Min(value = 1900, message = "Год рождения не может быть позже 20 века")
    @Max(value = 2024, message = "Год рождения не может быть раньше 2024 года")
    private int birthyear;

    public Person(int id, String fullname, int birthyear) {
        this.id = id;
        this.fullname = fullname;
        this.birthyear = birthyear;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }
}
