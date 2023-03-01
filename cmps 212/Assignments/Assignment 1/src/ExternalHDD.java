public class ExternalHDD extends HardDisk{
    private int connectivity;
    private double totalPrice;
    private static int countInstances;
    private boolean SSD;
    private ExternalHDD(String brand, int size, double price, int connectivity){
        super(brand, size, price, false);//Magnetic Hard Disk Parent will have Magnetic external hard disk child
        this.SSD=false;
        countInstances++;
        this.connectivity=connectivity;}
    public static ExternalHDD getInstance(String brand, int size, double price, int connectivity){
        if(!(connectivity==1||connectivity==2)){
            return null;}
        else{ExternalHDD ex=new ExternalHDD(brand,size,price,connectivity);
        return ex;}}
    public ExternalHDD(){
        this("",0,0,0);
    }
    public ExternalHDD returnInstance(){
        ExternalHDD ex=new ExternalHDD(this.getBrand(),this.getSize(),this.getPrice(),this.getConnectivity());
        return ex;
    }
    public int getConnectivity(){
        return connectivity;
    }
    public int getCountInstances(){return countInstances;}
    public double getTotalPrice(){
        return totalPrice;
    }

    public void setConnectivity(int connectivity) {
        this.connectivity = connectivity;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice=totalPrice;
    }
    public String toString() {
        if (connectivity == 1)
            return "External HDD storage device: \nBrand: " + getBrand() + "\nSize: " + getSize() + "\nPrice: " + getPrice() + "\nHDD type: " + getType() + "\nConnectivity: USB\nTotal price of all external HDD created: " + getTotalPrice();
        else if (connectivity == 2)
            return "External HDD storage device: \nBrand: " + getBrand() + "\nSize: " + getSize() + "\nPrice: " + getPrice() + "\nHDD type: " + getType() + "\nConnectivity: Firewire\nTotal price of all external HDD created: " + getTotalPrice();
    else {
            throw new IllegalArgumentException("There is no button other than 1 and 2");
        }
    }

    public String getType(){
        return "External Magnetic storage device";
    }
}
