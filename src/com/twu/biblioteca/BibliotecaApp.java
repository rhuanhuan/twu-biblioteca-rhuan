package com.twu.biblioteca;

import net.sf.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.util.Objects;
import java.util.Scanner;

import com.twu.biblioteca.Book;
import net.sf.json.JSONObject;

public class BibliotecaApp {

    public void ShowWelcomeMessage() {
        String welcomeMessage = "Welcome to our library!";
        System.out.println(welcomeMessage);
    }

    public void bookList() {
        String JsonContext = new ReadJson().ReadFile("/Users/rhuan/IdeaProjects/TWU_Biblioteca-master/book.json");
        JSONArray bookMessage = JSONArray.fromObject(JsonContext);
        int circleCounter, listLength = bookMessage.size();
        for (circleCounter = 0; circleCounter < listLength; circleCounter++) {
            JSONObject jsonObject = bookMessage.getJSONObject(circleCounter);
            System.out.print("name:" + jsonObject.get("name")+ ", " );
            System.out.print("year:" + jsonObject.get("year")+ ", " );
            System.out.print("author:" + jsonObject.get("author")+ "\n" );
        }
    }

    public void libraryMenu() {
        label:
        while (true) {
            System.out.println("------------------\n" + "----Main  Menu----\n" + "------------------");
            Scanner scan = new Scanner(System.in);
            String menuCommand = scan.nextLine();
            switch (menuCommand) {
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
