package org.problemsolving.dynamicprogram;

public class FebonanciSearies {

    static int counter = 0;

    static  Integer[] memo=new Integer[100];

    public static void main(String[] args) {


        int n = 8;




        System.out.println("Feb of " + n + "=" + feboBottomUp(n));
        System.out.println("counter : " + counter);


       // System.out.println("Feb of " + n + "=" + febo(n));
        System.out.println("counter : " + counter);
    }

    private static int febo(int n) {
        counter++;
        if (n == 0 || n == 1)
            return n;
        return febo(n - 1) + febo(n - 2);
    }

    private static int feboMemo(int n) {
        counter++;

        if(memo[n]!=null)
            return memo[n];

        if (n == 0 || n == 1)
            return n;
        memo[n]= feboMemo(n - 1) + feboMemo(n - 2);
        return memo[n];
    }

    private static int feboBottomUp(int n)
    {
        int[] array=new int[n+1];
        array[0]=0;
        array[1]=1;

        for (int i = 2; i <=n ; i++) {
            counter ++;
            array[i]=array[i-1]+array[i-2];
        }

        return array[n];
    }
}
