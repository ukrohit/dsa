package org.problemsolving.array;

import java.util.Arrays;

public class MinMax {

    public static void main(String[] args) {
        /* int[] array={ 1,4,7,9,2,8,4,-1,-8};

         int[] result= findMinMax(array);
        System.out.println(Arrays.toString(result));




        // findLongest String
        String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
        String longest1 = findLongestString(stringList1);
        System.out.println("Test case 1: Longest string: " + longest1);


        // Roteate number
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"

        */
        // Find maxSumArray

        // Example array
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Find and print the maximum subarray sum
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }

    private static int[] findMinMax(int[] array) {
        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for (int num:array)
        {
            if(num<min)
                min=num;

            if(num>max)
                max=num;
        }
        return new int[] {max,min};
    }

    public static String findLongestString(String[] stringList)
    {
        int longestStr=0;
        String longestString=null;
        for (String str:stringList)
        {


            if(str.length()>longestStr)
            {
                longestString=str;
                longestStr=str.length();
            }

        }
        return longestString;
    }


    public static int removeDuplicates(int[] nums)
    {
        int j=1;

        for (int i = 1; i < nums.length; i++) {

            if(nums[i]!=nums[i-1])
            {
                nums[j]=nums[i];
                j++;
            }

        }
    return j;
    }


    public static int maxProfit(int[] prices)
    {
        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for (int price:prices)
        {
            if(price<min)
                min=price;

            if(price>max  && min < max)
                max=price;


        }
        return max-min;
    }


    public static void rotate(int[] nums, int k)
    {

        // If the array is empty or no rotation is needed
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int length=nums.length;

        // if k is grater then length of the array
        k=k%length;

        // Step 1: Reverse the entire array
        reverse(nums, 0, length - 1);

        System.out.println("Original Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        System.out.println("Original Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        // Step 3: Reverse the remaining n - k elements
        reverse(nums, k, length - 1);

        System.out.println("Original Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // Helper function to reverse elements in the array from index 'start' to 'end'
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }



    // Find maxSumArray

    // Function to find the maximum subarray sum
    public static int maxSubArray(int[] nums) {
        // Initialize the variables with the first element of the array
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentSum by deciding whether to add the current element to the existing subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maxSum to store the maximum subarray sum encountered so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum; // Return the maximum subarray sum
    }

}
