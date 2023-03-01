public class Ex2 {
    public static void main(String[] args){
int[] a={3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12};
int[] b = {17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19};
System.out.println(longestSortedSequence(b));
System.out.println(longestSortedSequence(a));
    } public static int longestSortedSequence(int[] a){
        int n=0;
        int c=1;
        boolean b=true;
        int temp=Integer.MIN_VALUE;
        if(a.length==0){return 0;}
        if(a.length==1){return 1;}
        for(int i=n;i<a.length-1;i++){
        if(a[i]<=a[i+1]){c++;n=i+1;if(c>temp){temp=c;}}
        else{c=1;}}
        for(int i=0;i<a.length-1;i++){if(a[i]<=a[i+1]){b=false;}}
        if(b==true){return 1;}
        return temp;}
    }

