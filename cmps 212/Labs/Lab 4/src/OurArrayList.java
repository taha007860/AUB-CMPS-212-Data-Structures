import java.util.*;
public class OurArrayList {
    public static void scaleByK (ArrayList<Integer> a){
        int n=0;
        int k=0;
        int length=a.size();
        for(int i=0;i<length;){
            if(i==0&&a.get(i)<=0){a.remove(i);length--;i++;}
           else if(a.get(i)<=0){a.remove(i);i--;length--;}
        else{i++;}}
        int j=0;
        int count=0;
        int size=a.size();
        for(int i=0;i<size;){
            for(j=0;j<a.get(i)-1;j++){
             a.add(i,a.get(i));
            }
            size=size+a.get(i)-1;
            i=i+a.get(i);
            if(i==size-1){i=Integer.MAX_VALUE;
        }
        }}
    public static void markLength4(ArrayList<String> a){
        int size=a.size();
for(int i=0;i<size;){
if(a.get(i).length()==4){a.add(i,"****"); size++;i=i+2;}
else{i++;}
if(i==size-1){i=Integer.MAX_VALUE;}
}}
public static void main(String[] args){
  String[] w={"this","is","lots","of","fun","for","every","Java","programmer"};
  int[] b={-9,1,2,0,3};
  int[] d={3,-2,0,5,1,-3};
  ArrayList<Integer> c=new ArrayList<Integer>();
  ArrayList<Integer> u=new ArrayList<Integer>();
  ArrayList<String> m=new ArrayList<>();
  for(int x:b){
      c.add(x);
  }
  for(int y:d){
    u.add(y);
  }
  for(String f:w){
   m.add(f);
  }
  scaleByK(u);
  scaleByK(c);
  markLength4(m);
  System.out.println(m);
  System.out.println(u);
  System.out.println(c);
}}
