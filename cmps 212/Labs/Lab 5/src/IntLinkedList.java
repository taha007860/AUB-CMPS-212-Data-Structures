public class IntLinkedList {
    public class IntNode {
        int elem;
        IntNode next;

        public IntNode() {
            elem = 0; // this(0, null)
            next = null;
        }

        public IntNode(int data) {
            this.elem = data; // this(data, null)
            this.next = null;
        }

        public IntNode(int data, IntNode next) {
            this.elem = data;
            this.next = next;
        }
    }

    public IntNode getHead() {
        return head;
    }
    private IntNode head;
    public IntLinkedList() {
        head = null;
    }
    //number 6
    public void addFirst(int value) {
        IntNode v = new IntNode(value);
        v.next = head;
        head = v;
    }

    public int first() {
        return head.elem;
    }

    public void removeFirst() {
        head = head.next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            String result = "[" + head.elem;
            IntNode current = head.next;
            while (current != null) {
                result += ", " + current.elem;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    //number 7
    public void delete(int value){
        IntNode current = head;
        while(current!=null){
            if(current.elem!=value)
                current = current.next;
            else break;
        }
        current = current.next;}
    public double avgRec(IntNode n, double sum, double count){
        if(n.next==null){
            sum += n.elem;
            count++;
            return (sum*1.0/count); }
        else {
            sum = sum+n.elem;
            count++;
            return avgRec(n.next, sum, count);
        }

    }
    public boolean isIdentical(IntNode a,IntNode b){
        if(a.next == null || b.next == null ) {
            if (a.next == b.next)
                return true;
            else
                return false;
        }
        else if(a.elem == b.elem)
            return isIdentical(a.next,b.next);
        else
            return false;
    }
    // Split a doubly linked list (DLL) into 2 DLLs of
    // half sizes
    //number 9
    IntNode split(IntNode head) {
        IntNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        IntNode temp = slow.next;
        slow.next = null;
        return temp;
    }
    /* Function 3 to remove duplicates  */
    //number 8
    void clean()
    {
        IntNode ptr1 = null, ptr2 = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.elem== ptr2.next.elem) {

                    /* sequence of steps is important here
                     */
                    ptr2.next = ptr2.next.next;
                    System.gc();
                }
                else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public static void main(String[] args) {
        IntLinkedList a = new IntLinkedList();
        a.addFirst(5);
        a.addFirst(9);
        a.addFirst(9);
        a.addFirst(8);
        a.clean();
        System.out.println(a);
        a.split(a.head);
        System.out.println(a);
        IntLinkedList b = new IntLinkedList();
        b.addFirst(5);
        b.addFirst(9);
        b.addFirst(9);
        System.out.println(a.avgRec(a.head,0,0));

        System.out.println(a);
        System.out.println(b);
        System.out.println(a.isIdentical(a.head,b.head));}
}
