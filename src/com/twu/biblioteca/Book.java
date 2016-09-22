package com.twu.biblioteca;


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
        switch (this.status){
            case "Allowed":
                this.status = "Denied";
            case "Denied":
                this.status = "Allowed";
        }
    }
}

