package com.example.lab;

public class Word {
    private Letter[] data;
    private String word;
    int number;

    public Word(String word_string) {
        word = word_string;
        Letter[] letters_word = new Letter[word_string.length()];
        for (int i = 0; i < word_string.length(); i++) {
            letters_word[i] = new Letter(word_string.charAt(i));
        }
        data = letters_word;
    }

    // метод повертає слово
    public String getWord() {
        return word;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int find() {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if (!data[0].isCorrectLetter() & (data.length == 4)){
                counter++;}

        }
        return counter;
    }
}

