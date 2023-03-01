import java.util.*;
public class Light {
    private String color;
    private double length;
    private boolean LED;
    private double price;
    private Light(String color,double length, boolean LED, double price){
        this.color=color;
        this.LED=LED;
        this.length=length;
        this.price=price;
    }
    public static Light getInstance(String color, double length, boolean LED, double price) {
        if(!(color.equals("Green")||color.equals("White"))){
            return null;}
        else if(length<0||price<0){ return null;}
        else if(!(LED==true||LED==false)){return null;}
        else{Light l=new Light(color,length,LED,price);
        return l;}
    }
    public String getColor(){
        return color;
    }
    public double getLength(){
        return length;
    }
    public boolean getLED(){
        return LED;
    }
    public double getPrice(){
        return price;
    }
    public String toString(){
        if(LED){
        return "Lights on wire: \nColor: "+color+"\nLength: "+length+"\nLED: yes\nPrice: "+price;}
        else {return "Lights on wire: \nColor: "+color+"\nLength: "+length+"\nLED: no\nPrice: "+price;}
    }
    public Light setColor(String color) {
        this.color=color;
        return this;
    }
    public Light setPrice(double price){
        this.price=price; return this;
    }
    public Light setLength(double length){
        this.length=length;
        return this;
    }
    public Light setLED(boolean LED){
        this.LED=LED;
        return this;
    }
}
