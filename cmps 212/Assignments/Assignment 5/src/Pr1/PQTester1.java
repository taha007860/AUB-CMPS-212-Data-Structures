package Pr1;

import java.util.*;
    public class PQTester1 {
        public static void main(String[] args) {
            //construct an empty PQ
            SortedPQ<Integer, Student1> PQ2 = new SortedPQ<>(new intComparator());
            Student1 s1 = new Student1("Mike", "Smith");
            Student1 s2 = new Student1("Ali", "Ward");
            Student1 s3= new Student1("Hadi", "Audi");
            Student1 s4= new Student1("Laure", "Fani");
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
