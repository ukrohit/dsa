# queue

## Class 
    Node first;
    Node last;
    int length;
## Constructor 
    Node newNode = new Node(value);
    first = newNode;
    last = newNode;
    length = 1;
## Node 
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;

        }
    }
## Enqueue
    Node newNode = new Node(value);
    if (length == 0) {
        first = newNode;
        last = newNode;
    } else {
        last.next = newNode;
        last = newNode;
    }
    length++;

## Dequeue
        if (length == 0)
            return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;