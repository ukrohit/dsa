package org.problemsolving.hashTable;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);



         /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */


        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false

        */


        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */


        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + longestConsecutiveSequence(nums));

    }

    private static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        // Create a HashSet to store elements from arr1
        HashSet<Integer> set = new HashSet<>();

        List result=new ArrayList();
        // Add all elements of arr1 to the set
        for (int num : arr1) {
            set.add(num);
        }

        // Iterate over arr2 and check if the complement (target - num) exists in the set
        for (int num : arr2) {
            int complement = target - num;

            // If the complement exists in arr1, print the pair
            if (set.contains(complement)) {
                result.add(new int[]{complement,num});
                //System.out.println("Pair found: (" + complement + ", " + num + ")");
            }
        }

        return  result;

    }

    private static boolean hasUniqueChars(String str) {

        String[] strSplit = str.split("");
        List strList=Arrays.asList(strSplit);
        Set strSet=new HashSet(strList);
        if(strSet.size()!=strList.size())
            return false;
        return true;
    }
    public static int longestConsecutiveSequence(int[] nums) {

        Set numSet=new HashSet();

        for(int n:nums)
        {
            numSet.add(n);
        }
        int longestStreak = 0;

        for(int num=0;num<numSet.size();num++)
        {
            // Check if it's the start of a sequence (i.e., num - 1 is not in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check how long the sequence lasts
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    private static List<Integer> removeDuplicates(List<Integer> myList) {
        Set set=new HashSet(myList);
        return new ArrayList<>(set);

    }
}
