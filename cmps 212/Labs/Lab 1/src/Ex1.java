public class Ex1 {
    public static void main(String[] args){
int[] a={1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
System.out.println(stdev(a));
    } public static double stdev(int[] a){
        int sum=0;
        for(int i=0;i<a.length;i++){
          sum=sum+a[i];
        }
        double avg=(sum*1.0)/a.length;
        double sum1=0;
        for(int j=0;j<a.length;j++){
            double diff=a[j]-avg;
            double square=Math.pow(diff,2);
            sum1=sum1+square;
        }
        double inside=(sum1*1.0)/(a.length-1);
        double sqrt=Math.sqrt(inside);
        return sqrt;
    }
}
