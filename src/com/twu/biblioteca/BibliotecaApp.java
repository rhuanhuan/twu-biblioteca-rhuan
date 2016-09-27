package com.twu.biblioteca;

import net.sf.json.JSONArray;

import java.util.Objects;
import java.util.Scanner;

import net.sf.json.JSONObject;

public class BibliotecaApp {

    private BookList bookInfo;

    public BibliotecaApp(String path) {
        this.bookInfo = new BookList(path);
    }

    private void showWelcomeMessage() {
        String welcomeMessage = "Welcome to our library!";
        System.out.println(welcomeMessage);
    }

    private void listBookMessage(Book[] bookInfo) {
        System.out.println("******************\n" + "----Books List----\n" + "******************");
        int listLength = bookInfo.length;
        for (int i = 0; i < listLength; i++) {
            if ("Allowed".equals(bookInfo[i].getStatus())) {
                System.out.print("name:" + bookInfo[i].getName() + ", " + "year:" + bookInfo[i].getYear() + ", " + "author:" + bookInfo[i].getAuthor() + "\n");
            }
        }
    }

    private void bookList(Book[] bookInfo) {
        listBookMessage(bookInfo);
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

    public void libraryMenu() {
        showWelcomeMessage();
        label:
        while (true) {
            System.out.println("------------------\n" + "----Main  Menu----\n" + "------------------");
            Scanner scan = new Scanner(System.in);
            String menuCommand = scan.nextLine();
            switch (menuCommand) {
                case "List Books":
                    bookList(bookInfo.getbooksMessage());
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

    private void checkOut() {
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
                bookList(bookInfo.getbooksMessage());
                break;
            } else {
                System.out.println("That book is not available.");
            }
        }
    }

    private void returnBook() {
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
                bookList(bookInfo.getbooksMessage());
                break;
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }
}
