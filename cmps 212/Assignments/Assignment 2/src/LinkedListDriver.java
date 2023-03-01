import java.util.*;
public class LinkedListDriver {
 public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
       LinkedIntList list=new LinkedIntList();
       for(int i=0;i<size;i++){
           int value=scanner.nextInt();
           list.addFirst(value);}
           System.out.println(list.getSize());
       System.out.println(list);
       list.compress(3);
       System.out.println(list);
       list.removeEveryOther();
       System.out.println(list);
        list.compress(2);


    }}
