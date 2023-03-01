import java.util.*;
public class Driver {
    public static void main(String[] args){
        String color="";
        double length=0;
        boolean LED=false;
        double price=0;
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        ChristmasTree[] christmasTree=new ChristmasTree[size];
        int sum=0;
        int count=0;
        double max=Double.MIN_VALUE;
        int size1=scan.nextInt();
            Ornament[] ornaments=new Ornament[size1];
            for(int s=0;s<ornaments.length;s++){
                String colororn=scan.next();
                String sizeorn=scan.next();
                double priceorn=scan.nextDouble();
                Ornament ornament=Ornament.getInstance(colororn,sizeorn,priceorn);
                ornaments[s]=ornament;}
            for(int i=0;i<christmasTree.length;i++){
            double height=scan.nextDouble();
            String type=scan.next();
            color=scan.next();
            length=scan.nextDouble();
            LED=scan.nextBoolean();
            price=scan.nextDouble();
            Light light=Light.getInstance(color,length,LED,price);
         ChristmasTree christmasTree1=ChristmasTree.getInstance(height,type,light,ornaments);
            christmasTree[i]=christmasTree1;}
        ChristmasTree treeMax=ChristmasTree.getInstance(0,"",null,null);
            ArrayList<ChristmasTree> expensiveTrees=new ArrayList<>();
            ArrayList<Integer> expensiveIndex=new ArrayList<>();
            for(int k=0;k<christmasTree.length;k++){
                if(christmasTree[k].totalPriceTree()>max){
                    max=christmasTree[k].totalPriceTree();}}
                for(int s=0;s<christmasTree.length;s++){
                if(max==christmasTree[s].totalPriceTree()){expensiveIndex.add(s);}}
                for(int l=0;l<expensiveIndex.size();l++){
                    expensiveTrees.add(christmasTree[expensiveIndex.get(l)]);}
             for(int k=0;k<christmasTree.length;k++){
            if(christmasTree[k].getType().equals("Pine")){Light l1=Light.getInstance(color,length,LED,price);
                l1=christmasTree[k].getLight(); l1.setLength(10).setColor("Green");}
            else if(christmasTree[k].getType().equals("Cedar")){Light l2=Light.getInstance(color,length,LED,price);
               l2=christmasTree[k].getLight(); l2.setLength(15).setColor("White");}
            else if(christmasTree[k].getType().equals("Fir")){Light l3=Light.getInstance(color,length,LED,price);
                l3=christmasTree[k].getLight(); l3.setLength(20).setColor("Green");}
            sum=sum+christmasTree[k].getOrnaments().length;
            for(int y=0;y<christmasTree[k].getOrnaments().length;y++){
                Ornament[] o=new Ornament[christmasTree[k].getOrnaments().length];
                o=christmasTree[k].getOrnaments();
                if(o[y].getSize().equals("S")){count++;}}
            }
            Arrays.sort(christmasTree);
            System.out.println(Arrays.toString(christmasTree));
            System.out.println("Number of Ornaments: "+sum);
             System.out.println("Number of small ornaments: "+count);
             System.out.println("details of expensive trees: "+expensiveTrees);
    }}

