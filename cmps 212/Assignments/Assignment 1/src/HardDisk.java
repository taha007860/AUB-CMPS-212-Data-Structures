public class HardDisk extends Storage implements setup{
    private boolean SSD;
    public HardDisk(String brand, int size, double price, boolean SSD){
        super(brand,size,price);
        this.SSD=SSD;
    }
    public HardDisk(){
        this("",0,0,false);}
    public boolean getSSD(){
        return SSD;
    }
    public void set(boolean SSD){
        this.SSD=SSD;
    }
    public String toString(){
         return "Hard Disk storage device: \nBrand: "+getBrand()+"\nSize: "+getSize()+"\nPrice: "+getPrice()+"\nHDD type: "+getType();
    }
    public String getType(){
        if(SSD){return "SSD Storage device";}
        else{return "Magnetic Storage device";}
}

}
