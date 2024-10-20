package org.problemsolving.linkedList;

import java.util.HashSet;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {

        Node temp = head;
        head = tail;
        tail = temp;
        Node afterNode = tail.next;
        Node beforeNode = null;

        for (int i = 0; i < length; i++) {
            afterNode = temp.next;
            temp.next = beforeNode;
            beforeNode = temp;
            temp = afterNode;
        }

    }

    public Node findMiddleNode() {
        if (head == null)
            return null;
        Node slowMOve = head;
        Node fastMove = head;


        while (fastMove.next != null) {
            fastMove = fastMove.next;
            if (fastMove.next != null) {
                fastMove = fastMove.next;
            }
            slowMOve = slowMOve.next;
        }
        return slowMOve;
    }

    public Node deleteMiddle() {

        if (head == null)
            return null;
        Node slowMOve = head;
        Node fastMove = head;
        Node previousNode = null;


        while (fastMove.next != null) {
            fastMove = fastMove.next;
            if (fastMove.next != null) {
                fastMove = fastMove.next;
            }
            previousNode = slowMOve;
            slowMOve = slowMOve.next;

        }

        Node temp = slowMOve;
        previousNode.next = temp.next;
        temp.next = null;

        System.out.println("Delete node value " + temp.value);
        return temp;

    }

    public void removeDuplicates(Node head) {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.value)) {
                // Duplicate found, remove the node
                prev.next = current.next;
            } else {
                // No duplicate, add the value to the set
                seen.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {

        if (length == 0)
            return 0;

        int decimalNum = 0;
        while (head.next != null) {
            decimalNum = decimalNum + ((length * 2) + length);
            length--;
            head = head.next;
        }

        return decimalNum;
    }

    // Function to reverse the linked list between positions m and n
    public void reverseBetween(int m, int n) {


        // Create a dummy node to simplify edge cases where m = 1
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // Move prev to the node just before the position m
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from m to n
        Node current = prev.next;
        Node nextNode = current.next;

        for (int i = 0; i < n - m; i++) {
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            nextNode = current.next;
        }


    }

    public boolean hasLoop() {
        if (head == null)
            return false;
        Node slowMOve = head;
        Node fastMove = head;


        while (fastMove.next != null) {
            fastMove = fastMove.next;
            if (fastMove.next != null) {
                fastMove = fastMove.next;
            }
            slowMOve = slowMOve.next;

            if (fastMove.value == slowMOve.value)
                return true;
        }


        return false;
    }

    public void bubbleSort() {

        if (head == null) {
            return;

        }

        boolean swapped;
        Node current;
        Node last = null;

        do{
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.value > current.next.value) {
                    // Swap data
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current; // The last node is already sorted
        }while(swapped);

    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

}

