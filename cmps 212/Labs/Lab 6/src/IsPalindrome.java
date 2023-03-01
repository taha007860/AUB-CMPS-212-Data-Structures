import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class IsPalindrome {
        public static void main(String[] args) {
            Queue<Character> e = new LinkedList<>();
            Queue<Character> r = new LinkedList<>();
            Queue<Character> h = new LinkedList<>();//empty
            char[] a = {'n','o','o','n'};
            char[] b = {'a','n','o','o','n'};
            for(char i:a)
                e.add(i);
            for(char j:b)
                r.add(j);
            System.out.println(isPalindrome(e));
            System.out.println(isPalindrome(r));
            System.out.println(isPalindrome(h));
            System.out.println(e);
            System.out.println(r);
            System.out.println(h);
        }
        public static boolean isPalindrome(Queue<Character> a) {
            if (!a.isEmpty()) {
                Stack<Character> b = new Stack<Character>();
                for (char i : a)
                    b.add(i);
                for (char i : a) {
                    if (i != b.pop())
                        return false;
                }
            }
            return true;
        }

}
