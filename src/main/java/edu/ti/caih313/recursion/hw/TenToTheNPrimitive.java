package edu.ti.caih313.recursion.hw;

import java.util.Scanner;

public class TenToTheNPrimitive {
     public static void main(String[] args) {
        System.out.print("Enter an doubleeger: ");
        Scanner keyboard = new Scanner(System.in);
        double number = keyboard.nextInt();
        boolean fraction = false;
        if (number < 0) {
            number = -1 * number;
            fraction = true;
        }

        double tenToNum = tenToTheN(number);
        System.out.println("10^" + number + " =" + ((fraction)?" 1/":" ") + tenToNum);
    }

   static double tenToTheN(double n) {
        double val;
        if (n == 0) {
            val = 1;
        } else if (n == 1) {
            val = 10;
        } else {
            double valHalf = tenToTheN(n/2);
            val = valHalf * valHalf;
            if (n%2 == 1) {
                val = val* 10;
            }
        }
        return val;
    }
}
