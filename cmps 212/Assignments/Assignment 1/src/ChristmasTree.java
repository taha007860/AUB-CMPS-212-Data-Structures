import java.util.*;
public class ChristmasTree implements setup,Comparable<ChristmasTree>{
    private double height;
    private String type;
    private Light light;
    private Ornament[] ornaments;
    private ChristmasTree(double height, String type, Light light, Ornament[] ornaments){
        this.ornaments=ornaments;
        this.height=height;
        this.light=light;
        this.type=type;
    }
    public int compareTo(ChristmasTree other){
        if(this.height<=other.getHeight()){return -1;}
        else if(this.height>=other.getHeight()){return 1;}
        else return 0;
    }
    public static ChristmasTree getInstance(double height, String type, Light light, Ornament[] ornaments){
        if(height<0){return null;}
        else if(!(type.equals("Cedar")||type.equals("Pine")||type.equals("Fir"))){
            return null;}
        else if(ornaments.length!=3){throw new IllegalArgumentException();}
        else{ChristmasTree christmasTree=new ChristmasTree(height, type, light, ornaments);
            return christmasTree;
        }}
    public double totalPriceTree(){
        double sum=0;
     double s=light.getPrice();
     int d=ornaments.length;
     for(int i=0;i<d;i++){
     double h=ornaments[i].getPrice();
     sum=sum+h;}
     double totalPrice=s+sum;
     return totalPrice;
    }
    public double getHeight(){
        return height;
    }
    public String settingUp(){
        return "Assembling in progress...";
    }
    public String getType(){
        return type;
    }
    public Light getLight(){
        return light;
    }
    public Ornament[] getOrnaments(){
        return ornaments;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setLight(Light light){
        this.light=light;
    }
    public void setOrnaments(Ornament[] ornaments){
        this.ornaments=ornaments;
    }
    public String toString(){
        return "A Christmas Tree: \nHeight: "+height+"\nType: "+type+"\nOrnaments: "+Arrays.toString(ornaments)+"\nLight: \n"+light+"\nTree price: "+this.totalPriceTree();
    }
}
