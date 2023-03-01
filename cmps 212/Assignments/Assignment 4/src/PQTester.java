import java.util.*;
    public class PQTester {
        public static void main(String[] args) {
            //construct an empty PQ
            SortedPQ<Integer, Student> PQ2 = new SortedPQ<>(new intComparator());
            Student s1 = new Student("Mike", "Smith");
            Student s2 = new Student("Ali", "Ward");
            Student s3= new Student("Hadi", "Audi");
            Student s4= new Student("Laure", "Fani");
            PQ2.insert(67, s1);
            PQ2.insert(89, s2);
            PQ2.insert(75, s3);
            PQ2.insert(50, s4);
            System.out.println(PQ2.exists(89));
            System.out.println(PQ2.exists(62));
            while (!PQ2.isEmpty())
                System.out.print(PQ2.removeMin().getValue().toString()+"; ");
            System.out.println();

        }
    }
