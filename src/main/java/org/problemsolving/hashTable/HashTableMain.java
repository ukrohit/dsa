package org.problemsolving.hashTable;

import java.util.ArrayList;

public class HashTableMain {

    public static void main(String[] args) {

        HashTable hashTable=new HashTable();

        hashTable.set("ukr",5);

        hashTable.set("trish",15);

        hashTable.set("sachin",15);

        hashTable.printTable();

        hashTable.set("ukr",10);

        hashTable.printTable();

         int value=hashTable.get("ukr");
        System.out.println("get value : "+value);

        ArrayList keys=hashTable.keys();


        System.out.println("get keys : "+keys);


    }
}
