package com.example.assignment1;
import java.util.ArrayList;
import java.util.List;
public class MathData {


    private List<MathBook> books;

    // In this constructor we will create a dumpy data
    public MathData() {
        books = new ArrayList<MathBook>();
        books.add(new MathBook("addition"));
        books.add(new MathBook("subtract"));
        books.add(new MathBook("multiplication"));
    }

    public List<MathBook> getBooksTypes (String type) {
        List<MathBook> book = new ArrayList<>();
        for (MathBook b: books) {
            if (b.getOperation().equals(type)){
                book.add(b);
            }
        }
        return book;
    }

    public String[] getBookTypesSpinner(){
        String [] operation = {"addition","subtract","multiplication"};
        return operation;
    }

}
