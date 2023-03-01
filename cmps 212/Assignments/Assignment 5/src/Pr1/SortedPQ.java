package Pr1;

import java.util.Comparator;
import java.util.LinkedList;

public class SortedPQ<K,V> {
        //primary collection of priority queue entries
        private LinkedList<Entry1<K,V>> list = new LinkedList<>();
        private Comparator<K> comp;
    public SortedPQ() { comp = new DefaultComparator1<K>(); }

public LinkedList<Entry1<K,V>> getList(){
        return list;
}
    //Creates an empty priority queue based on the natural ordering of its keys.
        // Creates an empty priority queue using the given comparator to order keys.
        public SortedPQ(Comparator<K> comp) {this.comp = comp;}

        public int size() { return list.size(); }
        public boolean isEmpty() { return size() == 0; }
    public boolean exists(K key){
        for(Entry1<K,V> walk:list){
            if(walk.getKey().equals(key))
                return true;
        }
        return false;
    }


        // returns an entry with minimal key.
        public Entry1<K,V> min() {
            if (list.isEmpty()) return null;
            return list.getFirst();
        }
        //Removes and returns an entry with minimal key.
        public Entry1<K,V> removeMin() {
            if (list.isEmpty()) return null;
            return list.removeFirst();
        }
        public int compare(Entry1<K,V> a, Entry1<K,V> b) {
            return comp.compare(a.getKey(), b.getKey());
        }

        //Inserts a key-value pair and returns the entry created.
        public Entry1<K,V> insert(K key, V value) {
            Entry1<K,V> newest = new Entry1<>(key, value);
            // walk forward, looking for larger key
            //to determine the index/position where the entry can be added
            int i=0;
            for(Entry1<K, V> walk: list){
                if (compare(newest, walk) < 0) break;
                i++;
            }
            list.add(i, newest);
            return newest;
        }}
