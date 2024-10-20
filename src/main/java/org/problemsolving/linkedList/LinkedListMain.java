package org.problemsolving.linkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.append(3);
       /* ll.append(4);
        ll.append(7);
        ll.append(1);
        ll.append(2);
        ll.append(6);*/
       ll.deleteMiddle();
        ll.printList();



    }
}
