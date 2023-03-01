import java.util.*;

public class LinkedBinaryTree {
    
    // An IntTreeNode object is one node in a binary tree of ints.
    private class IntTreeNode {
        public int data;            // data stored at this node
        public IntTreeNode left;    // reference to left subtree
        public IntTreeNode right;   // reference to right subtree 
        public IntTreeNode(int data) {// Constructs a leaf node with the given data.
            this(data, null, null);
        }              
        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data; // Constructs a branch node with the given data and links.
            this.left = left;
            this.right = right;
        }
        public List<IntTreeNode> children() {
            List<IntTreeNode> snapshot = new ArrayList<>(2);    // max capacity of 2
            if (left != null)
              snapshot.add(left);
            if (right != null)
              snapshot.add(right);
            return snapshot;
        }
        public int getData(){
            return data;
        }
            
    }

    private IntTreeNode overallRoot;   // null for an empty tree
    private int n = 0;
    public LinkedBinaryTree(){    //constructs an empty tree
        overallRoot=null;
     }
    // constructs a tree with certain number of levels. 
    public LinkedBinaryTree(int level){
        overallRoot=buildTree(3, 0, level);  
    }

    public IntTreeNode buildTree(int m, int counter, int level){ // Builds a tree with certain number of levels. 
        if (level == 0) return null;
        else if (counter < level){
            IntTreeNode left = buildTree(2*m, counter+1, level); // left child has value of 2*m
            IntTreeNode right = buildTree(2*m+1, counter+1, level); //right child has value of 2m + 1
            n++;
            return  new IntTreeNode(m, left, right);
        }
        else return null;
    }
    // Prints the tree in a sideways indented format.
    public void printSideways() {
        printSideways(overallRoot, "");
    }

    private void printSideways(IntTreeNode root, String indent) {
        if (root != null) {
            printSideways(root.right, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "    ");
        }
    }

    public int size() { return n;}

    public boolean isEmpty() { return n==0;}

    public IntTreeNode root(){return overallRoot;}
    
    
    // Traverse Pre Order 
    private void traversePreOrderHelper(IntTreeNode p){
        //write code here
    }
    public void traversePreOrder() {
        if (!isEmpty()){
            traversePreOrderHelper(root());
            System.out.println();
        }
        else{
            System.out.println("Empty tree...");
        }
        
    }

    // Find Element 
    public boolean findElementHelper(IntTreeNode node, int key){
        //write code here
    }
    public boolean findElement(int x){
        if (!isEmpty())
            return findElementHelper(root(), x);   
        return false;
    }

    // Count Odd
    private int countOddHelper(IntTreeNode node){
        //write code here
    }
    public int countOdd(){
        return countOddHelper(root());
    }

    // Count Even
    private int countEvenHelper(IntTreeNode node){
        //write code here
    }
    public int countEven(){
        return countEvenHelper(root());
    }
    

    // Count External Nodes
    private int countExternalNodesHelper(IntTreeNode node)
    {
        //write code here
    }
    public int countExternalNodes(){
        return countExternalNodesHelper(root());
    }

    //Count Internal Nodes
    public int countInternalNodes(){
        //write code here
    }


    // Calculates Height
    private  int maxDepth(IntTreeNode node)
    {
        //write code here
    }

    public int calculateHeight(){
        return maxDepth(root());
    }


    //is Height Balanced?
    public boolean isBST(IntTreeNode node, int minKey, int maxKey){
        //write code here
    }
    public boolean isBST()
    {
        return isBST(root(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }



    //your main tester code
    public static void main(String[] args)
    {
        LinkedBinaryTree tree = new LinkedBinaryTree(3);
        tree.printSideways();
        System.out.println(); 
        System.out.println("Size : " + tree.size()); 
        
        tree.traversePreOrder();

        System.out.println(tree.findElement(3));
        System.out.println(tree.findElement(6));
        System.out.println(tree.findElement(12));
        System.out.println(tree.findElement(13));
        System.out.println(tree.findElement(7));
        System.out.println(tree.findElement(14));
        System.out.println(tree.findElement(15));
        System.out.println(tree.findElement(2));

        System.out.println(tree.countExternalNodes());
        System.out.println(tree.countInternalNodes());
        System.out.println(tree.countEven());
        System.out.println(tree.countOdd());

        System.out.println(tree.calculateHeight());


    }

}


