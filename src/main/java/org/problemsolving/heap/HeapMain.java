package org.problemsolving.heap;

public class HeapMain {

    public static void main(String[] args) {
        Heap heap=new Heap();
        heap.insert(99);
        heap.insert(72);
        heap.insert(65);
        heap.insert(23);
        heap.insert(51);

        System.out.println(heap.getHeap());

        heap.insert(100);

        System.out.println(heap.getHeap());

        // Kth Smllest number

        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + heap.findKthSmallest(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " +  heap.findKthSmallest(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " +  heap.findKthSmallest(nums3, k3));
        System.out.println();



    }
}
