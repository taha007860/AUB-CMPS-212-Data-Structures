public class Employee {
        private int baseHours;
        private double baseSalary;
        private int baseVacationDays;
        private String baseVacationForm;
        private Account account;
        private SavingsAccount savingsAccount;
        private CheckingAccount checkingAccount;
        public Employee(Account account,SavingsAccount savingsAccount, CheckingAccount checkingAccount){
            baseSalary=40000;
            baseHours = 40;
            baseVacationDays=10;
            baseVacationForm="blue";
            this.account=account;
            this.savingsAccount=savingsAccount;
            this.checkingAccount=checkingAccount;
        }
        public int getBaseHours(){
            return baseHours;
        }
        public double getBaseSalary(){
            return baseSalary;
        }
        public int getBaseVacationDays(){
            return baseVacationDays;
        }
        public String getBaseVacationForm(){
            return baseVacationForm;
        }
        public Account getAccount() {return account;}
        public void setAccount(Account a){account=a;}
        public String toString(){
            if(checkingAccount!=null&&account!=null) return "An employee with a Checking account: \n\nThis is a Checking account\nAccount ID: "+account.getId()+"\nDate Created: "+account.getCalender()+"\nCurrent Balance: "+account.getBalance()+"\nAnnual Interest Rate: "+account.getAnnualInterestRate()+"\nMonthly Interest Amount: "+account.getMonthlyInterestAmount()+"\nOverdraft Limit: "+checkingAccount.getOverdraftLimit();
            else if(savingsAccount!=null&&account!=null) return "An employee with a Savings account: \n\nThis is a Savings account\nAccount ID: "+account.getId()+"\nDate Created: "+account.getCalender()+"\nCurrent Balance: "+account.getBalance()+"\nAnnual Interest Rate: "+account.getAnnualInterestRate()+"\nMonthly Interest Amount: "+account.getMonthlyInterestAmount()+"\nCredit Card Number: "+savingsAccount.getCreditCardNumber()+"\nCard Expiry Date: "+savingsAccount.getExpiryDate()+"\nCredit Balance: "+savingsAccount.getCreditBalance();
            else return "An employee with a regular account: \n\nThis is a regular account\nAccount ID: "+account.getId()+"\nDate Created: "+account.getCalender()+"\nCurrent Balance: "+account.getBalance()+"\nAnnual Interest Rate: "+account.getAnnualInterestRate()+"\nMonthly Interest Amount: "+account.getMonthlyInterestAmount();}
        public void setBaseHours(int bH){
            baseHours=bH;
        }
        public void setBaseSalary(double bS){
            baseSalary=bS;
        }
        public void setBaseVacationDays(int bVD){
            baseVacationDays=bVD;
        }
        public void setBaseVacationForm(String bVF){
            baseVacationForm=bVF;
        }
    }
