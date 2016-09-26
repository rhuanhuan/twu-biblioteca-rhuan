package com.twu.biblioteca;


import java.util.Objects;

class Book {
    private String name;
    private String year;
    private String author;
    private String status;

    Book(String name, String year, String author) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.status = "Allowed";
    }

    String getName() {
        return this.name;
    }
    String getYear() {
        return this.year;
    }
    String getAuthor() {
        return this.author;
    }

    String getStatus() {
        return this.status;
    }

    void changeStatus() {
        if (Objects.equals(this.status, "Allowed"))
                this.status = "Denied";
        else if (Objects.equals(this.status, "Denied"))
                this.status = "Allowed";
    }
}

