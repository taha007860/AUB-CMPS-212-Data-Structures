import java.util.Calendar;
public class SavingsAccount extends Account{
    private int creditCardNumber;
    private double creditBalance;
    private Calendar expiryDate;
    public SavingsAccount(int id, double balance, double annualInterestRate, int creditCardNumber){
        super(id, balance, annualInterestRate);
        this.creditCardNumber=creditCardNumber;
    }
    public double getCreditBalance(){
        return getBalance()*3;
    }
    public int getCreditCardNumber(){
        return creditCardNumber;
    }
    public Calendar getExpiryDate(){
        return expiryDate;
    }

}
