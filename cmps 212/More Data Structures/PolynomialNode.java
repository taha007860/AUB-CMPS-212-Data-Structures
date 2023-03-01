public class PolynomialNode {
   private int coef;
   private int exp;
   PolynomialNode next;
   public PolynomialNode(){
    this.coef = 0;
    this.exp = 0;
    this.next = null;
   }
   public PolynomialNode(int coef, int exp){
    this.next = null;
    this.coef = coef;
    this.exp = exp;
   }
   public PolynomialNode(int coef, int exp, PolynomialNode next){
    this.coef = coef;
    this.exp = exp;
    this.next = next;
   }
   public int getCoef(){
    return this.coef;
   }
   public int getExp(){
    return this.exp;
   }
   public void setCoef(int coef){
    this.coef = coef;
   }
   public void setExp(int exp){
    this.exp = exp;
   }
}
