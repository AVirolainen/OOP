package com.example.lab7;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab7 {
    public static void main(String[] args) {

        Shield shield = new Shield("Golden Shield", 12, 70, 200);
        Helmet helmet = new Helmet("Golden Helmet", 5, 50, 100);
        Boots boots = new Boots("Golden Boots", 5, 60, 150);
        Leggins leggins = new Leggins("Golden Leggins", 8, 65, 175);

        MyCollection am = new MyCollection();

        am.add(helmet);
        am.add(shield);
        am.add(boots);
        am.add(leggins);
        ListIterator<Armor> itr =  am.listIterator(0);
        while (itr.hasNext()) {
            Armor Armor = itr.next();
            System.out.println(Armor.getInformation());
        }
        am.remove(helmet);

        int minPrice = 15; int maxPrice = 100;
        System.out.println("Aмуніція із вибраного діапазону цін: " + minPrice
                + "-" + maxPrice);
        itr = am.listIterator();
        while (itr.hasNext()) {
            Armor Armor =  itr.next();
            if ((Armor.getPrice()<=maxPrice)&&(Armor.getPrice()>=minPrice)){
                System.out.println(Armor.getInformation());
            }
        }

    }

}
