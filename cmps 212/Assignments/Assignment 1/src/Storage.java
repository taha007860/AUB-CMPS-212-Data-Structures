public abstract class Storage implements setup,Comparable<Storage> {
    private String brand;
    private int size;
    private double price;
    public Storage(String brand, int size, double price){
        this.brand=brand;
        this.size=size;
        this.price=price;
    }public Storage(){
        this("",0,0);
    }
    public int compareTo(Storage other){
        if(this.getSize()<other.getSize()){return -1;}
        else if(this.getSize()>other.getSize()){return 1;}
        else{return 0;}
    }
    public String getBrand(){
        return brand;
    }

    public String settingUp(){
        return "Arriving at some port...";
    }
    public int getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public void setSize(int size){
        this.size=size;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String toString(){
        return "Storage device: \nBrand: "+brand+"\nSize: "+size+"\nPrice: "+price;
    }
    public abstract String getType();
}
