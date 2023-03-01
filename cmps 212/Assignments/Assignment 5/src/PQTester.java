import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class PQTester {
    public static void main(String[] args) throws FileNotFoundException {
        HeapPQ<Integer, Student> test=new HeapPQ<>();
        test.insertForMin(12,null);
        test.insertForMin(41,null);
        test.insertForMin(35,null);
        test.insertForMin(56,null);
        test.insertForMin(71,null);
        test.insertForMin(52,null);
        test.insertForMin(40,null);
        test.insertForMin(84,null);
        test.insertForMin(60,null);
        test.insertForMin(78,null);
        test.insertForMin(99,null);
        test.insertForMin(66,null);
        System.out.println(test);
        test.replace(56,30);
        System.out.println(test);
        test.replace(35,88);
        System.out.println(test);
        // test.heapifyForMin();
        // System.out.println(test);
        HeapPQ<String, Student> ID = new HeapPQ<>(new stringLengthComparator());
        HeapPQ<Integer, Student> forConsecutive=new HeapPQ<>();
        HeapPQ<Integer, Student> forID=new HeapPQ<>();
        HeapPQ<String, Student> firstNamePQ=new HeapPQ<>(new stringLengthComparator());
        HeapPQ<String, Student> forFirstNamePQ=new HeapPQ<>(new stringLengthComparator());
        HeapPQ<String, Student> lastNamePQ=new HeapPQ<>(new stringLengthComparator());
        HeapPQ<String, Student> forLastNamePQ=new HeapPQ<>(new stringLengthComparator());
        HeapPQ<Double, Student> grade=new HeapPQ<>(new DefaultComparator<>());
        HeapPQ<Double, Student> forGrade=new HeapPQ<>(new DefaultComparator<>());
        File f=new File("C:\\Users\\USAID\\Downloads\\student.dat");
        Scanner scan=new Scanner(f);
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            System.out.println(line);
            Scanner forLine=new Scanner(line);
            String lastName=forLine.next();
            // System.out.println(lastName);
            String firstName=forLine.next();
            // System.out.println(firstName);
            String id=forLine.next();
            int IDNumber=Integer.parseInt(id);
            //int id=Integer.parseInt(IDNumber);
            //System.out.println(id);
            //System.out.println(IDNumber);
            double gradeAsPercentage=forLine.nextDouble();
            //System.out.println(gradeAsPercentage);
            String letterGrade=forLine.next();
            // System.out.println(letterGrade);
            Student student=new Student(firstName,lastName,IDNumber,id,gradeAsPercentage,letterGrade);
            System.out.println(student);
            ID.insertForMin(id,student);
            firstNamePQ.insertForMin(firstName,student);
            lastNamePQ.insertForMin(lastName,student);
            grade.insertForMin(gradeAsPercentage,student);
           // ID.insertForMax(id,student);
           // firstNamePQ.insertForMax(firstName,student);
           // lastNamePQ.insertForMax(lastName,student);
           // grade.insertForMax(gradeAsPercentage,student);
        }
        Student s1=new Student("Sanaa","AbedAlRazzack",678,"678",95.67,"A");
        Student s2=new Student("AbedAlRahman","Zaatari",890,"890",100,"A");
        Student s3=new Student("Hala","Zaatari",124,"124",85.56,"B");
        forConsecutive.insertForMin(1,s1);
        forConsecutive.insertForMin(2,s2);
        forConsecutive.insertForMin(3,s3);
        forID.insertForMin(456,s1);
        // forConsecutive.insertForMax(1,s1);
        // forConsecutive.insertForMax(2,s2);
        // forConsecutive.insertForMax(3,s3);
        //  forID.insertForMax(890,s1);
        System.out.println(forID);
        forID.insertForMin(567,s2);
        //  forID.insertForMax(567,s2);
        System.out.println(forID);
        forFirstNamePQ.insertForMin("Ahmad",s1);
        forFirstNamePQ.insertForMin("Ali",s2);
        forLastNamePQ.insertForMin("Flash",s1);
        forLastNamePQ.insertForMin("Clay",s2);
        forGrade.insertForMin(67.8,s1);
        forGrade.insertForMin(78.5,s2);
        System.out.println("**");
        while (!ID.isEmpty()){
            System.out.print(ID.removeMin().getValue()+"; ");
        }
        System.out.println();
        System.out.println();
        while (!firstNamePQ.isEmpty()){
            System.out.print(firstNamePQ.removeMin().getValue()+"; ");
        }
        System.out.println();
        System.out.println();
        while (!lastNamePQ.isEmpty()){
            System.out.print(lastNamePQ.removeMin().getValue()+"; ");
        }
        System.out.println();
        System.out.println();
        while (!grade.isEmpty()){
            System.out.print(grade.removeMin().getValue()+"; ");
        }
        System.out.println();
        System.out.println();
        forID.insertForMin(890,s1);
        forID.insertForMin(698,s2);
        forID.insertForMin(234,s1);
        //forID.insertForMax(698,s1);
        //forID.insertForMax(345,s2);
        // System.out.println(forID);
        // forID.insertForMax(987,s1);
        // System.out.println(forID);
        // forID.upHeapMin(forID.size()-1);
        //System.out.println(forID);
        //  forID.upHeapMax(forID.size()-1);
        //  forID.removeMax();
        //   System.out.println(forID);
        //  forID.downHeapMax(0);
        //  System.out.println(forID);
        // forID.downHeapMin(0);
        // System.out.println(forID);
        //forID.downHeapMax(0);
        //System.out.println(forID);
        //System.out.println(forID.removeMax().getKey());
        //  forID.heapSortMin();
        //  System.out.println(forID);
        forID.merge(forID);
        //  forID.heapSortMin();
        // System.out.println(forID.size());
        System.out.println(forID);
        // System.out.println(Arrays.toString(forID.toArray()));
        //  forID.replace(forID.getHeap().get(4).getKey(),561);
        //System.out.println(ID);
        // System.out.println(ID.isConsecutive());
        System.out.println(Arrays.toString(forConsecutive.toArray()));
        forConsecutive.merge(forID);
        System.out.println(forConsecutive);
        System.out.println(forConsecutive.isConsecutive());
      /*  firstNamePQ.merge(forFirstNamePQ);
        System.out.println(firstNamePQ.toStringGeneric());
        lastNamePQ.merge(lastNamePQ);
        System.out.println(lastNamePQ.toStringGeneric());
        grade.merge(forGrade);
        System.out.println(grade.toStringGeneric());*/


    }}
