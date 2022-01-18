package main.java.programs.craftdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int id;
    Node left;
    Node right;

    Node(int data) {
        id = data;
        left = null;
        right = null;
    }
}

public class DeleteNode {

    /**
     * Driver Function
     *
     * @param args main
     */
    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println(isCousin(root, 4, 5));
//        int nodeToDelete = 2;
//
//        List<Integer> list = new ArrayList<>();
//        if (root.id != nodeToDelete) {
//            list.add(root.id);
//        }
//        removeNode(root, nodeToDelete, list);
//        System.out.println(list);
    }

    /**
     * DFS of the binary tree to explore whole tree.
     *
     * @param root         : Current root of the tree
     * @param nodeToDelete : node to be deleted in the binary tree
     * @param list         : contains list of root of all sub-trees formed after deleting a node
     * @return : same node
     */
    private static void removeNode(Node root, int nodeToDelete, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (nodeToDelete == (root.id)) {
            if (root.left != null) {
                list.add(root.left.id);
            }
            if (root.right != null) {
                list.add(root.right.id);
            }
        }

        removeNode(root.left, nodeToDelete, list);
        removeNode(root.right, nodeToDelete, list);

    }

    /**
     * This creates a structured binary tree as given in craft demo sample
     *
     * @return root of Binary Tree
     */
    private static Node createBinaryTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //root.right.right.left = new Node(7);
        return root;
    }

    /**
     *           1
     *         /   \
     *        2     3
     *      / \    / \
     *     4   5  6   7
     *        / \
     *       8   9
     *
     *
     *  BST - 2 nodes are cousins -> 4, 6 ->  ???
     *
     */
    public static int getLevel(Node root, int value, int level){
        if(root == null){
            return 0;
        }

        if(root.id == value){
            return level;
        }

        int left = getLevel(root.left, value, level+1);
        if(left != 0){
            return left;
        }
        else {
            return getLevel(root.right, value, level+1);
        }
    }

    public static boolean isSibling(Node root, int x, int y){

        if(root== null){
            return false;
        }

        return (root.left!= null && root.right!= null && root.left.id == x && root.right.id == y)
                || (root.left!= null && root.right!= null && root.left.id == y && root.right.id == x)
                || isSibling(root.left, x, y)
                || isSibling(root.right, x, y);

    }

    public static boolean isCousin(Node root, int x, int y){
        if(root.id == x || root.id == y || getLevel(root, x, 1) != getLevel(root, y, 1) || isSibling(root, x, y)){
            return false;
        }
        return true;
    }

}
