package org.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class NumberCheckMain
{
    public static void main(String[] args) {

        /*int num1=10;
        int num2=num1;
        num1=20;
        System.out.println(num1+","+num2);
        System.out.println();*/

        Map<String, Integer> map1=new HashMap();
        map1.put("age",20);

        Map<String, Integer> map2=map1;

        map1.put("age",10);

        System.out.println("map1: "+map1);
        System.out.println("map2: "+map2);



    }
}
