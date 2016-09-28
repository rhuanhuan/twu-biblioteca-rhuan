package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class BibliotecaApp {

    private BookList bookInfo;
    public String appCommand = null;

    public BibliotecaApp(String path) {
        this.bookInfo = new BookList(path);
    }

    public void showWelcomeMessage() {
        String welcomeMessage = "Welcome to our library!";
        System.out.println(welcomeMessage);
    }

    public void listBookMessage() {
        System.out.println("******************\n" + "----Books List----\n" + "******************");
        int listLength = bookInfo.getListSize();
        Book[] bookMessage = bookInfo.getbooksMessage();
        for (int i = 0; i < listLength; i++) {
            if ("Allowed".equals(bookMessage[i].getStatus())) {
                System.out.print("name:" + bookMessage[i].getName() + ", " + "year:" + bookMessage[i].getYear() + ", " + "author:" + bookMessage[i].getAuthor() + "\n");
            }
        }
    }

    public void bookList() {
        listBookMessage();
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
                bookList();
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
                bookList();
                break;
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }

    public void libraryMenu() {
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
                    bookList();
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
