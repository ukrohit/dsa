package org.problemsolving.queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue=new Queue(5);
        queue.enquque(7);
        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.printQueue();
    }
}
