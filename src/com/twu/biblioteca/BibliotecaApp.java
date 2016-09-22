package com.twu.biblioteca;

import net.sf.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.util.Objects;
import java.util.Scanner;

import com.twu.biblioteca.Book;
import net.sf.json.JSONObject;

public class BibliotecaApp {

    private Book[] initialBooks(){
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

    private void showWelcomeMessage() {
        String welcomeMessage = "Welcome to our library!";
        System.out.println(welcomeMessage);
    }

    public void libraryMenu() {
        showWelcomeMessage();
        Book[] bookInfo = initialBooks();
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
        int circleCounter, listLength = bookInfo.length;
        for (circleCounter = 0; circleCounter < listLength; circleCounter++) {
            if (bookInfo[circleCounter].getStatus()=="Allowed"){
                System.out.print("name:" + bookInfo[circleCounter].getName()+ ", " );
                System.out.print("year:" + bookInfo[circleCounter].getYear()+ ", " );
                System.out.print("author:" + bookInfo[circleCounter].getAuthor()+ "\n" );
            }
        }
    }



    private void checkOut(){

    }

    private void returnBook(){

    }


}
