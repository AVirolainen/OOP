package com.example.lab;
import java.util.Scanner;

public class Lab_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scan.nextLine()+".";
        System.out.println("Enter the number:");
        int number = scan.nextInt();
        Word num = new Word("");
        num.setNumber(number);


        if ((text.substring(0).trim().equals(""))) {
            System.out.println("no text");
        } else {
            Text txt = new Text(text);

            Sentence s;
                for (int i = 0; i < txt.sentenceNumber(); i++) {
                    s = new Sentence(txt.getSentences(i));
                    for (int j = 0; j < s.getWord().length; j++) {
                        if ((i == s.getWord()[j].find())) {
                            System.out.print(s.getWord()[j].getWord());

                            System.out.print(" ");
                        }
                    }
                }
            }
        }
    }

