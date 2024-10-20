package org.problemsolving.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices
                return new int[]{map.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);


        }
        return new int[]{};

    }


    public static int[] subarraySum(int[] nums, int target) {
    // HashMap to store the cumulative sum and its index
    HashMap<Integer, Integer> map = new HashMap<>();
    int currentSum = 0;

    // Iterate through the array
        for(int i = 0; i<nums.length;i++)
        {
        // Add the current element to the cumulative sum
        currentSum += nums[i];

        // If the cumulative sum equals the target, return the subarray from 0 to i
        if (currentSum == target) {
            return new int[]{0, i};
        }
        // Check if (currentSum - target) is already in the map
        if (map.containsKey(currentSum - target)) {
            // If it is, return the subarray from the index after the stored index to i
            return new int[]{map.get(currentSum - target) + 1, i};
        }

        // Otherwise, store the current sum with its index
        map.put(currentSum, i);
    }

    // If no subarray is found, return an empty array or throw an exception
        throw new IllegalArgumentException("No subarray with the given sum");
}

    public static void main(String[] args) {

        System.out.println(
                Arrays.toString(
                twoSum(new int[]{2, 7, 11, 15},18)));

        System.out.println(
                Arrays.toString(
                        subarraySum(new int[]{1,2,3,4,5},9)));
    }
}
