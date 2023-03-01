import java.util.*;
import java.util.ArrayList;
public class IntRange {
    public void fillRangeInCollection(ArrayList<Integer> x){
        RangeIterator f=new RangeIterator();
        while(f.hasNext()){
         int a=f.next();
         x.add(a);
        }
    }
    public IntRange(int min, int max) {
        this.min = min;
            this.max = max;}
        private int min;
        private int max; // both ends are inclusive
        private class RangeIterator implements Iterator<Integer> {
            int mover;
            public RangeIterator() {
                mover=min;
            }
            public boolean hasNext() {
                return mover<=max;
            }
            public Integer next() {
                return mover++;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
        public static void main(String[] args) {
            IntRange range = new IntRange(7, 15);                         //note for me: return later important exactly like lab
            ArrayList<Integer> s=new ArrayList<>();
            range.fillRangeInCollection(s);
            for (int n : s) {
                System.out.print(n + " "); // 7 8 9 10 11 12 13 14 15
            }

        }
    }
