import java.util.*;
import javax.lang.model.util.ElementScanner14;
public class Problem2 {
    public static class BST {
        // class that stores the value of count
        public static class count {
            int c = 0;}
        // A class to store a BST node
        private class Node
        {
            int data;
            Node left = null;
            Node right = null;

            Node(int data) {
                this.data = data;
            }
        }

        private Node overallRoot;   // null for an empty tree

        // constructor
        public BST(){
            overallRoot = null;
        }

        //getting the root
        public Node node(){
            return overallRoot;
        }

        // Recursive function to insert a key into a BST
        Node insertRec(Node root, int key)
        {

        /* If the tree is empty,
           return a new node */
            if (root == null) {
                root = new Node(key);
                return root;
            }
            /* Otherwise, recur down the tree */
            if (key < root.data)
                root.left = insertRec(root.left, key);
            else if (key > root.data)
                root.right = insertRec(root.right, key);

            /* return the (unchanged) node pointer */
            return root;
        }

        public void insert(int key)
        {
            overallRoot = insertRec(overallRoot, key);
        }

        // Function to determine whether a given binary tree is a BST by keeping a
        // valid range (starting from [-INFINITY, INFINITY]) and keep shrinking
        // it down for each node as we go down recursively
        public boolean isBST(Node node, int minKey, int maxKey)
        {

            if(node==null)
                return true;
            if(node.left!=null&&node.left.data>node.data)
                return false;
            if(node.right!=null&&node.right.data<node.data)
                return false;
            if(!isBST(node.left,node.left.data,node.right.data)||!isBST(node.right,node.left.data, node.right.data))
                return false;
            return true;
        }

        // Function to determine whether a given binary tree is a BST
        public void isBST()
        {
            if (isBST(overallRoot, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println("The tree is a BST.");
            }
            else {
                System.out.println("The tree is not a BST!");
            }
        }
        public boolean search(int x) {
            return search(x, overallRoot); // search from virtual root
        }
        private boolean search (int x, Node v) {
            if (v==null) return false; // key not found
            // search left subtree
            if (x < v.data) return search(x, v.left);
            // search right subtree
            else if (x > v.data) return search(x, v.right);
            else return true; // found it here
        }
        private void swap()
        {
            Node left = overallRoot.left;
            overallRoot.left = overallRoot.right;
            overallRoot.right = left;
        }
        int height(Node node)
        {
            if(node==null)
                return 0;
            else {
                int depth1 = height(node.left);
                int depth2 = height(node.right);
                if(depth1>depth2)
                    return depth1+1;
                else return depth2+1;
            }

        }
        public int height(){
            return height(overallRoot);
        }
        boolean isBalanced(Node root)
        {   if(root==null){return true;}
            if(height(root.left)==height(root.right)||height(root.left)==height(root.right)+1||height(root.left)+1==height(root.right))
                 return isBalanced(root.left) && isBalanced(root.right);
            return false;
        }
        boolean isBalanced(){
            return isBalanced(overallRoot);
        }
        // kth largest element
        // utility function to find kth largest number in
        // a given tree
        public Node kthLargestElement(Node root, int k) {
            count counter = new count();
            return kthLargestElement(root, k, counter);
        }

        private static Node kthLargestElement(Node root, int k, count counter) {
            if (root == null) {
                return null;
            }
            Node right = kthLargestElement(root.right, k, counter);
            if (right != null) {
                return right;
            }
            counter.c++;
            if (counter.c == k) {
                return root;
            }
            return kthLargestElement(root.left, k, counter);
        }
        public void trim(int min,int max){
            overallRoot = trim(overallRoot,min,max);}
        public Node trim(Node root,int min,int max){
            if(root == null)
                return null;
            else if(root.data<min){
                return trim(root.right,min,max);
            }
            else if(root.data>max)
                return trim(root.left,min,max);
            else {
                root.left = trim(root.left,min,max);
                root.right = trim(root.right,min,max);
                return root;
            }
        }
        public static void main(String[] args)
        {
            //int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        /*
                        15
                10              20
            8       12      16      25

        */

            //keys test for unbalanced
            int[] keys = { 15, 10, 20, 8, 12, 16, 25, 26, 27, 28, 29 };



            BST bst = new BST();

            for (int key: keys) {
                bst.insert(key);
            }

            // swap left and right nodes (comment this function to get a BST tree)
            //bst.swap();
            bst.isBST();

            //height
            System.out.println(bst.height());


            //search
            System.out.println(bst.search(12));
            System.out.println(bst.search(43));

            //balanced
            System.out.println(bst.isBalanced());
           System.out.println(bst.kthLargestElement(bst.overallRoot, 4).data);
        }

    }}
