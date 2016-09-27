package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class BibliotecaApp {

    private BookList bookInfo;

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
            String listCommand = scan.nextLine();
            switch (listCommand) {
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
            String checkCommand = scan.nextLine();
            Book checkedBook = bookInfo.searchBook(checkCommand);
            if (checkedBook != null && (Objects.equals(checkedBook.getStatus(), "Allowed"))) {
                System.out.println("Thank you! Enjoy the book");
                checkedBook.changeStatus();
            } else if (checkedBook != null && (Objects.equals(checkedBook.getStatus(), "Denied"))) {
                System.out.println("The book had been borrowed");
            } else if (Objects.equals(checkCommand, "Back")) {
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
            String returnCommand = scan.nextLine();
            Book returnedBook = bookInfo.searchBook(returnCommand);
            if (returnedBook != null && (Objects.equals(returnedBook.getStatus(), "Denied"))) {
                System.out.println("Thank you for returning the book.");
                returnedBook.changeStatus();
            } else if (returnCommand.equals("Back")) {
                bookList();
                break;
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }

    public String menuCommand(){
        Scanner scan = new Scanner(System.in);
        String menuCommand = scan.nextLine();
        switch (menuCommand) {
            case "List Books":
                bookList();
                return null;
            case "Quit":
                System.out.println("Thank you for use!");
                return null;
            default:
                System.out.println("Select a valid option!");
                return "Not null";
        }
    }

    public void libraryMenu() {
        showWelcomeMessage();
        System.out.println("------------------\n" + "----Main  Menu----\n" + "------------------");
        String controller="Not null";
        while (controller!=null) {
            controller=menuCommand();
        }
    }
}
