package org.problemsolving.sorting;

import java.util.Arrays;

public class BubbleShort {

    public static void main(String[] args) {
        int[] numbers = {6, 3, 4, 5, 2, 1};
        System.out.println(Arrays.toString(numbers));
       // bubbleShort(numbers);
      //  selectionSort(numbers);
        insertionSort(numbers);
        System.out.println("sorted array" + Arrays.toString(numbers));

    }


    // Bubbole sort willl sort the same array but merge sort creeat the copy of the array
    public static void bubbleShort(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }


    public static void selectionSort(int[] nums)
    {

        for (int i = 0; i <nums.length ; i++) {
            int minIndex=i;
            for(int j=i+1;j< nums.length;j++)
            {
                if(nums[j]<nums[minIndex])
                {
                    minIndex=j;
                }
            }
            int temp=nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=temp;

        }

    }

    public  static void insertionSort(int[] num)
    {
        for(int i=1;i<num.length;i++)
        {
            int temp=num[i];
            int j=i-1;

            while(j>-1 && temp<num[j])
            {
                num[j+1]=num[j];
                num[j]=temp;
                j--;

            }
        }

    }
}
