public class CheckingAccount extends Account {
    private double overdraftLimit;
    public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit){
        super(id, balance, annualInterestRate);
        this.overdraftLimit=overdraftLimit;}
    public double getOverdraftLimit(){
        return overdraftLimit;
    }
}
