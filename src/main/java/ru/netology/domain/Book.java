package ru.netology.domain;

public class Book extends Product {
    private String author = "";

    public Book(int id, String name, String author) {
        this.setName(name);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
