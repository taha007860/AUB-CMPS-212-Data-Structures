import java.util.*;
public class BST {
    //Problem 1:
    //Problem 2:
    //pre-order: 3 5 1 2 4 6
    //in-order: 1 5 3 4 2 6
    //post-order: 1 5 4 6 2 3
    //Problem 3:
    private static class LinkedBinaryTree {
        // An IntTreeNode object is one node in a binary tree of ints.
        private static class IntTreeNode {
            public int data;            // data stored at this node
            public IntTreeNode left;    // reference to left subtree
            public IntTreeNode right;   // reference to right subtree
            public IntTreeNode(int data) {// Constructs a leaf node with the given data.
                this(data, null, null);}
            public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
                this.data = data; // Constructs a branch node with the given data and links.
                this.left = left;
                this.right = right;
            }
            public void setLeft(IntTreeNode left){
                this.left=left;
            }
            public void setRight(IntTreeNode right){
                this.right=right;
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
            }}
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
        /*public void changeValues(int index, int replacement){
            List<Integer> x=new ArrayList<>();
        x.set(index,replacement);
        }*/

        // Traverse Pre Order
        private void traversePreOrderHelper(IntTreeNode p){
                if (p != null) {
                    System.out.print(p.data+" ");
                    traversePreOrderHelper (p.left);
                    traversePreOrderHelper (p.right);
                }
            }
        public void traversePreOrder() {
            if (!isEmpty()){
                traversePreOrderHelper(root());
                System.out.println();
            }
            else{
                System.out.println("Empty tree...");
            }}

        // Find Element
       /* works for tree1 only (adding nodes)
       private boolean findElementHelper(IntTreeNode root, int key){
            // start at root
            IntTreeNode current = root;
            // while no match,
            while(current.data != key){
                if(key < current.data )
                    // go left?
                    current = current.left;
                else
                    // or go right?
                    current = current.right;
                // if no child,
                if(current == null)
                    return false;
            }
            return true; 	// found it
        }	 // e
        public boolean findElement(int x){
            if (!isEmpty())
                return findElementHelper(overallRoot,x);
            return false;
        }*/

        // Count Odd
        private static class NodeBuilder
        { public IntTreeNode node;
            public NodeBuilder() {
                node = null;}
            NodeBuilder(int data) {
                this.node = new IntTreeNode(data);}}

        private int countOddHelper(){
            int count=0;
            List<IntTreeNode> x=preorder();
            for(IntTreeNode i: x){
                if(i.data%2==1){count++;}
            }
            return count;
        }
        public int countOdd(){
           return countOddHelper();
        }
        public boolean findElement1(int value){
            List<IntTreeNode> x=preorder();
            for(IntTreeNode i: x){
                if(i.data==value) return true;
            }
            return false;
        }
        // Count Even
        private int countEvenHelper(){
            int count=0;
            List<IntTreeNode> x=preorder();
            for(IntTreeNode i: x){
                if(i.data%2==0){count++;}
            }
            return count;
        }
        public int countEven(){
            return countEvenHelper();
        }


        // Count External Nodes
        private int countExternalNodesHelper()
        {
            int count=0;
            List<IntTreeNode> x=preorder();
            for(IntTreeNode i: x){
            if(i.children().size()==0){count++;}
            }
        return count;}
        public int countExternalNodes(){
            return countExternalNodesHelper();
        }

        //Count Internal Nodes
        public int countInternalNodes(){
            int count=0;
            List<IntTreeNode> x=preorder();
            for(IntTreeNode i: x){
                if(i.children().size()==1||i.children().size()==2){count++;}
            }
            return count;
        }

        // Calculates Height
        private  int maxDepth(IntTreeNode node)
        {
            if(node==null)
                return 0;
            else {
                int depth1 = maxDepth(node.left);
                int depth2 = maxDepth(node.right);
                if(depth1>depth2)
                    return depth1+1;
                else return depth2+1;
            }}

        public int calculateHeight(){
            return maxDepth(root());
        }
        public List<IntTreeNode> preorder() {
            List<IntTreeNode> snapshot=new ArrayList<>();
            if (!isEmpty())
                // fill the snapshot recursively
                preorderSubtree(overallRoot, snapshot);
            return snapshot;
        }

        private void preorderSubtree(IntTreeNode p, List<IntTreeNode> snapshot) {
            snapshot.add(p);
            // we add p before exploring subtrees
            for (IntTreeNode c : p.children())
                preorderSubtree(c, snapshot);
        }
        public List<Integer> preorder1() {
            List<Integer> snapshot=new ArrayList<>();
            if (!isEmpty())
                // fill the snapshot recursively
                preorderSubtree1(overallRoot, snapshot);
            return snapshot;
        }

        private void preorderSubtree1(IntTreeNode p, List<Integer> snapshot) {
            snapshot.add(p.data);
            // we add p before exploring subtrees
            for (IntTreeNode c : p.children())
                preorderSubtree1(c, snapshot);
        }
        public List<Integer> inorder() {
            List<Integer> snapshot = new ArrayList<>();
            if (!isEmpty())
                inorderSubtree(overallRoot, snapshot);   // fill the snapshot recursively
            return snapshot;
        }
      /*  public List<IntTreeNode> preorder1() {
            List<IntTreeNode> snapshot = new ArrayList<>();
            if (!isEmpty())
                // fill the snapshot recursively
                preorderSubtree1(root(), snapshot);
            return snapshot;
        }

        private void preorderSubtree1(IntTreeNode p, List<IntTreeNode> snapshot) {
            snapshot.add(p);        // we add p before exploring subtrees
            for (IntTreeNode c : p.children())
                preorderSubtree1(c, snapshot);
        }*/

        private void inorderSubtree(IntTreeNode p, List<Integer> snapshot) {
            if (p.left != null)
                inorderSubtree(p.left, snapshot);
            snapshot.add(p.data);
            if (p.right != null)
                inorderSubtree(p.right, snapshot);
        }
        /* public boolean isBST(IntTreeNode node, int minKey, int maxKey)
        {

            if(node==null)
                return true;
             if(node.left!=null&&node.left.data<node.data)
                return false;
             if(node.right!=null&&node.right.data>node.data)
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
        */
       //public void correctBSTHelper(IntTreeNode current) {
            /*if(current!=null){
            if(current.left!=null){
            if(!(current.left.data>leftMin&&current.left.data<leftMax)){
                setValue(leftMax,current.left.data);
            }}
            if(current.right!=null){
            if(!(current.right.data>rightMin&&current.right.data<rightMax)){
                setValue(rightMin,current.right.data);
            }}
            correctBSTHelper(current.left,leftMin,rightMax,leftMax,rightMin);
            correctBSTHelper(current.right,leftMin,rightMax,leftMax,rightMin);}}

            if(current==null){return;}
            else{
            int tempLeft=current.data;
            int tempRight=current.data;
            if(current.left!=null&&current.right==null&&current.left.data>current.data){
             current.data=current.left.data;
            current.left.data=tempLeft;
            System.out.println(preorder());}
            if(current.right!=null&&current.left==null&&current.right.data<current.data){
                current.data=current.right.data;
            current.right.data=tempRight;
            System.out.println(preorder());}
                correctBSTHelper(current.left);
                correctBSTHelper(current.right);
            }}*/

        // post: value is added to overall tree in order to preserve the
        //       binary search tree property

        public void add(int value) {
            overallRoot = add(overallRoot, value);
        }
        public static void correctBSTHelper(IntTreeNode current, NodeBuilder n, NodeBuilder m, NodeBuilder previous)
        {if (current == null) {
                return;}
            correctBSTHelper(current.right, n, m, previous);
            if (current.data > previous.node.data)
            {if (n.node == null) {
                    n.node = previous.node;}
                m.node = current;}
            previous.node = current;
            correctBSTHelper(current.left, n, m, previous);}
        public static void correctBST(IntTreeNode current) {
            NodeBuilder n = new NodeBuilder();
            NodeBuilder m = new NodeBuilder();
            NodeBuilder previous = new NodeBuilder(Integer.MAX_VALUE);
            correctBSTHelper(current, n, m, previous);
                swapNodeValues(n.node, m.node);
            }
            public static void swapNodeValues(IntTreeNode first, IntTreeNode second)
        {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
        private IntTreeNode add(IntTreeNode rt, int value) {
            if (rt == null) {
                rt = new IntTreeNode(value);
                n++;

            } else if (value <= rt.data) {
                rt.setLeft(add(rt.left, value));

            } else {
                rt.setRight(add(rt.right, value));

            }
            return rt;
        }
        //your main tester code
        public static void main(String[] args)
        {LinkedBinaryTree tree = new LinkedBinaryTree(4);
            LinkedBinaryTree tree1=new LinkedBinaryTree();
            tree1.add(5);
            tree1.add(3);
            tree1.add(8);
            tree1.add(4);
            tree1.add(2);
            tree1.add(6);
            tree1.add(10);
            System.out.println(tree1.findElement1(3));
            System.out.println(tree1.findElement1(6));
            System.out.println(tree1.findElement1(12));
            System.out.println(tree1.findElement1(13));
            System.out.println(tree1.findElement1(7));
            System.out.println(tree1.findElement1(14));
            System.out.println(tree1.findElement1(5));
            System.out.println(tree1.findElement1(2));
            System.out.println(tree1.findElement1(4));
            System.out.println();
            System.out.println(tree.findElement1(3));
            System.out.println(tree.findElement1(6));
            System.out.println(tree.findElement1(12));
            System.out.println(tree.findElement1(13));
            System.out.println(tree.findElement1(7));
            System.out.println(tree.findElement1(14));
            System.out.println(tree.findElement1(5));
            System.out.println(tree.findElement1(2));
            System.out.println(tree.findElement1(4));
            System.out.println(tree.preorder1());
            System.out.println();
            System.out.println(tree1.preorder1());
            tree1.traversePreOrder();
            tree1.printSideways();
            System.out.println();
            swapNodeValues(tree1.overallRoot.left.left,tree1.overallRoot.right.right);//to test
            tree1.printSideways();
            System.out.println(tree1.preorder1());
            correctBST(tree1.overallRoot);
            System.out.println(tree1.preorder1());
            System.out.println();
            tree1.printSideways();
            System.out.println();
            tree.printSideways();
            System.out.println();
            System.out.println("Size : " + tree.size());
            System.out.println("Size : "+tree1.size());
            tree.traversePreOrder();
            System.out.println(tree.countExternalNodes());
            System.out.println(tree.countInternalNodes());
            System.out.println(tree.countEven());
            System.out.println(tree.countOdd());
            System.out.println(tree.calculateHeight());


        }

    }}
