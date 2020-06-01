package com.example.lab;

public class Letter {
    private char data;
    protected String letter;

    public Letter(char symbol) {
        data = symbol;
        letter = String.valueOf(symbol);
    }

    public char getLetter() {
        return data;
    }

    public boolean isCorrectLetter() {
        if ((letter.equalsIgnoreCase("a"))
                | (letter.equalsIgnoreCase("e"))
                | (letter.equalsIgnoreCase("u"))
                | (letter.equalsIgnoreCase("y"))
                | (letter.equalsIgnoreCase("i"))
                | (letter.equalsIgnoreCase("o")))
            return true;
        else
            return false;
    }
}