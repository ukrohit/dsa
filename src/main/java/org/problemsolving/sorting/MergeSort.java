package org.problemsolving.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {


        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);

        l1.merge(l2);

        l1.printAll();


        int[] unsortedArray = {1, 3, 8, 6, 7, 4, 2, 9};
        System.out.println(Arrays.toString(unsortedArray));

        int[] sortedArray = mergeSort(unsortedArray);

        System.out.println(Arrays.toString(sortedArray));
    }

    public static void merge(LinkedList otherList) {

    }

    private static int[] mergeSort(int[] unsortedArray) {

        if (unsortedArray.length == 1)
            return unsortedArray;

        int mid = unsortedArray.length / 2;

        int[] leftArray = mergeSort(Arrays.copyOfRange(unsortedArray, 0, mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(unsortedArray, mid, unsortedArray.length));

        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] sortedArray = new int[leftArray.length + rightArray.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                sortedArray[index] = leftArray[i];
                i++;
                index++;
            } else {
                sortedArray[index] = rightArray[j];
                j++;
                index++;
            }
        }

        while (i < leftArray.length) {
            sortedArray[index] = leftArray[i];
            i++;
            index++;
        }

        while (j < rightArray.length) {
            sortedArray[index] = rightArray[j];
            j++;
            index++;
        }


        return sortedArray;

    }


}

class LinkedList {

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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
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

    private Node getMiddle(Node head){
        Node slow=null;
        Node fast=null;

        while (fast==null && fast.next==null)
        {
            slow=head;
            fast=head.next;
            head=head.next.next;
        }
        return slow;

    }

    public void merge(LinkedList otherList) {

        // If the current list is empty, simply point to the other list
        if (this.head == null) {
            this.head = otherList.head;
            return;
        }

        // If the other list is empty, do nothing
        if (otherList.head == null) {
            return;
        }

        // Dummy node to start the merged list
        Node dummy = new Node(-1);
        Node current = dummy;

        Node list1 = this.head;
        Node list2 = otherList.head;

        // Traverse both lists and compare nodes
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }


        // If one list is not empty, append the rest of that list
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // Set the head to the merged list, starting from the next of dummy
        this.head = dummy.next;

    }
/*

    private Node sortedMerge(Node leftNode, Node rightNode) {
        if (leftNode == null)
            return leftNode;

        if (rightNode == null)
            return rightNode;

        Node result = null;
        if (leftNode.value < rightNode.value) {
            result = leftNode;
            result.next = sortedMerge(leftNode.next, rightNode);
        }
        if (rightNode.value < leftNode.value) {
            result = rightNode;
            result.next = sortedMerge(rightNode.next, leftNode);
        }
        return result;
    }

    public void merge(LinkedList otherList) {

        if (otherList.head == null || otherList.head.next == null) {
            return ;
        }

        // Find the middle of the list
        Node middle = getMiddle(otherList.head);
        Node nextOfMiddle = middle.next;

        middle.next = null; // Split the list into two halves

        // Apply merge sort to both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        return merge(left, right);


    }
*/

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

}

