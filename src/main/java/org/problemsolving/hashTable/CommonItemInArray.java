package org.problemsolving.hashTable;

import java.util.*;
import java.util.stream.Collectors;

public class CommonItemInArray {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 5};
        int[] arr2 = {3, 4, 5};
        boolean result = commonItemInArray(arr1, arr2);
        System.out.println("commone element in array" + result);

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};


        System.out.println(groupAnagrams(strs));


    }

    // high performance using map
    private static boolean commonItemInArray(int[] arr1, int[] arr2) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : arr1) {
            map.put(i, true);
        }

        for (int j : arr2) {
            if (map.get(j) != null) return true;
        }
        return false;
    }

    public static Integer[]  findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            Integer count=map.get(i);
           if(count==null)
           {
               map.put(i,1);
           }else {
               map.put(i,count+1);
           }
        }

        List<Integer> duplicate=new ArrayList<>();
        for (int j : map.keySet()) {
          if(map.get(j)>1);
            duplicate.add(j);
        }
        return duplicate.toArray(Integer[]::new);
    }

    public static Character  findDuplicates(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i <str.length() ; i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }

        List<Integer> duplicate=new ArrayList<>();
        for (Character key : map.keySet()) {
            if(map.get(key)==1);
           return key;
        }
      return null;
    }

     public static List groupAnagrams(String[] strings)
    {
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strings)
        {
            char[] strArray=str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr=Arrays.toString(strArray);
            if(map.get(sortedStr)==null)
            {
                map.put(sortedStr,new ArrayList<>());
            }

            map.get(sortedStr).add(str);

        }

        List<List<String>> anagramList = map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
    return anagramList;
    }

    // lowperformance
    /*public static boolean commonItemInArray(int[] arr1, int[] arr2) {
        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j)
                    return true;
            }
        }
        return false;
    }*/


}
