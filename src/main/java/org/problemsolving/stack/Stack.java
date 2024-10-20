package org.problemsolving.stack;

public class Stack {

    Node top;
    int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public Node getTop() {
        System.out.println("top Value " + top.value);
        return top;
    }

    public int getHeight() {
        System.out.println("height" + height);
        return height;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
        } else {
            top.next = newNode;
            top = newNode;
        }
        height++;
    }

    public Node pop()
    {
        if(height==0)
            return null;
        Node temp=top;
        top=top.next;
        temp.next=null;
        height--;
        return temp;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println("top value" + temp.value);
            temp = temp.next;

        }

    }

    private class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
