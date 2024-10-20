package org.problemsolving.recursion;

public class Factorial {
    public static void main(String[] args) {
        int factorial=fact(5);
        System.out.println(factorial);
    }

    private static int fact(int num) {
        if(num==1)
            return num;
        return num*fact(num-1);
    }
}
