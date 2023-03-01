import java.util.*;

public class DoublyLinkedList implements List<Comparable<? super T>> {
    private DIntNode header;
    private DIntNode trailer;
    private int size=0;
    public DIntNode getHeader(){
        return header;
    }
    public int getElement(){
        return getTrailPrev().elem;
    }
    public DIntNode getNext(){
        return getTrailPrev().next;
    }
    public DIntNode getTrailPrev(){
       return trailer.prev;
    }
    public DIntNode getHeadNextNext(){
        return header.next.next;
    }
    public DIntNode getTrailer(){
        return trailer;
    }
    public DoublyLinkedList(){ header = null;  trailer = null;} // constructor
    public DoublyLinkedList(DIntNode header, DIntNode trailer){this.header=header;
    this.trailer=trailer;}
    public DIntNode createNode(int element){
        DIntNode c=new DIntNode(element);
        return c;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean isEmpty(){ return ((header==null) && (trailer==null));}

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Comparable<? super T>> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Comparable<? super T> comparable) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Comparable<? super T>> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Comparable<? super T>> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Comparable<? super T> get(int index) {
        return null;
    }

    @Override
    public Comparable<? super T> set(int index, Comparable<? super T> element) {
        return null;
    }

    @Override
    public void add(int index, Comparable<? super T> element) {

    }

    @Override
    public Comparable<? super T> remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Comparable<? super T>> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Comparable<? super T>> listIterator(int index) {
        return null;
    }

    @Override
    public List<Comparable<? super T>> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static class DIntNode { 			// doubly linked list node
        public 	int elem; 		// node element value
        public 	DIntNode prev; 		// previous node in list
        public 	DIntNode next; 		// next node in list
        public DIntNode() { }
        public DIntNode(int data){
            elem = data;
        }}
    public int getSize(){
        return size;
    }
    public void addFront(int value){
        DIntNode v = new DIntNode(value);
        if (header == null)    //check if it is an empty list
            trailer = v;
        else
            header.prev = v;
        v.next = header;
        header = v;
        size++;
    }
    public void addBack(int value) { // add to back of list
        DIntNode v = new DIntNode(value);
        if (trailer == null)    //check if the list is empty
            header = v;
        else
            trailer.next = v;
        v.prev = trailer;
        trailer = v;
        size++;
    }
    public void removeFront()
    {
        if (header.next == null)     //if only one item in the list
            trailer = null;
        else
            header.next.prev = null;
        header = header.next;
        size--;
    }
    public void removeBack()
    {
        if (trailer.prev == null)     //if only one item in the list
            header = null;
        else
            trailer.prev.next = null;
        trailer = trailer.prev;
        size--;
    }public String toString() {
        if (header == null&&trailer==null) {
            return "[]";}
        else if(header==null){
            return "["+trailer.elem+"]";}
        else if(trailer==null){
            return "["+header.elem+"]";}
        else {
            String result = "[" + header.elem;
            DoublyLinkedList.DIntNode current1 = header.next;
            while( current1 != null) {
                result += ", " + current1.elem;
                current1 = current1.next;
            }
            result += "]";
            return result;
        }
    }
    /* public void reverse(){
    if (header == null) return;
    else{
    DIntNode current = header;
    DIntNode temp=null;
        while (current != null) {
        current.prev = current.next;
        current.next = temp;
        temp = current;
        current = current.prev;
    }
    trailer = header;
    header = temp;
}} */
    public void InsertAfter1(DIntNode previous, DIntNode inserted)
    {
        inserted.next = previous.next;
        previous.next = inserted;
        inserted.prev = previous;}
    public void InsertBefore1(DIntNode inserted, DIntNode after)
    {inserted.prev = after.prev;
        after.prev = inserted;
        inserted.next = after;}
    public void removeNodesForDuplicates(DIntNode deleted){
        if (deleted.next != null) {// the previous of deleted is for sure not null since the first element is unique not a duplicate, so no need for if
            deleted.next.prev = deleted.prev;}
            deleted.prev.next = deleted.next;
        return;
    }
    public void reverse(){
        for(int i=0;i<size;i++){
            swapElements(i,size-i-1);
            if(i==((size)/2)-1){break;}
        }
    }
    public void InsertBefore(DIntNode next_node, int new_data)
    {
        /*Check if the given nx_node is NULL*/
        if(next_node == null)
        {
            System.out.println("The given next node can not be NULL");
            return;
        }

        //Allocate node, put in the data
        DIntNode new_node = new DIntNode(new_data);

        //Making prev of new node as prev of next node
        new_node.prev = next_node.prev;

        //Making prev of next node as new node
        next_node.prev = new_node;

        //Making next of new node as next node
        new_node.next = next_node;

        //Check if new node is added as head
        if(new_node.prev != null)
            new_node.prev.next = new_node;
        else
            header = new_node;
    }
    public void InsertAfter(DIntNode prev_Node, int value)
    {

        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
         DIntNode new_node=new DIntNode(value);
        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;

        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;

        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;

        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.prev = new_node;

        /*8. Maintaining tail node if we are inserting after the second last node */
        if (new_node.next==null){
            trailer = new_node;
        }
    }

    public void putValueAtGivenIndex(int value, int index){
        DIntNode current=header;
    for(int i=0;i<index;i++){
       current=current.next;
    }
    current.elem=value;}
public void swapElements(int indexFirst, int indexLast ){
    DIntNode current1=header;
    DIntNode current2=trailer;
    int tempCurrent1Elem=0;
    for(int i=0;i<indexFirst;i++){
            current1=current1.next;
        }
    tempCurrent1Elem=current1.elem;
    for(int i=size-1;i>indexLast;i--){
        current2=current2.prev;
    }
    current1.elem=current2.elem;
    current2.elem=tempCurrent1Elem;
    }
    public void clean(){
    DIntNode current=header;
    DIntNode currentNext=current.next;
    while(current.next!=null){
    while(currentNext!=null){
        if(current.elem==currentNext.elem){
           removeNodesForDuplicates(currentNext);}
           currentNext=currentNext.next;
        }
    current=current.next;
    currentNext=current.next;
    }
    }
   /* public void MergeSort(DoublyLinkedList x, int p, int r){
if (p < r){
    double s = Math.floor((p + r)/2);
    int q=(int) s;
MergeSort(x, p, q);
MergeSort(x, q + 1, r);
Merge(x, p, q, r);}}*/
    public boolean checkIfNull(DIntNode x){
        if(x==null){return true;}
        else if(this.trailer==null) return true;
        else return false;
    }
   public DIntNode mergeLists(DIntNode headA, DIntNode headB) {
       if (headA == null)
           return headB;
       if (headB == null)
           return headA;

       if (headA.elem < headB.elem) {
           headA.next = mergeLists(headA.next, headB);
           headA.next.prev = headA;
           headA.prev = null;
           return headA;
       } else {
           headB.next = mergeLists(headB.next, headA);
           headB.next.prev = headA;
           headB.prev = null;
           return headB;
       }
   }
    public void Merge(DIntNode head){
    DIntNode currentX=head;
       DIntNode currentThis=this.header;
       DIntNode currentXNext=currentX.next;
       DIntNode currentThisNext=currentThis.next;
       DIntNode currentThisNextNext=currentThis.next.next;
       while(currentX!=null&&currentThis!=null){
       if(currentX.elem>=currentThis.elem&&currentX.elem<=currentThis.next.elem){
       InsertAfter(currentThis,currentX.elem);
           currentThis=currentThisNextNext;
           currentX=currentXNext;}
       else if(currentX.elem<currentThis.elem){InsertBefore(currentThis,currentX.elem);
           currentThis=currentThisNextNext;
           currentX=currentXNext;}
       else{currentThis=currentThis.next;}}}}
    /* public void sort(){
       int max=Integer.MIN_VALUE;
       int min=Integer.MAX_VALUE;
       DIntNode currentForward=header;
       DIntNode currentBack=trailer;
       DIntNode headTemp=header;
       DIntNode trailTemp=trailer;
       int i=0;
       while(i<((size-1)/2)){
       while(currentForward!=currentBack){
        if(max<currentForward.elem){max=currentForward.elem;}
        if(min>currentForward.elem){min=currentForward.elem;}
        currentForward=currentForward.next;
        }
       putValueAtGivenIndex(min,i);
       putValueAtGivenIndex(max,size-1-i);
       i++;
       max=Integer.MIN_VALUE;
       min=Integer.MAX_VALUE;
       currentForward=headTemp.next;
       currentBack=trailTemp.prev;
       }*/
