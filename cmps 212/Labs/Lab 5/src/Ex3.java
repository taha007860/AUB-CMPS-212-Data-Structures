public class Ex3 {
    private static class Printer<T> {
        private T[] a;
        public Printer(T[] a) {
            this.a = a;
        }
        public void print(){
            System.out.print("[");
            for(int i =0;i<a.length-1;i++)
                System.out.print(a[i]+",");
            System.out.print(a[a.length-1]);
            System.out.println("]");
        }

        public static void main(String[] args) {
            Integer[] b={1,4,6,8};
            String[] c={"hi","hello","bye"};
            Double[] a ={3.0,4.0,5.0,4.065,6.5,65.5};
            Printer<Double> p1 = new Printer<>(a);
            Printer<Integer> p2=new Printer<>(b);
            Printer<String> p3=new Printer<>(c);
            p1.print();
            p2.print();
            p3.print();
        }
    }

}
