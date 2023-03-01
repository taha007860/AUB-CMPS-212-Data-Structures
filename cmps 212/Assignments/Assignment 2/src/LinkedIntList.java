public class LinkedIntList {
    private IntNode head;
    private int size=0;
    public LinkedIntList(){head=null;}
    public IntNode getHead(){
        return head;
    }
    private static class IntNode {
        private int element;
        private IntNode next;
        public IntNode(){
            element=0;
            next=null;
        }
        public IntNode(int element){
            this.element=element;
        }
        public IntNode(int element, IntNode next){
            this.element=element;
            this.next=next;
        }
        public void setElement(int element){
            this.element=element;
        }
        public void setNext(IntNode next){
            this.next=next;
        }
        public int getElement(){
            return element;
        }
        public IntNode getNext(){
            return next;

        }}
    public void setHead(IntNode head){
        this.head=head;
    }
    public void remove(int index){
        if (index == 0) {
            // special case: removing first element
            head = head.next;
        } else {
             IntNode current1 = head;
            // removing from elsewhere in the list
            for (int i = 0; i < index - 1; i++) {
                current1 = current1.next;
            }
            current1.next = current1.next.next;
        }
    }
    public int getSize(){
        return size;
    }
    public void addFirst(int value){
        IntNode v = new IntNode(value);
        v.next=head;
        head = v;
        size++;
    }
    public void removeFirst(){
        head = head.next;
    }
    public boolean isEmpty() {
        return (head==null);
    }
    public void removeLast(){
        if (head.next==null)
            removeFirst();
        else{
            IntNode v =  head;
            while (v.next.next!=null){
                v=v.next;
            }
            v.next = null;
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            String result = "[" + head.element;
            IntNode current1 = head.next;
            while( current1 != null) {
                result += ", " + current1.element;
                current1 = current1.next;
            }
            result += "]";
            return result;
        }
    }
    public void removeEveryOther(){
        int index=0;
        if (head == null || head.next==null) {
            return;
        } else if(size==2){removeLast();}
        else if(size%2==1){
            while(index<((size-1)/2)){
           remove(index+1);
           index++;}}
            else{while (index<((size-1)/2)){
                remove(index+1);
                index++;
            }
            removeLast();}}
            public void compress(int n){
            if(n<1){throw new IllegalArgumentException("should be greater than or equal to 1 ");}
            else if(isEmpty()){return;}
            else if(n>=size){ int sum=0;
                IntNode current1=head;
                IntNode current=head;
                while(current!=null){
                        sum+=current.element;
                        current = current.next;  // move to next node
                    }
                current1.element=sum;
                current1.next=null;}
            else {IntNode current3=head;
                IntNode temp=head;
                int sum=0;
                int count=0;
                while(current3!=null){
                    if(count<n&&temp!=null){
                   sum+=temp.element;
                   temp=temp.next;
                   count++;}
               else{
                   current3.element=sum;
                   current3.next=temp;
                   current3=temp;
                   count=0;sum=0;
                    }}}}}







