public class Polynomial {
    private static class PolynomialNode{
    private int coef;
    private int exp;
    private PolynomialNode next;
    public PolynomialNode(){
        this.coef=0;
        this.exp=0;
        next=null;
    }
    public PolynomialNode(int coef, int exp){
        this.coef=coef;
        this.exp=exp;
        next=null;
    }
    public PolynomialNode(int coef, int exp, PolynomialNode next){
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

    private PolynomialNode head;
    public Polynomial(){
        this.head=null;
    }
    public Polynomial(PolynomialNode head){
        this.head=head;
    }
    public boolean isEmpty(){
        if(head==null) return true;
        else return false;
    }
    public void insert(int coef,int exp){
        PolynomialNode v = new PolynomialNode(coef,exp);
        if (head==null)
            head=v;
        else{
            PolynomialNode current = head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=v;
        }
    }
    public void removeHead(){
    head=head.getNext();
    }
    public PolynomialNode getHead(){
        return head;}
    public void setHead(PolynomialNode head){
    this.head=head;}
    // return later
   /* public String forString(String header, String plus, String x, String result, PolynomialNode current){
        result="["+header;
        current=head.next;
        while (current!=null){result = result + plus + x;
            current=current.next;}
        result +="]";
        return result;}
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            String header="";
            String plus="";
            String x="";
            PolynomialNode current = head.next;
            if(head.getCoef()==0&&current.getCoef()!=0&&current.){header=""; plus=""; x="";
                String result = "[" + header;
                while( current != null) {
                    result = result + plus + x;
                    current = current.next;
                }
                result += "]";
                return result;}
            else if(head.getCoef()==1&&)
            String s=head.getCoef()+"x^"+head.getExp();
            String result = "[" + s;
            PolynomialNode current = head.next;
            while( current != null) {
                String d=current.getCoef()+"x^"+current.getExp();
                result = result + " + " + d;
                current = current.next;
            }
            result += "]";
            return result;
        }
    } */ // Think later (important) if coefficient or exponent is 0 or 1
    public String toString(){
        if (head == null) {
            return "[]";
        } else {
            PolynomialNode current=head;
            String result="[";
            while( current != null) {
                 result=result+current.getCoef()+"x^"+current.getExp()+"+";
                current = current.getNext();
            }
            result =result.substring(0,result.length()-1)+"]";

            return result;
        }
    }
   /* public void traversingList(Polynomial p, PolynomialNode head, PolynomialNode current){
        current=head;
        while(current!=null){
            current=current.getNext();
            add(p);
        }}*/
   /* public Polynomial add(Polynomial p) {
        int sum = 0;
        //if(head.getCoef()==-p.head.getCoef()&&head.getExp()==p.head.getExp()){remove();} Search: since head field is private but accessible
        if(head==null){Polynomial p1=new Polynomial();
            return p1;}
        else if(head.getCoef()==-p.getHead().getCoef()&&head.getExp()==p.getHead().getExp())
        {remove();traversingList(p,current,current.getNext());}
        else{int coefficient=head.getCoef()+p.getHead().getCoef();
            PolynomialNode headNew=new PolynomialNode(coefficient,head.getExp());
            traversingList(p,current,current.getNext());}}*/
      /* public Polynomial add(Polynomial p){
         PolynomialNode currentThis=this.head;
         PolynomialNode currentP=p.getHead();
         Polynomial polynomial=null;
         if(this==null&&p==null){return null;}
         else if(currentThis!=null&&currentP!=null){
         int maxThisEx=currentThis.getExp();
         PolynomialNode greaterEx=new PolynomialNode();
           while (currentThis != null) {
               currentThis = currentThis.getNext();
               if(currentThis.getNext().getExp()>maxThisEx){maxThisEx=currentThis.getNext().getExp();}}
           int maxPEx=currentP.getExp();
             while (currentP != null) {
                 currentP = currentP.getNext();
                 if(currentP.getNext().getCoef()>maxPEx){maxPEx=currentP.getNext().getExp();}}
             if(maxThisEx>maxPEx){greaterEx=new PolynomialNode(currentThis.getCoef(), maxThisEx);
              polynomial.insert(currentThis.getCoef(), maxThisEx);}
             else if(maxPEx>maxThisEx){greaterEx=new PolynomialNode(currentP.getCoef(), maxPEx);
                 polynomial.insert(currentP.getCoef(), maxPEx);}
             else{
                 if(currentThis.getExp()>currentP.getExp()&&currentP!=null&&currentThis!=null)
         {PolynomialNode p1=new PolynomialNode (this.getHead().getCoef(), this.getHead().getExp());
         polynomial=new Polynomial(p1);}
         else if(currentThis.getExp()<currentP.getExp()&&currentP!=null&&currentThis!=null)
           {PolynomialNode p1=new PolynomialNode (p.getHead().getCoef(), p.getHead().getExp());
               polynomial=new Polynomial(p1);}
         else if(currentThis.getExp()==-currentP.getExp()&&currentP!=null&&currentThis!=null)
           {polynomial=null;}
        }} return p;}}
*/
    public Polynomial add(Polynomial p){
        PolynomialNode s1 = this.head;
        PolynomialNode s2 = p.head;
        Polynomial result = this;
        while(s1 != null && s2!= null){
            if(s1.exp > s2.exp) {
                result.insert(s1.coef,s1.exp);
                s1=s1.next;
            }
            else if(s1.exp < s2.exp){
                result.insert(s2.coef,s2.exp);
                s2=s2.next;
            }
            else if (s1.coef == -s2.coef){
                    result.removeHead();
            }
            else{
                PolynomialNode s3=new PolynomialNode(s1.coef+s2.coef, s1.exp);
                result.insert(s3.coef,s3.exp);
                s2=s2.next;
                s1=s1.next;
        }}
        return result;
    }
    public int evaluate(int x){
        PolynomialNode current =head;
        int result=0;
        while(current!= null){
            result+= current.coef*Math.pow(x,current.exp);
            current=current.next;
        }
        return result;
    }

    public String parsePolynomialTerm(PolynomialNode p){
        if(p.exp>1)
            return ""+p.coef+"x^"+p.exp+"";
        else if(p.exp==1) return  ""+p.coef+"x";
        else return ""+p.coef+"";
    }
    public Polynomial derivative(){
        Polynomial p = new Polynomial();
        PolynomialNode node=head;
        while(node != null){
            p.insert(node.exp*node.coef,node.exp-1);
            node=node.next;
        }
        return p;
    }
    public static void main(String[] args){
        Polynomial p=new Polynomial();
        Polynomial s=new Polynomial();
        p.insert(-4, 2);
        s.insert(1,1);
        s.insert(4,2);
        s.insert(2,3);
        System.out.println(s);
        System.out.println(s.derivative());
        System.out.println(s.evaluate(1));
        System.out.println(s.add(p));


    }
}