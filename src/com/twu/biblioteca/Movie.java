package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private double rate;

    public Movie(String name,int year,String director,double rate){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public String getName(){
        return this.name;
    }

    public int getYear(){
        return this.year;
    }

    public String getDirector(){
        return this.director;
    }

    public double getRate(){
        return this.rate;
    }
}
