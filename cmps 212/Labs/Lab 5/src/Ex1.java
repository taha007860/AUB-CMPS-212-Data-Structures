public class Ex1 {
        public static void main(String[] args) {
            System.out.println(isPalindrome("noon"));
            System.out.println(isPrime(11)+" "+isPrime(99));
            System.out.println(printSquares(7));}
        public static boolean isPalindrome(String s) {
            if(s.length() == 0 || s.length() == 1)
                return true;
            if(s.charAt(0) == s.charAt(s.length()-1))

                return isPalindrome(s.substring(1, s.length()-1));
            return false;
        }
        public static boolean isPrime(int n){
            return isPrime(n,2);
        }
        public static boolean isPrime(int n, int i)
        {
            if (n <= 2)
                return (n == 2) ? true : false;
            if (n % i == 0)
                return false;
            if (i * i > n)
                return true;
            return isPrime(n, i + 1);
        }
        public static String printSquares(int n) {
            return oddsSquared(n) + evensSquared("", n);
        }

        public static String evensSquared(String s, int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Illegal Argument");
            }

            if (n == 2) {
                return "4";
            } else if (n % 2 == 0) {

                return  evensSquared(s, n-1)+" "+n*n;
            } else {
                return evensSquared(s, n-1);
            }
        }

        public static String oddsSquared(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Illegal Argument");
            }

            if (n == 1) {
                return 1 + " ";
            } else if (n % 2 != 0) {
                return n * n + " " + oddsSquared(n - 1);
            } else {
                return oddsSquared(n - 1);
            }
        }
    }
