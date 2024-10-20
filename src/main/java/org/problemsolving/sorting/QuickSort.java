package org.problemsolving.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {4, 6, 1, 7, 3, 2, 5};

        quickSort(array);

        //int returnIndex = pivot(array, 0, 6);

       // System.out.println("return index :" + returnIndex);

        System.out.println("array : " + Arrays.toString(array));

    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivot(array, left, right);
            quickSortHelper(array, left, pivot - 1);
            quickSortHelper(array, pivot + 1, right);
        }
    }

    public static void quickSort(int[] array)
    {
        quickSortHelper(array,0,array.length-1);
    }

    private static int pivot(int[] array, int pivot, int end) {
        int swap = pivot;

        for (int i = pivot + 1; i <= end; i++) {
            if (array[i] < array[pivot]) {
                swap++;
                swap(array, swap, i);
            }
        }
        swap(array, pivot, swap);
        return swap;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}


