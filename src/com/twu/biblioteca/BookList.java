package com.twu.biblioteca;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

class BookList {

    private Book[] booksMessage;
    private int listSize;

    BookList(String path){
        String JsonContext = new ReadJson().ReadFile(path);
        JSONArray bookMessage = JSONArray.fromObject(JsonContext);
        int circleCounter, listLength = bookMessage.size();
        Book[] bookInfo = new Book[listLength];
        for (circleCounter = 0; circleCounter < listLength; circleCounter++){
            JSONObject jsonObject = bookMessage.getJSONObject(circleCounter);
            bookInfo[circleCounter] = new Book(jsonObject.get("name").toString(),jsonObject.get("year").toString(),jsonObject.get("author").toString());
        }

        this.booksMessage = bookInfo;
        this.listSize = bookInfo.length;
    }

    Book[] getbooksMessage(){
        return this.booksMessage;
    }

    public int getListSize(){
        return this.listSize;
    }

    public String[] getNameList(){
        String[] bookNameList = new String[this.listSize];
        for (int i=0; i<this.listSize; i++){
            bookNameList[i]=this.booksMessage[i].getName();
        }
        return bookNameList;
    }

    public Book searchBook(String name){
        for (int i=0; i<this.listSize; i++){
            if (name.equals(this.booksMessage[i].getName())){
                return this.booksMessage[i];
            }
        }
        return null;
    }

    public void listBookMessage() {
        System.out.println("******************\n" + "----Books List----\n" + "******************");
        int listLength = booksMessage.length;
        for (int i = 0; i < listLength; i++) {
            if ("Allowed".equals(booksMessage[i].getStatus())) {
                System.out.print("name:" + booksMessage[i].getName() + ", " + "year:" + booksMessage[i].getYear() + ", " + "author:" + booksMessage[i].getAuthor() + "\n");
            }
        }
    }
}
