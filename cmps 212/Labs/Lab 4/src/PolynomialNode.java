public class PolynomialNode {
    private int coef;
    private int exp;
    private PolynomialNode next;
     PolynomialNode(){
        coef=0;
        exp=0;
        next=null;
    }
    PolynomialNode(int coef, int exp){
        this.coef=coef;
        this.exp=exp;
        next=null;
    }
    PolynomialNode(int coef, int exp, PolynomialNode next){
        this.coef=coef;
        this.exp=exp;
        this.next=next;
    }
    public int getCoef(){
        return coef;
    }
    public PolynomialNode getNext(){
        return next;
    }
    public int getExp(){
        return exp;
    }
    public void setCoef(int coef){
        this.coef=coef;
    }
    public void setExp(int exp){
        this.exp=exp;
    }


}
