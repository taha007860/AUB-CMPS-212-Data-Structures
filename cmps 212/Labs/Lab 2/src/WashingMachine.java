public class WashingMachine extends Machine{
    private String productionDate;
    private int capacity;
    public WashingMachine(String brand, boolean p, String pD,int c){
        super(brand,p);
        setBrandName(brand);
        productionDate=pD;
        capacity=c;
    } public WashingMachine(){
        this("",false, ""  , 0);
    }
    public String getProductionDate(){
        return productionDate;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setProductionDate(String setPD){
        productionDate=setPD;
    }
    public void setCapacity(int cap){
        capacity=cap;
    }
    public String toString(){
        return super.toString();
    }
    public boolean equals(Machine m){
        if(m instanceof WashingMachine){
            WashingMachine s=(WashingMachine) m;
            if(s.getBrandName().equals(this.getBrandName())&& this.productionDate.equals(s.productionDate)&& this.capacity==s.capacity){
                return true;
            }
        else return false;}
            else return false;}
        public int compareTo(WashingMachine w){
        if(this.getBrandName().compareTo(w.getBrandName())>0){return 1;}
        else if(this.getBrandName().compareTo(w.getBrandName())<0){return -1;}
        else{if(this.capacity>w.capacity){return 1;}
            else if(this.capacity<w.capacity){return -1;}
            else return 0;}
        }
    }

