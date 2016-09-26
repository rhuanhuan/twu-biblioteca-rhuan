package com.twu.biblioteca;

import net.sf.json.JSONArray;

import java.util.Objects;
import java.util.Scanner;

import net.sf.json.JSONObject;

public class BibliotecaApp {

    private Book[] bookInfo = initialBooks();
    private int listSize = bookInfo.length;

    private Book[] initialBooks(){
//        String JsonContext = new ReadJson().ReadFile(path);
        String JsonContext = new ReadJson().ReadFile("/Users/rhuan/IdeaProjects/TWU_Biblioteca-master/book.json");
        JSONArray bookMessage = JSONArray.fromObject(JsonContext);
        int circleCounter, listLength = bookMessage.size();
        Book[] bookInfo = new Book[listLength];
        for (circleCounter = 0; circleCounter < listLength; circleCounter++){
            JSONObject jsonObject = bookMessage.getJSONObject(circleCounter);
            bookInfo[circleCounter] = new Book(jsonObject.get("name").toString(),jsonObject.get("year").toString(),jsonObject.get("author").toString());
        }
        return bookInfo;
    }

    private String[] bookNameList(){
        String[] bookNameList = new String[listSize];
        for (int i=0; i<listSize; i++){
            bookNameList[i]=bookInfo[i].getName();
        }
        return bookNameList;
    }

    private Book searchBookByName(String name){
        for (int i=0; i<listSize; i++){
            if (Objects.equals(name,bookInfo[i].getName())){
                return bookInfo[i];
            }
        }
        return null;
    }

    private void showWelcomeMessage() {
        String welcomeMessage = "Welcome to our library!";
        System.out.println(welcomeMessage);
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
                    bookList(bookInfo);
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

    private void bookList(Book[] bookInfo) {
        System.out.println("******************\n" + "----Books List----\n" + "******************");
        int circleCounter, listLength = bookInfo.length;
        for (circleCounter = 0; circleCounter < listLength; circleCounter++) {
            if (Objects.equals(bookInfo[circleCounter].getStatus(), "Allowed")){
                System.out.print("name:" + bookInfo[circleCounter].getName()+ ", " );
                System.out.print("year:" + bookInfo[circleCounter].getYear()+ ", " );
                System.out.print("author:" + bookInfo[circleCounter].getAuthor()+ "\n" );
            }
        }
        listLabel:
        while (true){
            Scanner scan = new Scanner(System.in);
            String listCommand = scan.nextLine();
            switch (listCommand){
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


    private void checkOut(){
        System.out.println("###################\n" + "#Check your books#\n" + "*******************");
        String[] bookNameInfo = bookNameList();
        while (true){
            Scanner scan = new Scanner(System.in);
            String checkCommand = scan.nextLine();
            Book checkedBook = searchBookByName(checkCommand);
            if (checkedBook!=null &&(Objects.equals(checkedBook.getStatus(), "Allowed"))){
                System.out.println("Thank you! Enjoy the book");
                checkedBook.changeStatus();
            }
            else if (Objects.equals(checkCommand, "Back")){
                bookList(bookInfo);
                break;
            }
            else {
                System.out.println("That book is not available.");
            }
        }
    }

    private void returnBook(){
        System.out.println("###################\n" + "#Return your books#\n" + "*******************");
        String[] bookNameInfo = bookNameList();
        while (true){
            Scanner scan = new Scanner(System.in);
            String returnCommand = scan.nextLine();
            Book returnedBook = searchBookByName(returnCommand);
            if (returnedBook!=null &&(Objects.equals(returnedBook.getStatus(), "Denied"))){
                System.out.println("Thank you for returning the book.");
                returnedBook.changeStatus();
            }
            else if (Objects.equals(returnCommand, "Back")){
                bookList(bookInfo);
                break;
            }
            else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }
}
