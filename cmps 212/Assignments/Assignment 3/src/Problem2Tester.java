import java.util.*;
public class Problem2Tester {
    public static void main(String[] args){
        int[] x={10, 50, 19, 54, 30, 67};
        int[] v={6, 11, -20, 7, 14, 93};
        int[] o={6, 15, -20, 7, -4, 5, -9};
        List<Integer> b=new ArrayList<>();
        List<Integer> c=new ArrayList<>();
        Queue<Integer> h=new LinkedList<>();
        for(int s: x){
         h.add(s);
        }
        for(int t: v){
            b.add(t);
        }
        for(int q: o){
         c.add(q);
        }
        System.out.println(h);
        Problem2.mirrorHalves(h);
        System.out.println(h);
        System.out.println(b);
        System.out.println(Problem2.hasNegativeSum(b));
        System.out.println(c);
        System.out.println(Problem2.hasNegativeSum(c));
        System.out.println(Problem2.product(c));}}

