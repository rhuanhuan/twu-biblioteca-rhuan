package com.twu.biblioteca;


import java.util.Objects;

public class Book {
    private String name;
    private String year;
    private String author;
    private String status;

    public Book(String name, String year, String author) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.status = "Allowed";
    }

    public String getName() {
        return this.name;
    }
    public String getYear() {
        return this.year;
    }
    public String getAuthor() {
        return this.author;
    }

    public String getStatus() {
        return this.status;
    }

    public void changeStatus() {
        if (Objects.equals(this.status, "Allowed"))
                this.status = "Denied";
        else if (Objects.equals(this.status, "Denied"))
                this.status = "Allowed";
    }
}

