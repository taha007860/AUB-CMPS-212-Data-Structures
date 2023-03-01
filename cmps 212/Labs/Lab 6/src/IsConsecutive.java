import java.util.Stack;
public class IsConsecutive {
        public static void main(String[] args) {
            Stack<Integer> a = new Stack<>();
            Stack<Integer> b = new Stack<>();
            int[]  m ={2, 8,-8,-8, 3, 19, 7, 3, 2, 42, 9, 3, 2, 7, 12, -8, 4};
            for(int i: m)
                a.add(i);
            int[]  n ={1,2,3,4,5,6,7,8,9,10};
            for(int j: n)
                b.add(j);
            System.out.println(isConsecutive(a));
            System.out.println(isConsecutive(b));
            System.out.println(a);
            System.out.println(b);
        }
        public static boolean isConsecutive(Stack<Integer> a){
            Stack<Integer> backup=new Stack<>();
            if (!a.isEmpty() && a.size() != 1) {
                int temp = a.pop();
                backup.push(temp);
                while (!a.isEmpty()) {
                    if (a.peek() > temp)
                        return false;
                    else
                        backup.push(a.pop());
                }
            }
            while (!backup.isEmpty()) {
                a.push(backup.pop());
            }

            return true;

        }
}
