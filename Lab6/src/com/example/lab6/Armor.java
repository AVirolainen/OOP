package com.example.lab6;

public class Armor {
    private String name;
    private int value;
    private int weight;
    private int price;

    public Armor(String name1, int v, int w, int p){
        name = name1;
        value = v;
        weight = w;
        price = p;
    }


    public int getPrice(){
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {return name;}

    public int getValue() {
        return value;
    }

    public String getInformation(){
        return "Name: " +name+"; Price: "+price;
    }
}
