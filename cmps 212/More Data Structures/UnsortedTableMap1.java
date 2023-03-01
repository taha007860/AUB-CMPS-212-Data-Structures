
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap1<K,V> implements Map<K,V> {
  /** Underlying storage for the map of entries. */
  private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

  /** Constructs an initially empty map. */
  public UnsortedTableMap1() { }

  public boolean isEmpty() { return size() == 0; }


  // private utility
  /** Returns the index of an entry with equal key, or -1 if none found. */
  private int findIndex(K key) {
    int n = table.size();
    for (int j=0; j < n; j++)
      if (table.get(j).getKey().equals(key))
        return j;
    return -1;                                   // special value denotes that key was not found
  }

  public boolean containsKey(K key){
    int j = findIndex(key);
    if (j == -1) return false;   
    return true;  
  }

  // public methods
  /**
   * Returns the number of entries in the map.
   * @return number of entries in the map
   */
  public int size() { return table.size(); }

  /**
   * Returns the value associated with the specified key, or null if no such entry exists.
   * @param key  the key whose associated value is to be returned
   * @return the associated value, or null if no such entry exists
   */
  public V get(K key) {
    int j = findIndex(key);
    if (j == -1) return null;                         // not found
    return table.get(j).getValue();
  }

  /**
   * Associates the given value with the given key. If an entry with
   * the key was already in the map, this replaced the previous value
   * with the new one and returns the old value. Otherwise, a new
   * entry is added and null is returned.
   * @param key    key with which the specified value is to be associated
   * @param value  value to be associated with the specified key
   * @return the previous value associated with the key (or null, if no such entry)
   */
  public V put(K key, V value) {
    int j = findIndex(key);
    if (j == -1) {
      table.add(new MapEntry<>(key, value));          // add new entry
      return null;
    } else                                            // key already exists
      return table.get(j).setValue(value);            // replaced value is returned
  }

  /**
   * Removes the entry with the specified key, if present, and returns its value.
   * Otherwise does nothing and returns null.
   * @param key  the key whose entry is to be removed from the map
   * @return the previous value associated with the removed key, or null if no such entry exists
   */
  public V remove(K key) {
    int j = findIndex(key);
    int n = size();
    if (j == -1) return null;                         // not found
    V answer = table.get(j).getValue();
    if (j != n - 1)
      table.set(j, table.get(n-1));                   // relocate last entry to 'hole' created by removal
    table.remove(n-1);                                // remove last entry of table
    return answer;
  }

  public String toString() { 
    String result="[" ;
    int n = table.size();
    for (int j=0; j < n; j++){
      result = result+table.get(j).toString();
      if (j != n-1) result = result + ", ";
    }
    result = result + "]";  
    return result;              
  }

  //---------------- nested KeyIterator class ----------------
  private class KeyIterator implements Iterator<K> {
    private Iterator<MapEntry<K,V>> entries = entrySet().iterator();   // reuse entrySet
    public boolean hasNext() { return entries.hasNext();} 
    public K next() { return entries.next().getKey(); }             // return key!
    public void remove() { throw new UnsupportedOperationException("remove not supported"); }
  } //----------- end of nested KeyIterator class -----------


  //---------------- nested KeyIterable class ----------------
  private class KeyIterable implements Iterable<K> {
    public Iterator<K> iterator() { 
      return new KeyIterator(); }
  } //----------- end of nested KeyIterable class -----------



  public Iterable<K> keySet() { return new KeyIterable(); }

  //---------------- nested ValueIterator class ----------------
  private class ValueIterator implements Iterator<V> {
    private Iterator<MapEntry<K,V>> entries = entrySet().iterator();   // reuse entrySet
    public boolean hasNext() { return entries.hasNext(); }
    public V next() { return entries.next().getValue(); }           // return value!
    public void remove() { throw new UnsupportedOperationException("remove not supported"); }
  } //----------- end of nested ValueIterator class -----------

  //---------------- nested ValueIterable class ----------------
  private class ValueIterable implements Iterable<V> {
    public Iterator<V> iterator() { return new ValueIterator(); }
  } //----------- end of nested ValueIterable class -----------

  /**
   * Returns an iterable collection of the values contained in the map.
   * Note that the same value will be given multiple times in the result
   * if it is associated with multiple keys.
   *
   * @return iterable collection of the map's values
   */
  public Iterable<V> values() { return new ValueIterable(); }

  //---------------- nested EntryIterator class ----------------
  private class EntryIterator implements Iterator<MapEntry<K,V>> {
    private int j=0;
    public boolean hasNext() { return j < table.size(); }
    public MapEntry<K,V> next() {
      if (j == table.size()) throw new NoSuchElementException("No further entries");
      return table.get(j++);
    }
    public void remove() { 
      throw new UnsupportedOperationException("remove not supported"); 
    }
  } //----------- end of nested EntryIterator class -----------

  //---------------- nested EntryIterable class ----------------
  private class EntryIterable implements Iterable<MapEntry<K,V>> {
    public Iterator<MapEntry<K,V>> iterator() { 
      return new EntryIterator(); 
    }
  } //----------- end of nested EntryIterable class -----------

  /**
   * Returns an iterable collection of all key-value entries of the map.
   *
   * @return iterable collection of the map's entries
   */
  public Iterable<MapEntry<K,V>> entrySet() { 
    return new EntryIterable(); 
  }
  
  public boolean isSubMap(UnsortedTableMap1 map2){
    Iterator<Integer> itr = map2.keySet().iterator();
    for ((): table ){
      if(!map2.containsKey(table.get() || map2.get(itr.next()) == table.get(MapEntry K))){
        return false;
      }
      else return true;
    }
  }
}
