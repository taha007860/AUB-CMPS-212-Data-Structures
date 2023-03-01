public class Entry<K,V> {
        private K k;  // key
        private V v;  // value

        public Entry(K key, V value) {
            k = key;
            v = value;
        }

    // methods of the Entry interface
        public K getKey() { return k; }
        public V getValue() { return v; }

        // utilities not exposed as part of the Entry interface
        public void setKey(K key) { k = key; }
        public void setValue(V value) { v = value; }
    }
