package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    private BibliotecaApp library = new BibliotecaApp();
    private String bookMessage = "name: Rails之道, year:2000, author:(美)Obie Fernandez\n" +
            "name:Programming Ruby中文版, year:2000, author:托马斯\n" +
            "name:Ruby编程语言, year:2000, author:松本行弘\n" +
            "name:Ruby for Rails中文版, year:2000, author:David Black\n" +
            "name:Java Enterprise最佳实践, year:2000, author: The OReilly Java authors\n" +
            "name:Java应用程序设计接口(下册)--窗口工具箱和applet, year: 2000, author: (美)James Gosling,Frank Yellin,Java 小组\n" +
            "name:Java编程思想 （第4版）, year: 2000, author: [美] Bruce Eckel\n" +
            "name:Effective java 中文版（第2版）, year:2000, author: Joshua Bloch\n" +
            "name:满月之夜白鲸现, year: 2000, author: 片山恭一,豫人\n" +
            "name:塔希里亚故事集, year: 2000, author: 吴淼\n" +
            "name:幻城, year: 2000, author:郭敬明\n" +
            "name:冰与火之歌（卷一）, year:2000, author: [美] 乔治·R. R. 马丁\n" +
            "name:哈利·波特与魔法石, year: 2000, author: [英] J. K. 罗琳\n" +
            "name:华胥引（全二册), year: 2000, author: 唐七公子\n" +
            "name:盗墓笔记, year: 2000, author:南派三叔\n";


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void ShouldHaveWelcomeMessage() {
        library.ShowWelcomeMessage();
        assertEquals("Welcome to our library!\n", systemOutRule.getLog());
    }

    @Test
    public void ShouldShowBookList() {
        library.bookList();
        assertEquals(bookMessage, systemOutRule.getLog());
    }

    @Test
    public void ShouldHaveBookDetails() {
        library.bookList();
        assertThat(bookMessage, containsString("name"));
        assertThat(bookMessage, containsString("year"));
        assertThat(bookMessage, containsString("author"));
    }

    @Test
    public void ShouldSeeMainMenuAndRaiseAnExceptionWhenInputWrongMessageInMenue(){
        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
        System.setIn(in);
        library.libraryMenu();
        assertThat(systemOutRule.getLog(), containsString("Main  Menu"));
        assertThat(systemOutRule.getLog(), containsString("Select a valid option!"));
    }

    @Test
    public void ShouldShowBookeListWhenInputBookList(){
        ByteArrayInputStream in = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(in);
        library.libraryMenu();
        assertThat(systemOutRule.getLog(), containsString(bookMessage));
    }

    @Test
    public void ShouldQuitWhenInputQuit(){
        ByteArrayInputStream in = new ByteArrayInputStream("Quit".getBytes());
        System.setIn(in);
        library.libraryMenu();
        assertThat(systemOutRule.getLog(), containsString("Thank you for use!"));
    }

    @Test
    public void CustomerShouldAbleToCheckOutBooks(){

    }

    @Test
    public void CustomerShouldAbleToSeeSuccessfulMessageWhenCheckOutBooksSucceed(){

    }

    @Test
    public void CustomerShouldAbleToSeeUnsuccessfulMessageWhenCheckOutBooksFailed(){

    }

}
