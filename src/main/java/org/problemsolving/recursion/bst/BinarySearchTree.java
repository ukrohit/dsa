package org.problemsolving.recursion.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    BinarySearchTree.Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int value) {
        BinarySearchTree.Node newNode = new BinarySearchTree.Node(value);
        if (root == null)
            root = newNode;

        BinarySearchTree.Node temp = root;
        while (true) {
            if (temp.value == newNode.value)
                return false;

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {

                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }


    public boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        if (value < root.value)
            return contains(root.left, value);
        else
            return contains(root.right, value);
    }

    public boolean contains(int value) {
        return contains(root, value);

    }


    private Node rinsert(Node currentNode, int value) {
        if (currentNode == null)
            return new Node(value);

        if (value < currentNode.value)
            currentNode.left = rinsert(currentNode.left, value);
        else if (value > currentNode.value)
            currentNode.right = rinsert(currentNode.right, value);

        return currentNode;
    }

    public void rinsert(int value) {
        rinsert(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null)
            return null;

        if (value < currentNode.value)
            currentNode.left = deleteNode(currentNode.left, value);
        else if (value > currentNode.value)
            currentNode.right = deleteNode(currentNode.right, value);
        else {
            // if the leaf node
            if (currentNode.left == null && currentNode.right == null)
                return null;
            else if (currentNode.right == null) {
                // dont have right node but only have left node
                currentNode = currentNode.left;
            } else if (currentNode.left == null) {
                // dont half left node only have right node
                currentNode = currentNode.right;
            } else {
                //have both left and right node in this case need to find the min node
                // and change the value of the node with min node
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode = deleteNode(currentNode.right, subTreeMin);
            }


            //have both left and right node
        }
        return currentNode;
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        Node rootNode = new Node(nums[mid]);

        rootNode.left = sortedArrayToBST(nums, left, mid - 1);
        rootNode.right = sortedArrayToBST(nums, mid + 1, right);

        return rootNode;
    }

    public Node sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public void invertNode(Node currentNode) {

        Node remp = currentNode.left;
        currentNode.left = currentNode.right;
        currentNode.right = remp;


        invertNode(currentNode.left);
        invertNode(currentNode.right);
    }

    public ArrayList bfs() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList();
        ArrayList result = new ArrayList();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            result.add(currentNode.value);

            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }

        return result;
    }


    public ArrayList dfsPreOrder() {

        ArrayList result = new ArrayList();

        class Traverse {

            Traverse(Node currentNode) {
                result.add(currentNode.value);

                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }

            }
        }

        new Traverse(root);

        return result;
    }

    public ArrayList dfsPostOrder() {

        ArrayList result = new ArrayList();

        class Traverse {

            Traverse(Node currentNode) {


                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                result.add(currentNode.value);
            }
        }

        new Traverse(root);

        return result;
    }

    public ArrayList dfsIntOrder() {

        ArrayList result = new ArrayList();

        class Traverse {

            Traverse(Node currentNode) {


                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                result.add(currentNode.value);

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }

            }
        }

        new Traverse(root);

        return result;
    }


    private class Node {
        int value;
        BinarySearchTree.Node left;
        BinarySearchTree.Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
