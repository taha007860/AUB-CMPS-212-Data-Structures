//pr1:
import java.util.Scanner;
public class Ahmad{
public class Pr1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double x=scan.nextDouble();
        double y=scan.nextDouble();
        int a=scan.nextInt();
        int b=scan.nextInt();
        double quad=Math.pow(y,4);
        double root=Math.sqrt(x+2*y);
        double z=(x/quad)+(a-b)/(a+3*x)+root;
        System.out.println("Enter two double values x and y: "+x+" "+y);
        System.out.println("Enter two integer values a and b: "+a+" "+b);
        System.out.println("z is"+z);}}
//pr2:
public class Pr2{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        if(s.length()>1){throw new IllegalArgumentException("should be character");}
        else{
        char character=s.charAt(0);
        System.out.println("Enter a character: "+ character);
        if(Character.isLetter(character)){
            System.out.println(character+"is a letter");
            char after= (char) (character+3);
            char before=(char) (character -3);
            System.out.println("The character that comes after "+character
                    +"by 3 positions is"+after);
            System.out.println("The character that comes before"+ character
                    +"by 3 positions is"+before);}
else if((character+"").equals(".")||(character+"").equals("?")||(character+"").equals("!")||(character+"").equals(";")||(character+"").equals(":")){
            System.out.println(character+" is punctuation");}
else{System.out.println(character+" is unknown");}}}}}
