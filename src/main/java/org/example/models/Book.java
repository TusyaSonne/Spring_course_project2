package org.example.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {

    private int id;
    @NotEmpty(message = "Введите название")
    @Size(min = 1, max = 100, message = "Название должно быть от 1 до 100 символов")
    private String title;
    @NotEmpty(message = "Введите автора")
    @Size(min = 1, max = 100, message = "Имя автора может быть от 1 до 100 символов")
    private String author;

    @Max(value = 2024, message = "Год выпуска книги не может быть больше текущего")
    private int year;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book() {
    }
}
