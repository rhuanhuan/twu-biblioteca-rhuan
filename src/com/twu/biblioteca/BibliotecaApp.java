package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class BibliotecaApp {

    public BookList bookInfo;
    public MovieList movieInfo;
    public String appCommand = null;

    public BibliotecaApp(String path1,String path2) {
        this.bookInfo = new BookList(path1);
        this.movieInfo = new MovieList(path2);
    }

    public void showWelcomeMessage() {
        String welcomeMessage = "Welcome to our library!";
        System.out.println(welcomeMessage);
    }

    public void bookListMenu() {
        bookInfo.listBookMessage();
        listLabel:
        while (true) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine())
                appCommand = scan.nextLine();
            else
                break;
            switch (appCommand) {
                case "Checkout":
                    checkOut();
                    break listLabel;
                case "Return":
                    returnBook();
                    break listLabel;
                case "Quit":
                    break listLabel;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public void movieListMenu(){
        movieInfo.listMovieMessage();
    }

    public void checkOut() {
        System.out.println("###################\n" + "#Check your books#\n" + "*******************");
        String[] bookNameInfo = bookInfo.getNameList();
        while (true) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine())
                appCommand = scan.nextLine();
            else
                break;
            Book checkedBook = bookInfo.searchBook(appCommand);
            if (checkedBook != null && (Objects.equals(checkedBook.getStatus(), "Allowed"))) {
                System.out.println("Thank you! Enjoy the book");
                checkedBook.changeStatus();
            } else if (checkedBook != null && (Objects.equals(checkedBook.getStatus(), "Denied"))) {
                System.out.println("The book had been borrowed");
            } else if (Objects.equals(appCommand, "Back")) {
                bookListMenu();
                break;
            } else {
                System.out.println("That book is not available.");
            }
        }
    }

    public void returnBook() {
        System.out.println("###################\n" + "#Return your books#\n" + "*******************");
        String[] bookNameInfo = bookInfo.getNameList();
        while (true) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine())
                appCommand = scan.nextLine();
            else
                break;
            Book returnedBook = bookInfo.searchBook(appCommand);
            if (returnedBook != null && ("Denied".equals(returnedBook.getStatus()))) {
                System.out.println("Thank you for returning the book.");
                returnedBook.changeStatus();
            } else if (appCommand.equals("Back")) {
                bookListMenu();
                break;
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }

    public void mainMenu() {
        showWelcomeMessage();
        System.out.println("------------------\n" + "----Main  Menu----\n" + "------------------");
        label:
        while (true) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine())
                appCommand = scan.nextLine();
            else
                break;
            switch (appCommand) {
                case "List Books":
                    bookListMenu();
                    break label;
                case "List Movies":
                    movieListMenu();
                    break label;
                case "Quit":
                    System.out.println("Thank you for use!");
                    break label;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }
    }
}
