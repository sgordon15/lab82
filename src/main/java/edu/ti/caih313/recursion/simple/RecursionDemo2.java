package edu.ti.caih313.recursion.simple;

import java.util.Scanner;

public class RecursionDemo2 {
    public static void main(String[] args) {
        System.out.println("Enter a nonnegative number:");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        System.out.println(number + " contains " +
                getNumberOfZeros(number, "> ") + " zeros.");
    }


    /**
     * Precondition: n >= 0
     * Returns the number of zero digits in n.
     */
    public static int getNumberOfZeros(int n, String prefix) {
        System.out.println(prefix + "Entering getNumberOfZeros with " + n);
        int result;
        if (n == 0) {
            System.out.println(prefix + "setting result to 1, because n == 0");
            result = 1;
        } else if (n < 10) {
            System.out.println(prefix + "setting result to 0 because n = " + n);
            result = 0; //n has one digit that is not 0
        } else if (n % 10 == 0) {
            System.out.println(prefix + "found another zero");
            System.out.println(prefix + "calling getNumberOfZeros with " + (n/10));
            result = getNumberOfZeros(n / 10, "-"+prefix) + 1;
        } else { //n % 10 != 0
            System.out.println(prefix + "calling getNumberOfZeros with " + (n/10));
            result = getNumberOfZeros(n / 10, "-"+prefix);
        }
        System.out.println(prefix + "Exiting getNumberOfZeros with " + n);
        return result;
    }
}
