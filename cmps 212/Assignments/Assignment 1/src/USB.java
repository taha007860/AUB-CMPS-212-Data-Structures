public class USB extends Storage implements setup{
    private boolean rwLock;
    private int speed;
    public USB(String brand, int size, double price, boolean rwLock, int speed){
        super(brand, size, price);
       this.rwLock=rwLock;
       this.speed=speed;
    }
    public USB(){
        this("",0,0,false,0);
    }
    public boolean getRWLock(){
        return rwLock;
    }
    public int getSpeed(){
        return speed;
    }
    public USB setRwLock(boolean rwLock){
        this.rwLock=rwLock; return this;
    }
    public USB setSpeed(int speed){
        this.speed=speed; return this;
    }
    public String toString(){
       if(rwLock) return "USB storage device: \nBrand: "+getBrand()+"\nSize: "+getSize()+"\nPrice: "+getPrice()+"\nrwLock: USB key has a read/write lock\nSpeed: "+speed;
       else return "USB storage device: \nBrand: "+getBrand()+"\nSize: "+getSize()+"\nPrice: "+getPrice()+"\nrwLock: USB key doesn't have a read/write lock\nSpeed: "+speed;
    }
    public String getType(){
        return "Solid-state Storage device";
    }
}
