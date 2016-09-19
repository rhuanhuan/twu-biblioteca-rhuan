package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private String[] bookMessage ={ "name: Rails之道, year: 2000, author: (美)Obie Fernandez",
            "name: Programming Ruby中文版, year: 2000, author: 托马斯",
            "name: Ruby编程语言,year: 2000, author: 松本行弘",
            "name: Ruby for Rails中文版,year: 2000, author: David Black",
            "name: Java Enterprise最佳实践,year: 2000, author: The OReilly Java Authors",
            "name: Java应用程序设计接口(下册)--窗口工具箱和applet,year: 2000, author: (美)James Gosling,Frank Yellin,Java 小组",
            "name: Java编程思想 （第4版）, year: 2000, author: [美] Bruce Eckel",
            "name: Effective java 中文版（第2版）, year: 2000, author: Joshua Bloch",
            "name: 满月之夜白鲸现,year: 2000, author: 片山恭一,豫人",
            "name: 塔希里亚故事集,year: 2000, author: 吴淼",
            "name: 幻城,year: 2000, author: 郭敬明",
            "name: 冰与火之歌（卷一）,year: 2000, author: [美] 乔治·R. R. 马丁",
            "name: 哈利·波特与魔法石,year: 2000, author: [英] J. K. 罗琳",
            "name: 华胥引（全二册）, year: 2000, author: 唐七公子",
            "name: 盗墓笔记, year: 2000, author: 南派三叔" };
    private int listLength = bookMessage.length;
    private String welcomeMessage = "Welcome to our library!";

    public void ShowWelcomeMessage(){
        System.out.println(welcomeMessage);
    }

    public void bookList(){
        int circleCounter;
        for (circleCounter=0;circleCounter<listLength;circleCounter++){
            System.out.println(bookMessage[circleCounter]);
        }
    }

    public void libraryMenu(){
        System.out.println("------------------");
        System.out.println("----Main  Menu----");
        System.out.println("------------------");
    }
}
