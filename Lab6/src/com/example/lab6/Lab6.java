package com.example.lab6;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab6 {
    public static void main(String[] args) {
        Helmet helmet = new Helmet();
        Shield shield = new Shield();
        Boots boots = new Boots();
        Leggins leggins = new Leggins();

        int totalprice = helmet.getPrice() + shield.getPrice() + boots.getPrice() + leggins.getPrice();
        System.out.println("Hero is dressed into: "+helmet.getName()+", "+shield.getName()+", "+boots.getName()+", "
                          +leggins.getName());
        System.out.println("Total price: "+totalprice);
        System.out.println("----------------------------------------------");
        System.out.println("Sorted equipment");
        ArrayList<Armor> am = new ArrayList<>();
        am.add(helmet);
        am.add(shield);
        am.add(boots);
        am.add(leggins);

        for(int i = am.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if(am.get(j).getPrice() > am.get(j+1).getPrice()){
                Armor tmp = am.get(j);
                am.set(j, am.get(j + 1));
                am.set(j + 1, tmp);
            }
        }
    }
        for (int i = 0; i < am.size(); i++) {
            System.out.println(am.get(i).getInformation());
        }
        System.out.println("----------------------------------------------");
        System.out.println("Enter the range of prices:");
        System.out.print("from:");
        Scanner scanner = new Scanner(System.in);
        int numberFrom = scanner.nextInt();
        System.out.print("to:");
        int numberTo = scanner.nextInt();

        for (int i = 0; i < am.size(); i++) {
            if ((am.get(i).getPrice() > numberFrom)
                    && (am.get(i).getPrice() < numberTo)) {
                System.out.println(am.get(i).getInformation());
            }
        }


    }
}
