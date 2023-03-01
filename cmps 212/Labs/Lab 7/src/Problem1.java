import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;
    public class Problem1 {
        public static void main(String[] args) {
            int[] x={6, 7, 2, 4, 5, 5};
            ArrayList<Object> f = new ArrayList<>();
            ArrayList<Integer> n=new ArrayList<>();
            for(int a: x){
                f.add(a);
                n.add(a);}
            Replace(f,5,9, 2);
            System.out.println(f);
            System.out.println(Arrays.toString(removePrime(n)));}
        public static void Replace(ArrayList<Object> f, Object first, Object second, int occurrence){
            int count=0;
            for (int i = 0; i < f.size(); i++) {
                if (first.equals(f.get(i))) {
                    f.set(i, second);
                    count++;}}
            if(count>occurrence)
                throw new IndexOutOfBoundsException();}
        public static boolean isPrime(int number){
            for(int i=2;i<=Math.sqrt(number);i++){
                if(number%i==0)
                    return false;}
            return true;}
        public static int[] removePrime(ArrayList<Integer> x){
            ArrayList<Integer> ans = new ArrayList<>();
            Iterator<Integer> it=x.iterator();
            while(it.hasNext()){
                Integer i=it.next();
                if(isPrime(i)){
                    ans.add(i);}}
            Collections.sort(ans);
            int[] b = new int[ans.size()];
            for (int i=0;i<b.length;i++)
            {b[i]=ans.get(i);}
            return b;
        }}

