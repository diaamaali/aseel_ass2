package com.example.assignment1;

public class MathBook {
    private String operation;

    public MathBook(String operation) {
        this.operation = operation;
    }

    public MathBook() {
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "MathBook{" +
                "operation='" + operation + '\'' +
                '}';
    }


}
