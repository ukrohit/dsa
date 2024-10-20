package org.problemsolving.doublyLinkedList;

public class DoublyLinkedList {

    int length = 0;
    private Node head = null;
    private Node tail = null;

    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public DoublyLinkedList.Node getHead() {
        return head;
    }

    public DoublyLinkedList.Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void print() {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("index i = " + i + " value:  " + temp.value);
            temp = temp.next;
            i++;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    // remove the last Node from the dopubly linked list
    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {

            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public Node removefirst() {
        if (length == 0)
            return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {

            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > length) {
            return null;
        }
        Node temp = head;
        // this is used when the index is less then half of the index
        if (index <= length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node != null) {
            node.value = value;
            return true;

        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        length++;
        return true;

    }

    public Node remove(int index) {
        if (index < 0 || index > length)
            return null;
        if (length == 0) {
            return removefirst();
        }
        if (index == length) {
            return removeLast();
        }

        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;

    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        // Swap next and prev pointers for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Adjust the head pointer to point to the new head (last node)
        if (temp != null) {
            head = temp.prev;
        }
    }

    public boolean isPalindrome() {

        while (head != null) {
            if (head.value != tail.value)
                return false;
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    public void swapFirstLast() {

        if (length < 2)
            return;
        else {
            Node temp = head;
            head.value = tail.value;
            tail.value = temp.value;
        }

    }

    public void swap() {
        if (head == null || head.next == null) {
            return; // No nodes or only one node, no swap needed
        }

        Node current = head;

        // Swap nodes in pairs
        while (current != null && current.next != null) {
            Node first = current;
            Node second = current.next;

            // Swap pointers of first and second nodes
            Node prevNode = first.prev;
            Node nextNode = second.next;

            // Swap the nodes
            if (prevNode != null) {
                prevNode.next = second;
            } else {
                head = second; // Update the head if swapping the first node
            }

            if (nextNode != null) {
                nextNode.prev = first;
            }

            second.prev = prevNode;
            second.next = first;

            first.prev = second;
            first.next = nextNode;

            // Move to the next pair
            current = first.next;
        }
    }


    class Node {
        int value = 0;
        Node next = null;
        Node prev = null;

        Node(int value) {
            this.value = value;

        }
    }


}
