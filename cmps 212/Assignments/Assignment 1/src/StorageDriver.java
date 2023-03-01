import java.util.*;
public class StorageDriver {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String totalPrice="";
        int n=scan.nextInt();
        Storage[] a=new Storage[n];
        for(int i=0;i<a.length;i++){
            String brand=scan.next();
            int size=scan.nextInt();
            double price=scan.nextDouble();
        String choice= scan.next();
        if(choice.equals("USB")){boolean rwLock=scan.nextBoolean();
            int speed=scan.nextInt();
            USB usb=new USB(brand,size,price,rwLock,speed);
            a[i]=usb;
        }
        else if(choice.equals("HardDisk")){boolean SSD=scan.nextBoolean();
            HardDisk hardDisk=new HardDisk(brand,size,price,SSD);
            a[i]=hardDisk;
    }
        else if(choice.equals("ExternalHDD")){
            int connectivity= scan.nextInt();
            ExternalHDD ex=ExternalHDD.getInstance(brand,size,price,connectivity);
            a[i]=ex;
            }
        else{throw new IllegalArgumentException("not a correct choice of storage devices");}
            if(a[i].getSize()>500){double decreasedPrice=(a[i].getPrice()*80.0)/100.0;
                a[i].setPrice(decreasedPrice);
            }}
        double sum=0;
        for(int j=0;j<a.length;j++){
            if(a[j] instanceof ExternalHDD){sum=sum+((ExternalHDD) a[j]).getPrice();}
        }
        for(int i=0;i<a.length;i++){
            if(a[i] instanceof ExternalHDD){((ExternalHDD) a[i]).setTotalPrice(sum);}
        }
        System.out.println(sum);
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            for(Storage z: a){
               System.out.print(z+"\n");
            }

}}
