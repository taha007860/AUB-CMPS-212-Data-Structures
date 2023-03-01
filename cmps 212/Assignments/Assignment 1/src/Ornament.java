import java.util.*;
public class Ornament {
    private String color;
    private String size;
    private double price;
    private static int ornamentCount;
    private Ornament(String color,String size, double price){
        ornamentCount++;
        this.size=size;
        this.price=price;
        this.color=color;
    }
    public static Ornament getInstance(String color, String size, double price){
        if(!(color.equals("Red")||color.equals("Green")||color.equals("Gold"))){
            return null;
        }
        else if(!(size.equals("S")||size.equals("M")||size.equals("L"))){
            return null;
        }
        else if(price<0){
            return null;
        }
        else{Ornament o=new Ornament(color, size, price);
            return o;}
    }
    public String getColor(){
        return color;
    }
    public String getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public int getOrnamentCount(){
        return ornamentCount;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setSize(String size){
        this.size=size;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String toString(){
        return "An Ornament: \nColor: "+color+"\nSize: "+size+"\nPrice: "+price;
    }
        }
