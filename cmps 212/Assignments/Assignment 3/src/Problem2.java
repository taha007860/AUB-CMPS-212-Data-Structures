import java.util.*;
public class Problem2 {
//3
public static void mirrorHalves(Queue<Integer> x){
    if(x.isEmpty()){return;}
    else if(x==null||x.size()%2==1){throw new EmptyStackException();}
    else{Stack<Integer> stack = new Stack<Integer>();
        int size = x.size();
        int h=0;
        int r=0;
         while(h<size){  //O(n)
                r = x.remove();
                x.add(r);
                stack.push(r);
            if(h==(size-1)/2){
            while(!stack.isEmpty()){
              x.add(stack.pop());
            }}
            else if(h==size-1){
                while(!stack.isEmpty()){
                    x.add(stack.pop());
                }
        }
            h++;
    }
}}
//2
public static boolean hasNegativeSum(List<Integer> x){
    Iterator<Integer> it=x.iterator();
    int sum=0;
    while(it.hasNext()){
    sum=sum+it.next();
    if(sum<0){return true;}
    }
    return false;
}
//1
public static int product(List<Integer> x){
    Iterator<Integer> it=x.iterator();
    int m=1;
    while(it.hasNext()){
        m=m*it.next();
    }
    return m;
}
}
