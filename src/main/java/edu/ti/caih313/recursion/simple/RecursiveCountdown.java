package edu.ti.caih313.recursion.simple;

public class RecursiveCountdown {
    public static void main(String[] args) {
        countDown(3, "> ");
    }

    public static void countDown(int num, String prefix) {
        System.out.println(prefix + "Entering countDown with " + num);
        if (num == 0) {
            //System.out.println("That's all, folks!");
            System.out.println(prefix + "done!");
        } else {
            System.out.println(prefix + "calling countDown with " + (num-1));
            countDown(num - 1, "-"+prefix);
        }
        System.out.println(prefix + "Exiting countDown with " + num);
    }
}
