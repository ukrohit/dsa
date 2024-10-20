package org.problemsolving.doublyLinkedList;

public class DoublyLinkedListMain {

    public static void main(String[] args) {

        DoublyLinkedList dll=new DoublyLinkedList(5);

        dll.append(8);
        dll.append(5);
        dll.append(8);

        /*System.out.println("Head Value : "+dll.getHead().value);


        System.out.println("Tail  Value : "+dll.getHead().value);


        System.out.println("Length Value : "+dll.length);

        dll.append(8);

        dll.prepend(11);
        dll.prepend(15);*/

        dll.print();

      //  System.out.println("is Palendrom : "+dll.isPalindrome());

       // dll.removefirst();

       // dll.insert(1,17);

       dll.swap();
        dll.print();

    }

}
