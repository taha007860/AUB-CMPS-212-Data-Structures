import java.util.List;
public class Polynomial {
    private PolynomialNode head;
    public Polynomial(){
        this.head = null;
    }
    public PolynomialNode getNode(){
        return this.head;
    }
    public boolean isEmpty(){
        if(this.head == null)
            return true;
        else 
            return false;
    }
    public void insert(int coef, int exp){
        PolynomialNode v = new PolynomialNode(coef, exp);
        v.next = this.head;
        this.head = v;
    }
    public void remove(){
        head = head.next;
    }
    public String toString(){
        if (head == null) 
            return "";
        else {
            String result = "" + head.getCoef() + "x^"+ head.getExp();
            PolynomialNode v = head.next;
           while(v != null) {
                    result += " + " + v.getCoef()+ "x^" + v.getExp();
                v = v.next;
           }
           result += head.getCoef();
           return result;
        }
    }
    public Polynomial add(Polynomial p){
        PolynomialNode start1 = null, cur1 = null, start2 = null, cur2 = null;
        int[] list1coef = { 5, 4, 2 };
        int[] list1pow = { 2, 1, 0 };
        int n = list1coef.length;
        int i = 0;
        while (n-- > 0) {
            int a = list1coef[i];
            int b = list1pow[i];
            PolynomialNode ptr = new PolynomialNode(a, b);
            if (start1 == null) {
                start1 = ptr;
                cur1 = ptr;
            }
            else {
                cur1.next = ptr;
                cur1 = ptr;
            }
            i++;
        }
        int[] list2coef = { -5, -5 };
        int[] list2pow = { 1, 0 };
        n = list2coef.length;
        i = 0;
        while (n-- > 0) {
            int a = list2coef[i];
            int b = list2pow[i];
           PolynomialNode ptr = new PolynomialNode(a, b);
            if (start2 == null) {
                start2 = ptr;
                cur2 = ptr;
            }
            else {
                cur2.next = ptr;
                cur2 = ptr;
            }
            i++;
        }
        Polynomial obj = new Polynomial();
        PolynomialNode sum = obj.addPolynomial(start1, start2);
        PolynomialNode v = sum;
        while (v != null) {
            System.out.print(v.getCoef() + "x^" + v.getExo());
            if (v.next != null)
                System.out.print(" + ");
                v = v.next;
        }
        System.out.println();
    }
    public int evaluate(int x) {
        int p = 0;
        int [] coef = new int [getExp()+1];
        for (int i = getExp(); i >= 0; i--)
            p = coef[i] + (x * p);
        return p;
    }
    public PolynomialTerm Derivative(){
        return new PolynomialNode(getExp() - 1,getExp() * getCoef());
    }
}
