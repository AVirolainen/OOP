package com.example.lab;

import java.util.Arrays;

public class Sentence {
    private Word[] data;
    private Punctuation[] data1;
    private String sentence;

    public Sentence(String sentence_string) {
        sentence_string = new String(sentence_string.trim());
        System.out.println(Arrays.toString(sentence_string.split(" "))+"   1");
        int word_counter;
        word_counter = 1;
        char symbol;
        int punkruation_counter = 1;
        /*
         * знаходимо кількість символів пунктуації і кількість слів в даному
         * реченні
         */
        for (int i = 0; i < sentence_string.length(); i++) {
            symbol = sentence_string.charAt(i);
            if (sentence_string.charAt(i) == ' ') {
                word_counter++;
            }
            if ((symbol == '.') | (symbol == ',') | (symbol == '!')
                    | (symbol == '?') | (symbol == '/') | (symbol == ':'))
                punkruation_counter++;

        }
        System.out.println(Arrays.toString(sentence_string.split(" "))+"   2");
        /*
         * створюємо масив об'єктів класу Word
         */
        Word[] word = new Word[word_counter];
        /*
         * створюємо масив об'єктів класу Punktuatoin
         */
        Punctuation[] punktuatoin = new Punctuation[punkruation_counter];
        word_counter = 0;
        punkruation_counter = 0;
        /*
         * ствоюємо об'єкти Word Punktuatoin одноіменних масивів
         */

        System.out.println(Arrays.toString(sentence_string.split(" "))+"   4");
        sentence_string = new String(sentence_string.replace(".", ""));
        String[] l = sentence_string.split(" ");

        for (int i = 0; i < l.length; i++) {
            word[i] = new Word(l[i]);
        }

        sentence = sentence_string;
        data = word;
        data1 = punktuatoin;
    }

    // метод передає масив слів у заданому речення
    public Word[] getWord() {
        return data;
    }

    // метод передає масив знаків пунктуації у заданому реченні
    public Punctuation[] getPunktuatoins() {
        return data1;
    }

    // метод передає кількість слів у заданому реченні
    public int wordNumber() {
        return data.length;
    }

    // метод передає кількість символів пунктуації а заданому реченні
    public int punktuationNumber() {
        return data1.length;
    }

    // метод повертає задане речення
    public String GetSen() {
        return sentence;
    }
}
