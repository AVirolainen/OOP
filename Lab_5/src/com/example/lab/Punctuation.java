package com.example.lab;

public class Punctuation {
    private char data1;
    protected String symb;

    public Punctuation(char symbol) {
        data1 = symbol;
        symb = String.valueOf(symbol);
    }


    // метод повертає заданий символ
    public char getPunctuation() {

            return data1;
    }
}
