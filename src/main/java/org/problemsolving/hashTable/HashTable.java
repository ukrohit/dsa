package org.problemsolving.hashTable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        this.dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("{ " + temp.key + "  : " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int hash = this.hash(key);
        Node newNode = new Node(key, value);
        Node node = dataMap[hash];
        if (node == null) {
            dataMap[hash] = newNode;
        } else {
            node.next = newNode;
        }
    }

    public int get(String key) {
        int hash = this.hash(key);
        Node node = dataMap[hash];
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
            else
                node = node.next;
        }
        return 0;
    }

    public ArrayList keys()
    {
        ArrayList<String> keys=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Node temp=dataMap[i];
            while(temp!=null)
            {
                keys.add(temp.key);
                temp=temp.next;
            }
        }
        return keys;
    }

    private class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
