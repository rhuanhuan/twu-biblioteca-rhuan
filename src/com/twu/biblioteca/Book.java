package com.twu.biblioteca;


public class Book {
    private String name;
    private int year;
    private String author;
    private String status;

    public Book(String name, int year, String author, String status) {
        name = this.name;
        year = this.year;
        author = this.author;
        status = this.status;
    }

    public void  name(){
        name = this.name;
    }

    public void status(){
        status = this.status;
    }

    public void changeStatus(){
        if (this.status.equals("Allowed")){
            this.status = "Denied";
        }
        if (this.status.equals("Denied")){
            this.status = "Allowed";
        }
    }
}

