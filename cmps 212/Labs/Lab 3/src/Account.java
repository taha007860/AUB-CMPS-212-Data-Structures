import java.util.Calendar;
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Calendar dateCreated;
    public Account(int id, double balance, double annualInterestRate){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
        dateCreated=Calendar.getInstance();
    }
    public Account(){
        this(0,0,0);
    }
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public Calendar getCalender(){
        return dateCreated;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate=annualInterestRate;
    }
    public double getMonthlyInterestRate(){
        return (annualInterestRate/100.0)/12.0;
    }
    public double getMonthlyInterestAmount(){
        return balance*getMonthlyInterestRate();}
    public void withdraw(double amount){
        balance=balance-amount;
    }
    public void deposit(double amount){
        balance=balance+amount;
    }
}
