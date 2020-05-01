package edu.ti.caih313.recursion.sort;
/**
 * Class for sorting an array of integers from smallest to largest
 * using the merge sort algorithm.
 */
public class MergeSort {

    private static int numberOfCopies;

    public MergeSort() {this.numberOfCopies = 0;}

    static int getNumberOfCopies() {return numberOfCopies;}

    /**
     * Precondition: Every indexed variable of the array a has a value.
     * Post-condition: a[0] <= a[1] <= ... <= a[a.length - 1].
     */
    public static void sort(int[] a, String prefix) {
        System.out.println(prefix + "Entering sort(a.length = " + a.length + ")");
        //if a.length == 1, a is sorted.
        if (a.length >= 2) {
            int halfLength = a.length / 2;
            int[] firstHalf = new int[halfLength];
            int[] lastHalf = new int[a.length - halfLength];
            System.out.println("Entering divide(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + "; lastHalf.length = " + lastHalf.length + ")");
            divide(a, firstHalf, lastHalf, "-" + prefix);
            System.out.println("Entering sort(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + ")");
            sort(firstHalf, "-" + prefix);
            System.out.println("Entering sort(a.length = " + a.length + "; lastHalf.length = " + lastHalf.length + ")");
            sort(lastHalf, "-" + prefix);
            System.out.println("Entering merge(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + "; lastHalf.length = " + lastHalf.length + ")");
            merge(a, firstHalf, lastHalf, "-" + prefix);
        }
        System.out.println(prefix + "Exiting sort(a.length = " + a.length + ")");

    }

    //Precondition: a.length = firstHalf.length + lastHalf.length.
    //Post-condition: All the elements of a are divided
    //between the arrays firstHalf and lastHalf.
    private static void divide(int[] a, int[] firstHalf, int[] lastHalf, String prefix) {
        System.out.println("Entering divide(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + "; lastHalf.length = " + lastHalf.length + ")");
        int copiesFirstHalf = 0, copiesLastHalf = 0;
        for (int i = 0; i < firstHalf.length; i++) {
            firstHalf[i] = a[i];
            copiesFirstHalf++;
        }
        for (int i = 0; i < lastHalf.length; i++) {
            lastHalf[i] = a[firstHalf.length + i];
            copiesLastHalf++;
        }
        numberOfCopies += (copiesFirstHalf + copiesLastHalf);
        System.out.println("Copying " + copiesFirstHalf + " items to firstHalf.");
        System.out.println("Copying " + copiesLastHalf + " items to lastHalf.");
        System.out.println("Exiting divide(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + "; lastHalf.length = " + lastHalf.length + ")");
    }

    //Precondition: Arrays firstHalf and lastHalf are sorted from
    //smallest to largest; a.length = firstHalf.length +
    //lastHalf.length.
    //Post-condition: Array a contains all the values from firstHalf
    //and lastHalf and is sorted from smallest to largest.
    private static void merge(int[] a, int[] firstHalf, int[] lastHalf, String prefix) {
        System.out.println("Entering merge(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + "; lastHalf.length = " + lastHalf.length + ")");
        int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0, numberMerged = 0;
        while ((firstHalfIndex < firstHalf.length) && (lastHalfIndex < lastHalf.length)) {
            if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex]) {
                a[aIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                a[aIndex] = lastHalf[lastHalfIndex];
                lastHalfIndex++;
            }
            aIndex++;
            numberMerged++;
        }
        //At least one of firstHalf and lastHalf has been
        //completely copied to a.
        //Copy rest of firstHalf, if any.
        int numberAppended = 0;
        while (firstHalfIndex < firstHalf.length) {
            a[aIndex] = firstHalf[firstHalfIndex];
            aIndex++;
            firstHalfIndex++;
            numberAppended++;
        }
        //Copy rest of lastHalf, if any.
        while (lastHalfIndex < lastHalf.length) {
            a[aIndex] = lastHalf[lastHalfIndex];
            aIndex++;
            lastHalfIndex++;
            numberAppended++;
        }
        System.out.println("Number of items merged = " + numberMerged + "; Number of items appended = " + numberAppended);
        System.out.println("Exiting merge(a.length = " + a.length + "; firstHalf.length = " + firstHalf.length + "; lastHalf.length = " + lastHalf.length + ")");
    }
}