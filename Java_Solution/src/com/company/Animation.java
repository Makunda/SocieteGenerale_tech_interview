package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Animation {

    static List<String> animate(int speed, String init) throws Exception {
        try {
            if( speed < 1 || speed > 10 ) throw new Exception("Speed must be a number between 1 and 10."); // Filter Speed
            if( init.length() < 1 || init.length() > 50 ) throw new Exception("Init length must be between 1 and 50."); // Filter init
            if(! init.matches("([LR.]+)")) throw new Exception("Invalid Characters in init string.");

            ParticleChamber particleChamber = new ParticleChamber(speed, init);
            particleChamber.animateChamber();
            return  particleChamber.printChamber();
        } catch (Exception e) {
            throw e;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the speed of the particles :");
        int speed = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter the configuration of the chamber :");
        String init = sc.nextLine();

        try {
            System.out.println(Arrays.toString(animate(speed, init).toArray()));
        } catch (Exception e) {
            System.out.println("An error occured during the animation : " + e.getMessage());
        }
    }
}
