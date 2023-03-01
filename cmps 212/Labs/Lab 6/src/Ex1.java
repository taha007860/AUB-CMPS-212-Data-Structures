import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Ex1 {
        public static void main(String[] args) {
            Stack<Integer> a = new Stack<>();
            int[]  m ={2, 8,-8,-8, 3, 19, 43, 7, 3, 2, 42, 9, 56, 2, 7, 12, -8, 4};
            for(int i =0;i<m.length;i++)
                a.add(m[i]);
            System.out.println(removeMIN(a));
            System.out.println(a);
            System.out.println(removeMIN(a));
            System.out.println(a);
            System.out.println(removeMIN(a));
            System.out.println(a);
            System.out.println(removeMIN(a));
            System.out.println(a);
            System.out.println(removeMIN(a));
            System.out.println(a);}
        public static int removeMIN(Stack<Integer> s){
            Queue<Integer> backup = new LinkedList<>();
            int minValue = s.pop();
            backup.add(minValue);
            while (!s.isEmpty()) {
                int next = s.pop();
                backup.add(next);
                minValue = Math.min(minValue, next);
            }

            while (!backup.isEmpty()) {
                if(backup.peek() !=minValue)
                    s.push(backup.remove());
                else
                    backup.remove();
            }
            while(!s.isEmpty()){
                backup.add(s.pop());
            }
            while (!backup.isEmpty()){
                s.push(backup.remove());
            }

            return minValue;
        }
    }
