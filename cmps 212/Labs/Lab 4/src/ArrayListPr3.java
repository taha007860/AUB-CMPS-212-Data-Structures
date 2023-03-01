import java.util.*;
public class ArrayListPr3 {
    public static void removeInRange(ArrayList<String> a, String begin, String end){
        int size=a.size();
        for(int i=0;i<size;){
            if(i==0&&a.get(i).compareTo(begin)>=0&&a.get(i).compareTo(end)<=0){a.remove(i);size--;i++;}
            else if(a.get(i).compareTo(begin)>=0&&a.get(i).compareTo(end)<=0){a.remove(i);i--;size--;}
            else{i++;}
        }
    }
    public static void main(String[] args){
        String[] a={"to", "be", "or", "not", "to", "be", "that", "is" , "the", "question"};
        ArrayList<String> b=new ArrayList<>();
        String begin="free";
        String end="rich";
        for(String s: a){
            b.add(s);
        }
        removeInRange(b,begin,end);
        System.out.println(b);
    }
}
