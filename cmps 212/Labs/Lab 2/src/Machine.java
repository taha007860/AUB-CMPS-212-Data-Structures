public class Machine {
    private String brandName;
    private boolean power;
    public Machine(String bN, boolean pow){
        brandName=bN;
        power=pow;
    }
    public Machine(){
      this("",false);
    }

    public String getBrandName() {
        return brandName;
    }

    public boolean getPower() {
        return power;
    }
    public void setBrandName(String name){
        brandName=name;
    }
    public void switchOn(){
        power=true;
    }
    public void switchOff(){
        power=false;
    }
    public void display(){
        if(power){System.out.println("On");}
        else{System.out.println("Off");}
    }
    public String toString(){
        String result = "Brand Name: "+brandName+"\nStatus: ";
        if(power){return result+"On";}
        else{return result+"Off";}
    }
}
