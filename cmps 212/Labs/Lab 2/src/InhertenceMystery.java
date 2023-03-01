public class InhertenceMystery {
    public static void main(String[] args){
        Lamp[] elements = {new Book2(), new Pen(), new Lamp(), new Sock()};
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
            elements[i].method1();
            System.out.println();
            elements[i].method2();
            System.out.println();
            System.out.println();}}}
/* Output:
sock
sock 1 book 2 lamp 2
book 2 lamp 2

sock
pen 1
lamp 2

lamp
lamp 1
lamp 2

sock
sock 1 lamp 2
lamp 2
*/