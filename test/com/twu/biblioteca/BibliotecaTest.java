package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    private String path = "/Users/rhuan/IdeaProjects/TWU_Biblioteca-master/book.json";
    private BibliotecaApp library = new BibliotecaApp(path);

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

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void ShouldHaveWelcomeMessage() {
        library.showWelcomeMessage();
        assertEquals("Welcome to our library!\n", outContent.toString());
    }

    @Test
    public void ShouldShowBookList() {
        library.bookInfo.listBookMessage();
        assertThat(outContent.toString(),containsString(bookMessage));
    }

    @Test
    public void ShouldHaveBookDetails() {
        library.bookInfo.listBookMessage();
        assertThat(bookMessage, containsString("name"));
        assertThat(bookMessage, containsString("year"));
        assertThat(bookMessage, containsString("author"));
    }

    @Test
    public void ShouldRaiseAnExceptionWhenInputWrongMessageInMenue(){
        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
        System.setIn(in);
        library.libraryMenu();
        assertThat(outContent.toString(), containsString("Select a valid option!"));
    }

    @Test
    public void ShouldShowBookListWhenInputBookList(){
        ByteArrayInputStream in = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(in);
        library.libraryMenu();
        assertThat(outContent.toString(), containsString(bookMessage));
    }

    @Test
    public void ShouldQuitWhenInputQuit(){
        ByteArrayInputStream in = new ByteArrayInputStream("Quit".getBytes());
        System.setIn(in);
        library.libraryMenu();
        assertThat(outContent.toString(), containsString("Main  Menu"));
        assertThat(outContent.toString(), containsString("Thank you for use!"));
    }

    @Test
    public void ShouldBeAbleToCheckoutBook(){
        ByteArrayInputStream in = new ByteArrayInputStream("Checkout".getBytes());
        System.setIn(in);
        library.bookList();
        assertThat(outContent.toString(), containsString("Check your books"));
    }

    @Test
    public void CustomerShouldAbleToSeeSuccessfulMessageWhenCheckOutBooksSucceed(){
        ByteArrayInputStream in = new ByteArrayInputStream("盗墓笔记".getBytes());
        System.setIn(in);
        library.checkOut();
        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void CustomerShouldSeeFailedMessageWhenCheckOutBooksFailed(){
        ByteArrayInputStream in = new ByteArrayInputStream("gakl".getBytes());
        System.setIn(in);
        library.checkOut();
        assertThat(outContent.toString(), containsString("That book is not available"));
    }

    @Test
    public void ShouldBeAbleToBackToBookListWhenCheckout() {
        ByteArrayInputStream in = new ByteArrayInputStream("Back".getBytes());
        System.setIn(in);
        library.checkOut();
        assertThat(outContent.toString(), containsString(bookMessage));
    }

    @Test
    public void ShouldBeAbleToReturnBook(){
        ByteArrayInputStream in = new ByteArrayInputStream("Return".getBytes());
        System.setIn(in);
        library.bookList();
        assertThat(outContent.toString(), containsString("Return your books"));
    }

    @Test
    public void CustomerShouldAbleToSeeSuccessfulMessageWhenReturnBooksSucceed(){
        ByteArrayInputStream in = new ByteArrayInputStream("盗墓笔记".getBytes());
        System.setIn(in);
        library.checkOut();
        ByteArrayInputStream inAgain = new ByteArrayInputStream("盗墓笔记".getBytes());
        System.setIn(inAgain);
        library.returnBook();
        assertThat(outContent.toString(), containsString("Thank you for returning the book."));
    }

    @Test
    public void CustomerShouldSeeFailedMessageWhenReturnBooksFailed(){
        ByteArrayInputStream in = new ByteArrayInputStream("gakl".getBytes());
        System.setIn(in);
        library.returnBook();
        assertThat(outContent.toString(), containsString("That is not a valid book to return."));
    }

    @Test
    public void ShouldBeAbleToBackToBookListWhenReturn(){
        ByteArrayInputStream in = new ByteArrayInputStream("Back".getBytes());
        System.setIn(in);
        library.returnBook();
        assertThat(outContent.toString(), containsString(bookMessage));
    }
}
