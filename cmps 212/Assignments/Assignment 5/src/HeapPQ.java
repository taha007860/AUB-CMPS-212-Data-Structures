//Important note: HeapIntPriorityQueue is here also
import java.util.*;
public class HeapPQ<K,V> {
    /** primary collection of priority queue entries */
    private ArrayList<Entry<K,V>> heap = new ArrayList<>();
    private Comparator<K> comp;
    public ArrayList<Entry<K,V>> getHeap(){
        return heap;
    }
    // Creates an empty priority queue using the given comparator to order keys.
    public HeapPQ(Comparator<K> c) {  comp = c;}
    public HeapPQ() { comp = new DefaultComparator<K>(); }
    public int size() { return heap.size(); }
    public boolean isEmpty() { return size() == 0; }
    private int parent(int j) { return (j-1) / 2; }     // truncating division
    private int left(int j) { return 2*j + 1; }
    private int right(int j) { return 2*j + 2; }
    private boolean hasLeft(int j) { return left(j) < heap.size(); }
    private boolean hasRight(int j) { return right(j) < heap.size(); }
    //Exchanges the entries at indices i and j of the array list. */
    private void swap(int i, int j) {
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public ArrayList<Entry<K,V>> children(Entry<K,V> parent, int index){
        if(2*index+1>=size()){throw new IllegalArgumentException("no index for child 1");}
        else if(2*index+2>=size()){throw new IllegalArgumentException("no index for child 2");}
        else{
            int indexChild1= 2*index+1;
            int indexChild2= 2*index+2;
            ArrayList<Entry<K,V>> h=new ArrayList<Entry<K,V>>();
            h.add(heap.get(indexChild1));
            h.add(heap.get(indexChild2));
            return h;
        }}
    public Entry<K,V> parent(Entry<K,V> child, int index){
        if(index<1){throw new IllegalArgumentException("this child has no parent");}
        else{
            int indexParent=(index-1)/2;
            Entry<K,V> g=heap.get(indexParent);
            return g;
        }

    }
    public Entry<K,V> removeMax() {
        if (heap.isEmpty()) return null;
        Entry<K,V> answer = heap.get(0);
        swap(0, heap.size() - 1);              // put minimum item at the end
        heap.remove(heap.size() - 1);          // and remove it from the list;
        downHeapMax(0);                           // then fix new root
        return answer;
    }
    public void searchingMaxSwap(int m, int size){
        int index=0;
        int max=Integer.MIN_VALUE;
        if(heap.get(0).getKey() instanceof Integer){
            for(int i=0;i<size;i++){
                if(max<(int)heap.get(i).getKey()){max=(int)heap.get(i).getKey(); index=i;
                 //   System.out.println(max);
                  //  System.out.println(index);
                    swap(index,m);
                }
            }}
        max=Integer.MIN_VALUE;}
    public void merge(HeapPQ<K,V> x){
        ArrayList<K> n=new ArrayList<>();
        ArrayList<V> v=new ArrayList<>();
        for(int i=0;i<x.size();i++){
            K d=x.heap.get(i).getKey();
            V g=x.heap.get(i).getValue();
            n.add(d);
            v.add(g);
        }
        for(int j=0;j<n.size();j++){
            this.insertForMin(n.get(j),v.get(j));
            //  System.out.println(this.heap.size());
        }
        heapSortMin();
    }
    /*  public String toStringGeneric(){
          String s="[";
              for(Entry i:heap){
                  s=s+i.getKey()+", ";
              }
          s=s+"]";
          return s;
      }*/
    public String toString(){
        String s="[";
        if(heap.get(0).getKey() instanceof Integer){
            for(Entry i:heap){
                s=s+i.getKey()+", ";
            }}
        s=s.substring(0,s.length()-2);
        s=s+"]";
        return s;
    }
    public int[] toArray(){
        // System.out.println(this);
        int[] a=new int[size()];
        // System.out.println(Arrays.toString(a));
        // System.out.println(heap.get(0).getKey());
        int y=(int) heap.get(0).getKey();
        // System.out.println(y);
        if(heap.get(0).getKey() instanceof Integer){
            for(int i=0;i<size();i++){
                //   System.out.println(Arrays.toString(a));
                a[i]= (int) heap.get(i).getKey();
                // Arrays.toString(a);
            }}
        return a;
    }
    public void delete(Integer value){
        Entry<Integer,V> answer=null;
        answer.setKey(value);
        for(int i=0;i<heap.size();i++){
            if(heap.get(i).getKey()==answer.getKey())
                swap(i, size()-1);              // put minimum item at the end
            heap.remove(size()-1);          // and remove it from the list;
            downHeapMin(0);  }                         // then fix new root
    }
    public boolean isConsecutive(){
        boolean b=true;
        ArrayList<K> n=new ArrayList<>();
        ArrayList<V> v=new ArrayList<>();
        for (int i=0;i<heap.size()-1;i++){
            K d=heap.get(i).getKey();
            K p=heap.get(i+1).getKey();
            //  System.out.println((int)d==(int) p-1);
            if((int)d==(int)p-1){continue;}
            else{b=false; break;}
        }
        return b;}
    public void replace(int value1, int value2){
        if (heap.get(0).getKey() instanceof Integer){
            // System.out.println(Arrays.toString(this.toArray()));
            // System.out.println(heap.size());
            int x=((heap.size()/2)-1);
            // for(int y=0;y<=x;y++){
            int index=0;
            for(int i=0;i<(heap.size());i++){
                //  System.out.println(heap.get(0));
                int v=(int) heap.get(i).getKey();
                Entry<Integer,V> l=new Entry<Integer,V>((Integer) value1,heap.get(i).getValue());
                Entry<Integer,V> g=new Entry<Integer,V>((Integer) value2,heap.get(i).getValue());
                // System.out.println();
                //     System.out.println(g.getKey());
                //System.out.println(v);
                //System.out.println(value1);
                // System.out.println(v==value1);
                if(v==value1){ index=i;
                    //  insertForMin((K) g.getKey(),g.getValue());
                    //   System.out.println(Arrays.toString(this.toArray()));
                    //upHeapMin(heap.size()-1);
                    heap.set(index, (Entry<K, V>) g);
                    upHeapMin(index);
                    downHeapMin(index);}
            }
            //System.out.println(Arrays.toString(this.toArray()));
            // heap.remove(index);

            //System.out.println(Arrays.toString(this.toArray()));
            // heapify();
            //  System.out.println(Arrays.toString(this.toArray()));
              /*      ArrayList<Entry<K,V>> u=(children(heap.get(i),i));
                    if(compare(u.get(0),u.get(1))<0&&compare(heap.get(i),u.get(0))>0){swap(i,2*i+2);}
                    else if(compare(u.get(0),u.get(1))>0&&compare(heap.get(i),u.get(1))>0){swap(i,2*i+1);}}
                  else{ArrayList<Entry<K,V>> s=(children(heap.get(i),i));
                    if(compare(s.get(0),s.get(1))<0&&compare(heap.get(i),s.get(0))>0){swap(i,2*i+2);}
                    else if(compare(s.get(0),s.get(1))>0&&compare(heap.get(i),s.get(1))>0){swap(i,2*i+1);}}
            }*/
        }}
    public ArrayList<Integer> toArrayIntoList(int[] a){
        ArrayList<Integer> x=new ArrayList<>();
        for(int i:a){
            x.add(i);
        }
        return x;
    }
    public boolean checkEqual(ArrayList<Integer> b){
        boolean p=true;
        for(int i=0;i<b.size();i++){
            if(b.get(i)==(int)heap.get(i).getKey()){continue;}
            else{p=false;break;}
        }
        return p;
    }
    public void heapSortMin(){
        //System.out.println(this);
        int size1=heap.size();
        // System.out.println(size1);
        ArrayList<Integer> v=this.toArrayIntoList(this.toArray());
        // System.out.println(checkEqual(v));
        Collections.sort(v);
        // System.out.println(v);
        for (int c=0;c<size1;c++){
          //  System.out.println(v);
            if(checkEqual(v)) break;
            //   System.out.println(Arrays.toString(this.toArray()));
            //  System.out.println(checkEqual(v));
            // if(this.checkEqual(v)){break;}
            // ArrayList<Integer> l=Collections.sort(v);
            int index=(size1/2)-1;
            // System.out.println(index);
            // System.out.println(heap);
            // System.out.println(this.checkEqual(v));
            // System.out.println(heap.get(index+2).getKey());
            if(compare(heap.get(index),heap.get(2*index+1))<=0) {swap(index,2*index+1);// System.out.println(heap); //System.out.println(checkEqual(v));
                if(this.checkEqual(v))
                {//System.out.println(v);
                    break;}}
            //  System.out.println(v);
            // System.out.println(this);
            //System.out.println(Arrays.toString(this.toArray()));
            index--;
            while(index>=0){
                // if(checkEqual(v)){c=Integer.MAX_VALUE; break;}
                //  System.out.println(index);
                ArrayList<Entry<K,V>> s=(children(heap.get(index),index));
                //System.out.println(s.get(0).getKey());
                //System.out.println(s.get(1).getKey());
                if(compare(s.get(0),s.get(1))<=0&&compare(heap.get(index),s.get(1))<=0) {
                    swap(index, 2 * index + 1);
                    if (checkEqual(v)) {
                        break;
                    }
                    //System.out.println(this);
                    //  System.out.println(Arrays.toString(this.toArray()));}
                }
                else if(compare(s.get(0),s.get(1))>=0&&compare(heap.get(index),s.get(0))<=0) {
                    swap(index, 2 * index + 2);
                    if (checkEqual(v)) {
                        break;
                    }
                    // System.out.println(this);
                    // System.out.println(Arrays.toString(this.toArray()));}
                }
                index--; }
        }
        //  System.out.println(this);
       /* int size=heap.size();
        int size2=heap.size();
        int temp=heap.size()-1;
        for(int z=0;z<size;z++){
            searchingMaxSwap(temp,size2);
           // System.out.println(this);
            temp--;
            size2--;*/
        }

    }
    /*  public void addLast(K x, V v){
          Entry<K,V> k=new Entry<>(x,v);
          if(x instanceof Integer){
          heap.add(k);
      }}*/
    public void upHeapMax(int j) {
        while (j > 0) {        // continue until reaching root (or break statement)
            int p = parent(j);
            // heap property verified
            if (compare(heap.get(j), heap.get(p)) <= 0) break;
            swap(j, p);
            j = p;                                // continue from the parent's location
        }
    }
    // Moves the entry at index j lower, if necessary, to restore the heap property.
    public void downHeapMax(int j) {
        while (hasLeft(j)) {               // continue to bottom (or break statement)
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;     // although right may be smaller
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) < 0)
                    smallChildIndex = rightIndex;  // right child is smaller
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) <= 0)
                break;                          // heap property has been restored
            swap(j, smallChildIndex);
            j = smallChildIndex;                 // continue at position of the child
        }
    }
    public void upHeapMin(int j) {
        while (j > 0) {        // continue until reaching root (or break statement)
            int p = parent(j);
            // heap property verified
            if (compare(heap.get(j), heap.get(p)) >= 0) break;
            swap(j, p);
            j = p;                                // continue from the parent's location
        }
    }
    // Moves the entry at index j lower, if necessary, to restore the heap property.
    public void downHeapMin(int j) {
        while (hasLeft(j)) {               // continue to bottom (or break statement)
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;     // although right may be smaller
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;  // right child is smaller
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break;                          // heap property has been restored
            swap(j, smallChildIndex);
            j = smallChildIndex;                 // continue at position of the child
        }
    }
    public Entry<K,V> insertForMax(K key, V value) {
        Entry<K,V> newest = new Entry<>(key, value);
        heap.add(newest);                      // add to the end of the list
        upHeapMax(heap.size() - 1);               // upHeap newly added entry
        return newest;
    }

    //Inserts a key-value pair and returns the entry created.
    public Entry<K,V> insertForMin(K key, V value) {
        Entry<K,V> newest = new Entry<>(key, value);
        heap.add(newest);                      // add to the end of the list
        upHeapMin(heap.size() - 1);               // upHeap newly added entry
        return newest;
    }
    // returns an entry with minimal key.
    public Entry<K,V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }
    //Removes and returns an entry with minimal key.
    public Entry<K,V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K,V> answer = heap.get(0);
        swap(0, heap.size() - 1);              // put minimum item at the end
        heap.remove(heap.size() - 1);          // and remove it from the list;
        downHeapMin(0);                           // then fix new root
        return answer;
    }
    public void swapValues(int first, int second){
        int temp=first;
        first=second;
        second=temp;
    }
    // Method for comparing two entries according to key
    public int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }
    public HeapPQ(K[] keys, V[] values) {
        //comp=new DefaultComparator<K>();
        for (int j=0; j < Math.min(keys.length, values.length); j++)
            heap.add(new Entry<>(keys[j], values[j]));
        heapifyForMax();
    }

    // Performs a bottom-up construction of the heap in linear time.
    void heapifyForMax() {
        int startIndex = parent(size()-1);    // start at PARENT of last entry
        for (int j=startIndex; j >= 0; j--)   // loop until processing the root
            downHeapMax(j);
    }
    void heapifyForMin(){
        int startIndex = parent(size()-1);    // start at PARENT of last entry
        for (int j=startIndex; j >= 0; j--)   // loop until processing the root
            downHeapMin(j);
    }
}

